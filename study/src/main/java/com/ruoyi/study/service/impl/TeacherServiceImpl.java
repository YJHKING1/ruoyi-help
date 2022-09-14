package com.ruoyi.study.service.impl;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.study.domain.Report;
import com.ruoyi.study.domain.Teacher;
import com.ruoyi.study.domain.TeacherEmail;
import com.ruoyi.study.mapper.ReportMapper;
import com.ruoyi.study.mapper.TeacherEmailMapper;
import com.ruoyi.study.mapper.TeacherMapper;
import com.ruoyi.study.service.ITeacherService;
import com.ruoyi.system.api.domain.SysUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 教师Service业务层处理
 *
 * @author YJH
 * @date 2022-09-12
 */
@Service
public class TeacherServiceImpl implements ITeacherService {
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private TeacherEmailMapper teacherEmailMapper;
    @Resource
    private ReportMapper reportMapper;
    /**
     * 查询教师
     *
     * @param id 教师主键
     * @return 教师
     */
    @Override
    public Teacher selectTeacherById(Long id) {
        return teacherMapper.selectTeacherById(id);
    }
    
    /**
     * 查询教师列表
     *
     * @param teacher 教师
     * @return 教师
     */
    @Override
    public List<Teacher> selectTeacherList(Teacher teacher) {
        List<Teacher> teachers = teacherMapper.selectTeacherList(teacher);
        teachers.forEach(teacher1 -> {
            if (teacher1.getSex().equals("1")) {
                teacher1.setSex("男");
            } else if (teacher1.getSex().equals("0")) {
                teacher1.setSex("女");
            } else {
                teacher1.setSex("未知");
            }
        });
        return teachers;
    }
    
    /**
     * 新增教师
     *
     * @param teacher 教师
     * @return 结果
     */
    @Override
    public int insertTeacher(Teacher teacher) {
        teacherMapper.insertTeacher(teacher);
        saveReport(teacher.getId());
        return 1;
    }
    
    /**
     * 修改教师
     *
     * @param teacher 教师
     * @return 结果
     */
    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }
    
    /**
     * 批量删除教师
     *
     * @param ids 需要删除的教师主键
     * @return 结果
     */
    @Override
    public int deleteTeacherByIds(Long[] ids) {
        return teacherMapper.deleteTeacherByIds(ids);
    }
    
    /**
     * 删除教师信息
     *
     * @param id 教师主键
     * @return 结果
     */
    @Override
    public int deleteTeacherById(Long id) {
        return teacherMapper.deleteTeacherById(id);
    }
    
    @Override
    public AjaxResult save(SysUser user) {
        Teacher teacher = new Teacher();
        teacher.setName(user.getUserName());
        teacher.setPhone(user.getPhonenumber());
        teacher.setPriority(1L);
        teacher.setTypeId(1L);
        switch (user.getSex()) {
            case "0":
                teacher.setSex("1");
                break;
            case "1":
                teacher.setSex("0");
                break;
            default:
                break;
        }
        teacherMapper.insertTeacher(teacher);
        saveReport(teacher.getId());
        TeacherEmail teacherEmail = new TeacherEmail();
        teacherEmail.setTeacherId(teacher.getId());
        teacherEmail.setEmail(user.getEmail());
        teacherEmailMapper.insertTeacherEmail(teacherEmail);
        return AjaxResult.success();
    }
    private void saveReport(Long id) {
        Report report = new Report();
        report.setTeacherId(id);
        report.setHelpNum(0L);
        report.setScore(0L);
        report.setJobNum(0L);
        reportMapper.insertReport(report);
    }
}
