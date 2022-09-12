package com.ruoyi.study.mapper;

import com.ruoyi.study.domain.StudentEducation;

import java.util.List;

/**
 * 学历Mapper接口
 *
 * @author YJH
 * @date 2022-09-12
 */
public interface StudentEducationMapper {
    /**
     * 查询学历
     *
     * @param id 学历主键
     * @return 学历
     */
    public StudentEducation selectStudentEducationById(Long id);
    
    /**
     * 查询学历列表
     *
     * @param studentEducation 学历
     * @return 学历集合
     */
    public List<StudentEducation> selectStudentEducationList(StudentEducation studentEducation);
    
    /**
     * 新增学历
     *
     * @param studentEducation 学历
     * @return 结果
     */
    public int insertStudentEducation(StudentEducation studentEducation);
    
    /**
     * 修改学历
     *
     * @param studentEducation 学历
     * @return 结果
     */
    public int updateStudentEducation(StudentEducation studentEducation);
    
    /**
     * 删除学历
     *
     * @param id 学历主键
     * @return 结果
     */
    public int deleteStudentEducationById(Long id);
    
    /**
     * 批量删除学历
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentEducationByIds(Long[] ids);
}
