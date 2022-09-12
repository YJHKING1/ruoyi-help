package com.ruoyi.study.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.study.domain.Clazz;
import com.ruoyi.study.service.IClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 班级Controller
 *
 * @author YJH
 * @date 2022-09-12
 */
@RestController
@RequestMapping("/clazz")
public class ClazzController extends BaseController {
    @Autowired
    private IClazzService clazzService;
    
    /**
     * 查询班级列表
     */
    @RequiresPermissions("study:clazz:list")
    @GetMapping("/list")
    public TableDataInfo list(Clazz clazz) {
        startPage();
        List<Clazz> list = clazzService.selectClazzList(clazz);
        return getDataTable(list);
    }
    
    /**
     * 导出班级列表
     */
    @RequiresPermissions("study:clazz:export")
    @Log(title = "班级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Clazz clazz) {
        List<Clazz> list = clazzService.selectClazzList(clazz);
        ExcelUtil<Clazz> util = new ExcelUtil<Clazz>(Clazz.class);
        util.exportExcel(response, list, "班级数据");
    }
    
    /**
     * 获取班级详细信息
     */
    @RequiresPermissions("study:clazz:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(clazzService.selectClazzById(id));
    }
    
    /**
     * 新增班级
     */
    @RequiresPermissions("study:clazz:add")
    @Log(title = "班级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Clazz clazz) {
        return toAjax(clazzService.insertClazz(clazz));
    }
    
    /**
     * 修改班级
     */
    @RequiresPermissions("study:clazz:edit")
    @Log(title = "班级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Clazz clazz) {
        return toAjax(clazzService.updateClazz(clazz));
    }
    
    /**
     * 删除班级
     */
    @RequiresPermissions("study:clazz:remove")
    @Log(title = "班级", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(clazzService.deleteClazzByIds(ids));
    }
}
