package com.ruoyi.study.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.study.domain.Teacher;
import com.ruoyi.study.service.ITeacherService;
import com.ruoyi.system.api.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 教师Controller
 *
 * @author YJH
 * @date 2022-09-12
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController extends BaseController {
    @Autowired
    private ITeacherService teacherService;
    
    /**
     * 查询教师列表
     */
    @RequiresPermissions("study:teacher:list")
    @GetMapping("/list")
    public TableDataInfo list(Teacher teacher) {
        startPage();
        List<Teacher> list = teacherService.selectTeacherList(teacher);
        return getDataTable(list);
    }
    
    /**
     * 导出教师列表
     */
    @RequiresPermissions("study:teacher:export")
    @Log(title = "教师", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Teacher teacher) {
        List<Teacher> list = teacherService.selectTeacherList(teacher);
        ExcelUtil<Teacher> util = new ExcelUtil<Teacher>(Teacher.class);
        util.exportExcel(response, list, "教师数据");
    }
    
    /**
     * 获取教师详细信息
     */
    @RequiresPermissions("study:teacher:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(teacherService.selectTeacherById(id));
    }
    
    /**
     * 新增教师
     */
    @RequiresPermissions("study:teacher:add")
    @Log(title = "教师", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Teacher teacher) {
        return toAjax(teacherService.insertTeacher(teacher));
    }
    
    /**
     * 修改教师
     */
    @RequiresPermissions("study:teacher:edit")
    @Log(title = "教师", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Teacher teacher) {
        return toAjax(teacherService.updateTeacher(teacher));
    }
    
    /**
     * 删除教师
     */
    @RequiresPermissions("study:teacher:remove")
    @Log(title = "教师", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(teacherService.deleteTeacherByIds(ids));
    }
    
    @PostMapping("/save")
    public AjaxResult save(@RequestBody SysUser user) {
        return teacherService.save(user);
    }
}
