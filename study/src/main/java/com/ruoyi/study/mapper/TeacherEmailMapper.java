package com.ruoyi.study.mapper;
import org.apache.ibatis.annotations.Param;

import com.ruoyi.study.domain.TeacherEmail;

import java.util.List;

/**
 * 老师邮箱Mapper接口
 *
 * @author YJH
 * @date 2022-09-13
 */
public interface TeacherEmailMapper {
    /**
     * 查询老师邮箱
     *
     * @param id 老师邮箱主键
     * @return 老师邮箱
     */
    public TeacherEmail selectTeacherEmailById(Long id);
    
    /**
     * 查询老师邮箱列表
     *
     * @param teacherEmail 老师邮箱
     * @return 老师邮箱集合
     */
    public List<TeacherEmail> selectTeacherEmailList(TeacherEmail teacherEmail);
    
    /**
     * 新增老师邮箱
     *
     * @param teacherEmail 老师邮箱
     * @return 结果
     */
    public int insertTeacherEmail(TeacherEmail teacherEmail);
    
    /**
     * 修改老师邮箱
     *
     * @param teacherEmail 老师邮箱
     * @return 结果
     */
    public int updateTeacherEmail(TeacherEmail teacherEmail);
    
    /**
     * 删除老师邮箱
     *
     * @param id 老师邮箱主键
     * @return 结果
     */
    public int deleteTeacherEmailById(Long id);
    
    /**
     * 批量删除老师邮箱
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeacherEmailByIds(Long[] ids);
    List<TeacherEmail> selectByTeacherId(@Param("teacherId")Long teacherId);
}
