package com.ruoyi.study.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.study.domain.StudentEmail;
import com.ruoyi.study.service.IStudentEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 学生邮箱Controller
 *
 * @author YJH
 * @date 2022-09-13
 */
@RestController
@RequestMapping("/studentEmail")
public class StudentEmailController extends BaseController {
    @Autowired
    private IStudentEmailService studentEmailService;
    
    /**
     * 查询学生邮箱列表
     */
    @RequiresPermissions("study:email:list")
    @GetMapping("/list")
    public TableDataInfo list(StudentEmail studentEmail) {
        startPage();
        List<StudentEmail> list = studentEmailService.selectStudentEmailList(studentEmail);
        return getDataTable(list);
    }
    
    /**
     * 导出学生邮箱列表
     */
    @RequiresPermissions("study:email:export")
    @Log(title = "学生邮箱", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudentEmail studentEmail) {
        List<StudentEmail> list = studentEmailService.selectStudentEmailList(studentEmail);
        ExcelUtil<StudentEmail> util = new ExcelUtil<StudentEmail>(StudentEmail.class);
        util.exportExcel(response, list, "学生邮箱数据");
    }
    
    /**
     * 获取学生邮箱详细信息
     */
    @RequiresPermissions("study:email:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(studentEmailService.selectStudentEmailById(id));
    }
    
    /**
     * 新增学生邮箱
     */
    @RequiresPermissions("study:email:add")
    @Log(title = "学生邮箱", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudentEmail studentEmail) {
        return toAjax(studentEmailService.insertStudentEmail(studentEmail));
    }
    
    /**
     * 修改学生邮箱
     */
    @RequiresPermissions("study:email:edit")
    @Log(title = "学生邮箱", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudentEmail studentEmail) {
        return toAjax(studentEmailService.updateStudentEmail(studentEmail));
    }
    
    /**
     * 删除学生邮箱
     */
    @RequiresPermissions("study:email:remove")
    @Log(title = "学生邮箱", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(studentEmailService.deleteStudentEmailByIds(ids));
    }
}
