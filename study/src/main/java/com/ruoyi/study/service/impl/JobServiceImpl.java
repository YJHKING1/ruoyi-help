package com.ruoyi.study.service.impl;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.study.domain.*;
import com.ruoyi.study.dto.HelpDto;
import com.ruoyi.study.dto.JobDto;
import com.ruoyi.study.mapper.*;
import com.ruoyi.study.service.IJobService;
import com.ruoyi.study.util.StrUtils;
import com.ruoyi.study.util.TigerEncryptUtils;
import com.ruoyi.study.util.VerifyUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * 就业帮扶Service业务层处理
 *
 * @author YJH
 * @date 2022-09-12
 */
@Service
public class JobServiceImpl implements IJobService {
    @Resource
    private JobMapper jobMapper;
    @Resource
    private JobProblemTypeMapper jobProblemTypeMapper;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private StudentEmailMapper studentEmailMapper;
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private TeacherEmailMapper teacherEmailMapper;
    @Resource
    private TeacherTypeMapper teacherTypeMapper;
    @Resource
    private ReserveMapper reserveMapper;
    @Resource
    private ReserveTypeMapper reserveTypeMapper;
    @Resource
    private ClazzMapper clazzMapper;
    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private EvaluationMapper evaluationMapper;
    @Resource
    private ReportMapper reportMapper;
    private static final String MAIL_FROM = "910480155@qq.com";
    
    /**
     * 查询就业帮扶
     *
     * @param id 就业帮扶主键
     * @return 就业帮扶
     */
    @Override
    public Job selectJobById(Long id) {
        return jobMapper.selectJobById(id);
    }
    
    /**
     * 查询就业帮扶列表
     *
     * @param job 就业帮扶
     * @return 就业帮扶
     */
    @Override
    public List<Job> selectJobList(Job job) {
        return jobMapper.selectJobList(job);
    }
    
    /**
     * 新增就业帮扶
     *
     * @param job 就业帮扶
     * @return 结果
     */
    @Override
    public int insertJob(Job job) {
        return jobMapper.insertJob(job);
    }
    
    /**
     * 修改就业帮扶
     *
     * @param job 就业帮扶
     * @return 结果
     */
    @Override
    public int updateJob(Job job) {
        Job jobOld = jobMapper.selectJobById(job.getId());
        // 如果修改了教师id
        if (!jobOld.getTeacherId().equals(job.getTeacherId())) {
            List<TeacherEmail> teacherEmails = teacherEmailMapper.selectByTeacherId((long) job.getTeacherId());
            // 如果教师有邮箱
            if (teacherEmails.size() > 0) {
                String text = "<h1>您有新的帮扶移交!!!</h1><h2>点击链接处理，如果链接失效请手动复制进浏览器</h2>" +
                        "<a src='http://localhost/study/job'>http://localhost/study/job</a>";
                try {
                    sendEmail(MAIL_FROM, "您有新的帮扶移交", text, teacherEmails.get(0).getEmail());
                    System.out.println("发送移交提醒邮件成功");
                } catch (MessagingException e) {
                    System.out.println("发送移交提醒邮件失败");
                    e.printStackTrace();
                }
            }
        }
        
        // 如果帮扶完成
        if (job.getState() == 1) {
            List<StudentEmail> studentEmails = studentEmailMapper.selectByStudentId(job.getStudentId());
            // 如果学生有邮箱
            if (studentEmails.size() > 0) {
                String encrypt = TigerEncryptUtils.encrypt(job.getId().toString());
                String text = "<h1>您的预约已完成!!!</h1><h2>点击链接处理，如果链接失效请手动复制进浏览器</h2>" +
                        "<a src='http://localhost/evaluate?code=" + encrypt + "'>http://localhost/evaluate?code="
                        + encrypt + "</a>";
                try {
                    sendEmail(MAIL_FROM, "您的预约已完成", text, studentEmails.get(0).getEmail());
                    System.out.println("发送完成提醒邮件成功");
                } catch (MessagingException e) {
                    System.out.println("发送完成提醒邮件失败");
                    e.printStackTrace();
                }
            }
        }
        jobMapper.updateJob(job);
        return 1;
    }
    
    /**
     * 批量删除就业帮扶
     *
     * @param ids 需要删除的就业帮扶主键
     * @return 结果
     */
    @Override
    public int deleteJobByIds(Long[] ids) {
        return jobMapper.deleteJobByIds(ids);
    }
    
    /**
     * 删除就业帮扶信息
     *
     * @param id 就业帮扶主键
     * @return 结果
     */
    @Override
    public int deleteJobById(Long id) {
        return jobMapper.deleteJobById(id);
    }
    
