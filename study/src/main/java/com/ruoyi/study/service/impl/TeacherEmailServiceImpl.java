package com.ruoyi.study.service.impl;

import com.ruoyi.study.domain.TeacherEmail;
import com.ruoyi.study.mapper.TeacherEmailMapper;
import com.ruoyi.study.service.ITeacherEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 老师邮箱Service业务层处理
 *
 * @author YJH
 * @date 2022-09-13
 */
@Service
public class TeacherEmailServiceImpl implements ITeacherEmailService {
    @Autowired
    private TeacherEmailMapper teacherEmailMapper;
    
    /**
     * 查询老师邮箱
     *
     * @param id 老师邮箱主键
     * @return 老师邮箱
     */
    @Override
    public TeacherEmail selectTeacherEmailById(Long id) {
        return teacherEmailMapper.selectTeacherEmailById(id);
    }
    
    /**
     * 查询老师邮箱列表
     *
     * @param teacherEmail 老师邮箱
     * @return 老师邮箱
     */
    @Override
    public List<TeacherEmail> selectTeacherEmailList(TeacherEmail teacherEmail) {
        return teacherEmailMapper.selectTeacherEmailList(teacherEmail);
    }
    
    /**
     * 新增老师邮箱
     *
     * @param teacherEmail 老师邮箱
     * @return 结果
     */
    @Override
    public int insertTeacherEmail(TeacherEmail teacherEmail) {
        return teacherEmailMapper.insertTeacherEmail(teacherEmail);
    }
    
    /**
     * 修改老师邮箱
     *
     * @param teacherEmail 老师邮箱
     * @return 结果
     */
    @Override
    public int updateTeacherEmail(TeacherEmail teacherEmail) {
        return teacherEmailMapper.updateTeacherEmail(teacherEmail);
    }
    
    /**
     * 批量删除老师邮箱
     *
     * @param ids 需要删除的老师邮箱主键
     * @return 结果
     */
    @Override
    public int deleteTeacherEmailByIds(Long[] ids) {
        return teacherEmailMapper.deleteTeacherEmailByIds(ids);
    }
    
    /**
     * 删除老师邮箱信息
     *
     * @param id 老师邮箱主键
     * @return 结果
     */
    @Override
    public int deleteTeacherEmailById(Long id) {
        return teacherEmailMapper.deleteTeacherEmailById(id);
    }
}
