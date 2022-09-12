package com.ruoyi.study.service;

import com.ruoyi.study.domain.Student;

import java.util.List;

/**
 * 学生Service接口
 *
 * @author YJH
 * @date 2022-09-12
 */
public interface IStudentService {
    /**
     * 查询学生
     *
     * @param id 学生主键
     * @return 学生
     */
    public Student selectStudentById(Long id);
    
    /**
     * 查询学生列表
     *
     * @param student 学生
     * @return 学生集合
     */
    public List<Student> selectStudentList(Student student);
    
    /**
     * 新增学生
     *
     * @param student 学生
     * @return 结果
     */
    public int insertStudent(Student student);
    
    /**
     * 修改学生
     *
     * @param student 学生
     * @return 结果
     */
    public int updateStudent(Student student);
    
    /**
     * 批量删除学生
     *
     * @param ids 需要删除的学生主键集合
     * @return 结果
     */
    public int deleteStudentByIds(Long[] ids);
    
    /**
     * 删除学生信息
     *
     * @param id 学生主键
     * @return 结果
     */
    public int deleteStudentById(Long id);
}
