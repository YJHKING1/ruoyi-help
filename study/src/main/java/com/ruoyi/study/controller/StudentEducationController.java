package com.ruoyi.study.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.study.domain.StudentEducation;
import com.ruoyi.study.service.IStudentEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 学历Controller
 *
 * @author YJH
 * @date 2022-09-12
 */
@RestController
@RequestMapping("/studentEducation")
public class StudentEducationController extends BaseController {
    @Autowired
    private IStudentEducationService studentEducationService;
    
    /**
     * 查询学历列表
     */
    @GetMapping("/list")
    public TableDataInfo list(StudentEducation studentEducation) {
        startPage();
        List<StudentEducation> list = studentEducationService.selectStudentEducationList(studentEducation);
        return getDataTable(list);
    }
    
    /**
     * 导出学历列表
     */
    @Log(title = "学历", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudentEducation studentEducation) {
        List<StudentEducation> list = studentEducationService.selectStudentEducationList(studentEducation);
        ExcelUtil<StudentEducation> util = new ExcelUtil<StudentEducation>(StudentEducation.class);
        util.exportExcel(response, list, "学历数据");
    }
    
    /**
     * 获取学历详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(studentEducationService.selectStudentEducationById(id));
    }
    
    /**
     * 新增学历
     */
    @Log(title = "学历", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudentEducation studentEducation) {
        return toAjax(studentEducationService.insertStudentEducation(studentEducation));
    }
    
    /**
     * 修改学历
     */
    @Log(title = "学历", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudentEducation studentEducation) {
        return toAjax(studentEducationService.updateStudentEducation(studentEducation));
    }
    
    /**
     * 删除学历
     */
    @Log(title = "学历", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(studentEducationService.deleteStudentEducationByIds(ids));
    }
}
