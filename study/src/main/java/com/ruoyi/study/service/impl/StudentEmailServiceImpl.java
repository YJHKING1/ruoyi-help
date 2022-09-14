package com.ruoyi.study.service.impl;

import com.ruoyi.study.domain.StudentEmail;
import com.ruoyi.study.mapper.StudentEmailMapper;
import com.ruoyi.study.service.IStudentEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生邮箱Service业务层处理
 *
 * @author YJH
 * @date 2022-09-13
 */
@Service
public class StudentEmailServiceImpl implements IStudentEmailService {
    @Autowired
    private StudentEmailMapper studentEmailMapper;
    
    /**
     * 查询学生邮箱
     *
     * @param id 学生邮箱主键
     * @return 学生邮箱
     */
    @Override
    public StudentEmail selectStudentEmailById(Long id) {
        return studentEmailMapper.selectStudentEmailById(id);
    }
    
    /**
     * 查询学生邮箱列表
     *
     * @param studentEmail 学生邮箱
     * @return 学生邮箱
     */
    @Override
    public List<StudentEmail> selectStudentEmailList(StudentEmail studentEmail) {
        return studentEmailMapper.selectStudentEmailList(studentEmail);
    }
    
    /**
     * 新增学生邮箱
     *
     * @param studentEmail 学生邮箱
     * @return 结果
     */
    @Override
    public int insertStudentEmail(StudentEmail studentEmail) {
        return studentEmailMapper.insertStudentEmail(studentEmail);
    }
    
    /**
     * 修改学生邮箱
     *
     * @param studentEmail 学生邮箱
     * @return 结果
     */
    @Override
    public int updateStudentEmail(StudentEmail studentEmail) {
        return studentEmailMapper.updateStudentEmail(studentEmail);
    }
    
    /**
     * 批量删除学生邮箱
     *
     * @param ids 需要删除的学生邮箱主键
     * @return 结果
     */
    @Override
    public int deleteStudentEmailByIds(Long[] ids) {
        return studentEmailMapper.deleteStudentEmailByIds(ids);
    }
    
    /**
     * 删除学生邮箱信息
     *
     * @param id 学生邮箱主键
     * @return 结果
     */
    @Override
    public int deleteStudentEmailById(Long id) {
        return studentEmailMapper.deleteStudentEmailById(id);
    }
}
