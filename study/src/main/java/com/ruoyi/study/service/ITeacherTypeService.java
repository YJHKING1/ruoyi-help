package com.ruoyi.study.service;

import com.ruoyi.study.domain.TeacherType;

import java.util.List;

/**
 * 教师类型Service接口
 *
 * @author YJH
 * @date 2022-09-12
 */
public interface ITeacherTypeService {
    /**
     * 查询教师类型
     *
     * @param id 教师类型主键
     * @return 教师类型
     */
    public TeacherType selectTeacherTypeById(Long id);
    
    /**
     * 查询教师类型列表
     *
     * @param teacherType 教师类型
     * @return 教师类型集合
     */
    public List<TeacherType> selectTeacherTypeList(TeacherType teacherType);
    
    /**
     * 新增教师类型
     *
     * @param teacherType 教师类型
     * @return 结果
     */
    public int insertTeacherType(TeacherType teacherType);
    
    /**
     * 修改教师类型
     *
     * @param teacherType 教师类型
     * @return 结果
     */
    public int updateTeacherType(TeacherType teacherType);
    
    /**
     * 批量删除教师类型
     *
     * @param ids 需要删除的教师类型主键集合
     * @return 结果
     */
    public int deleteTeacherTypeByIds(Long[] ids);
    
    /**
     * 删除教师类型信息
     *
     * @param id 教师类型主键
     * @return 结果
     */
    public int deleteTeacherTypeById(Long id);
}
