package com.ruoyi.study.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.study.domain.TeacherType;
import com.ruoyi.study.service.ITeacherTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 教师类型Controller
 *
 * @author YJH
 * @date 2022-09-12
 */
@RestController
@RequestMapping("/teacherType")
public class TeacherTypeController extends BaseController {
    @Autowired
    private ITeacherTypeService teacherTypeService;
    
    /**
     * 查询教师类型列表
     */
    @GetMapping("/list")
    public TableDataInfo list(TeacherType teacherType) {
        startPage();
        List<TeacherType> list = teacherTypeService.selectTeacherTypeList(teacherType);
        return getDataTable(list);
    }
    
    /**
     * 导出教师类型列表
     */
    @Log(title = "教师类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TeacherType teacherType) {
        List<TeacherType> list = teacherTypeService.selectTeacherTypeList(teacherType);
        ExcelUtil<TeacherType> util = new ExcelUtil<TeacherType>(TeacherType.class);
        util.exportExcel(response, list, "教师类型数据");
    }
    
    /**
     * 获取教师类型详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(teacherTypeService.selectTeacherTypeById(id));
    }
    
    /**
     * 新增教师类型
     */
    @Log(title = "教师类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeacherType teacherType) {
        return toAjax(teacherTypeService.insertTeacherType(teacherType));
    }
    
    /**
     * 修改教师类型
     */
    @Log(title = "教师类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeacherType teacherType) {
        return toAjax(teacherTypeService.updateTeacherType(teacherType));
    }
    
    /**
     * 删除教师类型
     */
    @Log(title = "教师类型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(teacherTypeService.deleteTeacherTypeByIds(ids));
    }
}
