package com.ruoyi.study.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.study.domain.ReserveType;
import com.ruoyi.study.service.IReserveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 帮扶问题类型Controller
 *
 * @author YJH
 * @date 2022-09-13
 */
@RestController
@RequestMapping("/reserveType")
public class ReserveTypeController extends BaseController {
    @Autowired
    private IReserveTypeService reserveTypeService;
    
    /**
     * 查询帮扶问题类型列表
     */
    @RequiresPermissions("study:type:list")
    @GetMapping("/list")
    public TableDataInfo list(ReserveType reserveType) {
        startPage();
        List<ReserveType> list = reserveTypeService.selectReserveTypeList(reserveType);
        return getDataTable(list);
    }
    
    /**
     * 导出帮扶问题类型列表
     */
    @RequiresPermissions("study:type:export")
    @Log(title = "帮扶问题类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReserveType reserveType) {
        List<ReserveType> list = reserveTypeService.selectReserveTypeList(reserveType);
        ExcelUtil<ReserveType> util = new ExcelUtil<ReserveType>(ReserveType.class);
        util.exportExcel(response, list, "帮扶问题类型数据");
    }
    
    /**
     * 获取帮扶问题类型详细信息
     */
    @RequiresPermissions("study:type:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(reserveTypeService.selectReserveTypeById(id));
    }
    
    /**
     * 新增帮扶问题类型
     */
    @RequiresPermissions("study:type:add")
    @Log(title = "帮扶问题类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReserveType reserveType) {
        return toAjax(reserveTypeService.insertReserveType(reserveType));
    }
    
    /**
     * 修改帮扶问题类型
     */
    @RequiresPermissions("study:type:edit")
    @Log(title = "帮扶问题类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReserveType reserveType) {
        return toAjax(reserveTypeService.updateReserveType(reserveType));
    }
    
    /**
     * 删除帮扶问题类型
     */
    @RequiresPermissions("study:type:remove")
    @Log(title = "帮扶问题类型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(reserveTypeService.deleteReserveTypeByIds(ids));
    }
}
