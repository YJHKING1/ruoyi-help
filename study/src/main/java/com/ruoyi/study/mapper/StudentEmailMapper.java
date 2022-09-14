package com.ruoyi.study.mapper;
import org.apache.ibatis.annotations.Param;

import com.ruoyi.study.domain.StudentEmail;

import java.util.List;

/**
 * 学生邮箱Mapper接口
 *
 * @author YJH
 * @date 2022-09-13
 */
public interface StudentEmailMapper {
    /**
     * 查询学生邮箱
     *
     * @param id 学生邮箱主键
     * @return 学生邮箱
     */
    public StudentEmail selectStudentEmailById(Long id);
    
    /**
     * 查询学生邮箱列表
     *
     * @param studentEmail 学生邮箱
     * @return 学生邮箱集合
     */
    public List<StudentEmail> selectStudentEmailList(StudentEmail studentEmail);
    
    /**
     * 新增学生邮箱
     *
     * @param studentEmail 学生邮箱
     * @return 结果
     */
    public int insertStudentEmail(StudentEmail studentEmail);
    
    /**
     * 修改学生邮箱
     *
     * @param studentEmail 学生邮箱
     * @return 结果
     */
    public int updateStudentEmail(StudentEmail studentEmail);
    
    /**
     * 删除学生邮箱
     *
     * @param id 学生邮箱主键
     * @return 结果
     */
    public int deleteStudentEmailById(Long id);
    
    /**
     * 批量删除学生邮箱
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentEmailByIds(Long[] ids);
    List<StudentEmail> selectByStudentId(@Param("studentId")Long studentId);
}
