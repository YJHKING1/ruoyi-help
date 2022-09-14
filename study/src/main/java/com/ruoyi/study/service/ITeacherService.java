package com.ruoyi.study.service;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.study.domain.Teacher;
import com.ruoyi.system.api.domain.SysUser;

import java.util.List;

/**
 * 教师Service接口
 *
 * @author YJH
 * @date 2022-09-12
 */
public interface ITeacherService {
    /**
     * 查询教师
     *
     * @param id 教师主键
     * @return 教师
     */
    public Teacher selectTeacherById(Long id);
    
    /**
     * 查询教师列表
     *
     * @param teacher 教师
     * @return 教师集合
     */
    public List<Teacher> selectTeacherList(Teacher teacher);
    
    /**
     * 新增教师
     *
     * @param teacher 教师
     * @return 结果
     */
    public int insertTeacher(Teacher teacher);
    
    /**
     * 修改教师
     *
     * @param teacher 教师
     * @return 结果
     */
    public int updateTeacher(Teacher teacher);
    
    /**
     * 批量删除教师
     *
     * @param ids 需要删除的教师主键集合
     * @return 结果
     */
    public int deleteTeacherByIds(Long[] ids);
    
    /**
     * 删除教师信息
     *
     * @param id 教师主键
     * @return 结果
     */
    public int deleteTeacherById(Long id);
    
    AjaxResult save(SysUser user);
}
