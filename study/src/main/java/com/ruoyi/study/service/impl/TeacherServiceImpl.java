package com.ruoyi.study.service.impl;

import com.ruoyi.study.domain.Teacher;
import com.ruoyi.study.mapper.TeacherMapper;
import com.ruoyi.study.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 教师Service业务层处理
 *
 * @author YJH
 * @date 2022-09-12
 */
@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    
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
        return teacherMapper.selectTeacherList(teacher);
    }
    
    /**
     * 新增教师
     *
     * @param teacher 教师
     * @return 结果
     */
    @Override
    public int insertTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher);
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
}
