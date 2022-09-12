package com.ruoyi.study.service.impl;

import com.ruoyi.study.domain.StudentEducation;
import com.ruoyi.study.mapper.StudentEducationMapper;
import com.ruoyi.study.service.IStudentEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学历Service业务层处理
 *
 * @author YJH
 * @date 2022-09-12
 */
@Service
public class StudentEducationServiceImpl implements IStudentEducationService {
    @Autowired
    private StudentEducationMapper studentEducationMapper;
    
    /**
     * 查询学历
     *
     * @param id 学历主键
     * @return 学历
     */
    @Override
    public StudentEducation selectStudentEducationById(Long id) {
        return studentEducationMapper.selectStudentEducationById(id);
    }
    
    /**
     * 查询学历列表
     *
     * @param studentEducation 学历
     * @return 学历
     */
    @Override
    public List<StudentEducation> selectStudentEducationList(StudentEducation studentEducation) {
        return studentEducationMapper.selectStudentEducationList(studentEducation);
    }
    
    /**
     * 新增学历
     *
     * @param studentEducation 学历
     * @return 结果
     */
    @Override
    public int insertStudentEducation(StudentEducation studentEducation) {
        return studentEducationMapper.insertStudentEducation(studentEducation);
    }
    
    /**
     * 修改学历
     *
     * @param studentEducation 学历
     * @return 结果
     */
    @Override
    public int updateStudentEducation(StudentEducation studentEducation) {
        return studentEducationMapper.updateStudentEducation(studentEducation);
    }
    
    /**
     * 批量删除学历
     *
     * @param ids 需要删除的学历主键
     * @return 结果
     */
    @Override
    public int deleteStudentEducationByIds(Long[] ids) {
        return studentEducationMapper.deleteStudentEducationByIds(ids);
    }
    
    /**
     * 删除学历信息
     *
     * @param id 学历主键
     * @return 结果
     */
    @Override
    public int deleteStudentEducationById(Long id) {
        return studentEducationMapper.deleteStudentEducationById(id);
    }
}
