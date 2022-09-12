package com.ruoyi.study.service.impl;

import com.ruoyi.study.domain.TeacherType;
import com.ruoyi.study.mapper.TeacherTypeMapper;
import com.ruoyi.study.service.ITeacherTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 教师类型Service业务层处理
 *
 * @author YJH
 * @date 2022-09-12
 */
@Service
public class TeacherTypeServiceImpl implements ITeacherTypeService {
    @Autowired
    private TeacherTypeMapper teacherTypeMapper;
    
    /**
     * 查询教师类型
     *
     * @param id 教师类型主键
     * @return 教师类型
     */
    @Override
    public TeacherType selectTeacherTypeById(Long id) {
        return teacherTypeMapper.selectTeacherTypeById(id);
    }
    
    /**
     * 查询教师类型列表
     *
     * @param teacherType 教师类型
     * @return 教师类型
     */
    @Override
    public List<TeacherType> selectTeacherTypeList(TeacherType teacherType) {
        return teacherTypeMapper.selectTeacherTypeList(teacherType);
    }
    
    /**
     * 新增教师类型
     *
     * @param teacherType 教师类型
     * @return 结果
     */
    @Override
    public int insertTeacherType(TeacherType teacherType) {
        return teacherTypeMapper.insertTeacherType(teacherType);
    }
    
    /**
     * 修改教师类型
     *
     * @param teacherType 教师类型
     * @return 结果
     */
    @Override
    public int updateTeacherType(TeacherType teacherType) {
        return teacherTypeMapper.updateTeacherType(teacherType);
    }
    
    /**
     * 批量删除教师类型
     *
     * @param ids 需要删除的教师类型主键
     * @return 结果
     */
    @Override
    public int deleteTeacherTypeByIds(Long[] ids) {
        return teacherTypeMapper.deleteTeacherTypeByIds(ids);
    }
    
    /**
     * 删除教师类型信息
     *
     * @param id 教师类型主键
     * @return 结果
     */
    @Override
    public int deleteTeacherTypeById(Long id) {
        return teacherTypeMapper.deleteTeacherTypeById(id);
    }
}
