package com.ruoyi.study.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.study.domain.TeacherEmail;
import com.ruoyi.study.service.ITeacherEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 老师邮箱Controller
 *
 * @author YJH
 * @date 2022-09-13
 */
@RestController
@RequestMapping("/teacherEmail")
public class TeacherEmailController extends BaseController {
    @Autowired
    private ITeacherEmailService teacherEmailService;
    
    /**
     * 查询老师邮箱列表
     */
    @RequiresPermissions("study:email:list")
    @GetMapping("/list")
    public TableDataInfo list(TeacherEmail teacherEmail) {
        startPage();
        List<TeacherEmail> list = teacherEmailService.selectTeacherEmailList(teacherEmail);
        return getDataTable(list);
    }
    
    /**
     * 导出老师邮箱列表
     */
    @RequiresPermissions("study:email:export")
    @Log(title = "老师邮箱", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TeacherEmail teacherEmail) {
        List<TeacherEmail> list = teacherEmailService.selectTeacherEmailList(teacherEmail);
        ExcelUtil<TeacherEmail> util = new ExcelUtil<TeacherEmail>(TeacherEmail.class);
        util.exportExcel(response, list, "老师邮箱数据");
    }
    
    /**
     * 获取老师邮箱详细信息
     */
    @RequiresPermissions("study:email:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(teacherEmailService.selectTeacherEmailById(id));
    }
    
    /**
     * 新增老师邮箱
     */
    @RequiresPermissions("study:email:add")
    @Log(title = "老师邮箱", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeacherEmail teacherEmail) {
        return toAjax(teacherEmailService.insertTeacherEmail(teacherEmail));
    }
    
    /**
     * 修改老师邮箱
     */
    @RequiresPermissions("study:email:edit")
    @Log(title = "老师邮箱", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeacherEmail teacherEmail) {
        return toAjax(teacherEmailService.updateTeacherEmail(teacherEmail));
    }
    
    /**
     * 删除老师邮箱
     */
    @RequiresPermissions("study:email:remove")
    @Log(title = "老师邮箱", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(teacherEmailService.deleteTeacherEmailByIds(ids));
    }
}
