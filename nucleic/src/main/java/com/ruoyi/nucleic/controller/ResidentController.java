package com.ruoyi.nucleic.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.nucleic.domain.Resident;
import com.ruoyi.nucleic.service.IResidentService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 住户Controller
 *
 * @author YJH
 * @date 2022-10-06
 */
@RestController
@RequestMapping("/resident")
public class ResidentController extends BaseController {
    @Autowired
    private IResidentService residentService;

/**
 * 查询住户列表
 */
@RequiresPermissions("nucleic:resident:list")
@GetMapping("/list")
    public TableDataInfo list(Resident resident) {
        startPage();
        List<Resident> list = residentService.selectResidentList(resident);
        return getDataTable(list);
    }

    /**
     * 导出住户列表
     */
    @RequiresPermissions("nucleic:resident:export")
    @Log(title = "住户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Resident resident) {
        List<Resident> list = residentService.selectResidentList(resident);
        ExcelUtil<Resident> util = new ExcelUtil<Resident>(Resident. class);
        util.exportExcel(response, list, "住户数据");
    }

    /**
     * 获取住户详细信息
     */
    @RequiresPermissions("nucleic:resident:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(residentService.selectResidentById(id));
    }

    /**
     * 新增住户
     */
    @RequiresPermissions("nucleic:resident:add")
    @Log(title = "住户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Resident resident) {
        return toAjax(residentService.insertResident(resident));
    }

    /**
     * 修改住户
     */
    @RequiresPermissions("nucleic:resident:edit")
    @Log(title = "住户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Resident resident) {
        return toAjax(residentService.updateResident(resident));
    }

    /**
     * 删除住户
     */
    @RequiresPermissions("nucleic:resident:remove")
    @Log(title = "住户", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(residentService.deleteResidentByIds(ids));
    }
}