    @Override
    public int saveHelp(HelpDto dto) {
        List<Student> students = studentMapper.selectByPhone(dto.getPhone());
        Student student;
        // 如果学生不存在
        if (students.size() < 1) {
            student = new Student();
            student.setName(dto.getName());
            student.setWechat(dto.getWechat());
            student.setPhone(dto.getPhone());
            studentMapper.insertStudent(student);
            StudentEmail studentEmail = new StudentEmail();
            studentEmail.setStudentId(student.getId());
            studentEmail.setEmail(dto.getEmail());
            studentEmailMapper.insertStudentEmail(studentEmail);
            // 如果学生存在
        } else {
            student = students.get(0);
        }
        
        Job job = new Job();
        
        job.setStudentId(student.getId());
        job.setReserveTime(dto.getProDate());
        job.setProblemTypeId(dto.getProType());
        job.setState(0);
        
        Reserve reserve = new Reserve();
        reserve.setName(dto.getName());
        reserve.setEmail(dto.getEmail());
        reserve.setWechat(dto.getWechat());
        reserve.setPhone(dto.getPhone());
        reserve.setClazzId(dto.getClazz());
        reserve.setProDate(dto.getProDate());
        reserve.setProTypeId(dto.getProType());
        reserve.setProText(dto.getProText());
        
        List<Teacher> teachers = teacherMapper.selectTeacherList(new Teacher());
        final Integer[] teacherId = {null};
        // 如果选择了教师
        if (VerifyUtils.hasLength(dto.getTeacher().toString())) {
            teacherId[0] = Math.toIntExact(dto.getTeacher());
            job.setTeacherId(dto.getTeacher());
            reserve.setTeacherId(dto.getTeacher());
            // 如果没选择教师但选择了班级
        } else if (VerifyUtils.hasLength(dto.getClazz().toString())) {
            Long studyTeacherId = clazzMapper.selectClazzById(dto.getClazz()).getStudyTeacherId();
            // 如果有技术老师
            if (VerifyUtils.hasLength(studyTeacherId.toString())) {
                teachers.forEach(teacher -> {
                    if (teacher.getId().equals(studyTeacherId)) {
                        teacherId[0] = Math.toIntExact(teacher.getId());
                        job.setTeacherId(teacher.getId());
                        reserve.setTeacherId(teacher.getId());
                    }
                });
                // 如果没有技术老师
            } else {
                teacherId[0] = StrUtils.getRandomNumber(teachers.size());
                job.setTeacherId(teachers.get(teacherId[0]).getId());
                reserve.setTeacherId(teachers.get(teacherId[0]).getId());
            }
            // 如果既没选择教师也没选择班级
        } else {
            teacherId[0] = StrUtils.getRandomNumber(teachers.size());
            job.setTeacherId(teachers.get(teacherId[0]).getId());
            reserve.setTeacherId(teachers.get(teacherId[0]).getId());
        }
        
        if (teacherId[0] != null) {
            List<TeacherEmail> teacherEmails = teacherEmailMapper.selectByTeacherId((long) teacherId[0]);
            // 如果教师有邮箱
            if (teacherEmails.size() > 0) {
                String text = "<h1>您有新的预约!!!</h1><h2>点击链接处理，如果链接失效请手动复制进浏览器</h2>" +
                        "<a src='http://localhost/study/job'>http://localhost/study/job</a>";
                try {
                    sendEmail(MAIL_FROM, "您有新的预约", text, teacherEmails.get(0).getEmail());
                    System.out.println("发送预约提醒邮件成功");
                } catch (MessagingException e) {
                    System.out.println("发送预约提醒邮件失败");
                    e.printStackTrace();
                }
            }
        }
        
        jobMapper.insertJob(job);
        reserveMapper.insertReserve(reserve);
        
        return 1;
    }
    
    @Override
    public int saveJob(JobDto dto) {
        Job job = jobMapper.selectJobById(dto.getId());
        Evaluation evaluation = new Evaluation();
        evaluation.setJobId(job.getId());
        evaluation.setEvaluateText(dto.getEvaluateText());
        evaluation.setScore(dto.getScore());
        evaluation.setTeacherId(job.getTeacherId());
        return evaluationMapper.insertEvaluation(evaluation);
    }
    
    @Override
    public Job getJobFinal(String id) {
        return jobMapper.selectJobById(Long.valueOf(TigerEncryptUtils.decrypt(id)));
    }
    
    @Override
    public AjaxResult jobTask() {
        List<Evaluation> evaluations = evaluationMapper.selectJob();
        List<Report> reports = reportMapper.selectReportList(null);
        evaluations.forEach(evaluation -> {
            reports.forEach(report -> {
                if (evaluation.getTeacherId().equals(report.getTeacherId())) {
                    report.setHelpNum(Long.valueOf(evaluation.getCountNum()));
                    report.setJobNum(Long.valueOf(evaluation.getCountNum()));
                    report.setScore(evaluation.getScoreAvg());
                    reportMapper.updateByTeacherId(report, report.getTeacherId());
                }
            });
        });
        return AjaxResult.success();
    }
    
    private void sendEmail(String from, String subject, String text, String to) throws MessagingException {
        // 创建复杂邮件对象
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // 发送复杂邮件的工具类
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
        // 发件人
        helper.setFrom(from);
        // 主题
        helper.setSubject(subject);
        // 内容
        helper.setText(text, true);
        // 收件人
        helper.setTo(to);
        // 发送邮件
        javaMailSender.send(mimeMessage);
    }
}
