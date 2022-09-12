package com.ruoyi.study.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.study.domain.Student;
import com.ruoyi.study.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 学生Controller
 *
 * @author YJH
 * @date 2022-09-12
 */
@RestController
@RequestMapping("/student")
public class StudentController extends BaseController {
    @Autowired
    private IStudentService studentService;
    
    /**
     * 查询学生列表
     */
    @RequiresPermissions("study:student:list")
    @GetMapping("/list")
    public TableDataInfo list(Student student) {
        startPage();
        List<Student> list = studentService.selectStudentList(student);
        return getDataTable(list);
    }
    
    /**
     * 导出学生列表
     */
    @RequiresPermissions("study:student:export")
    @Log(title = "学生", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Student student) {
        List<Student> list = studentService.selectStudentList(student);
        ExcelUtil<Student> util = new ExcelUtil<Student>(Student.class);
        util.exportExcel(response, list, "学生数据");
    }
    
    /**
     * 获取学生详细信息
     */
    @RequiresPermissions("study:student:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(studentService.selectStudentById(id));
    }
    
    /**
     * 新增学生
     */
    @RequiresPermissions("study:student:add")
    @Log(title = "学生", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Student student) {
        return toAjax(studentService.insertStudent(student));
    }
    
    /**
     * 修改学生
     */
    @RequiresPermissions("study:student:edit")
    @Log(title = "学生", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Student student) {
        return toAjax(studentService.updateStudent(student));
    }
    
    /**
     * 删除学生
     */
    @RequiresPermissions("study:student:remove")
    @Log(title = "学生", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(studentService.deleteStudentByIds(ids));
    }
}
