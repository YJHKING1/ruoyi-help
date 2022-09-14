package com.ruoyi.study.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.study.domain.Reserve;
import com.ruoyi.study.service.IReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 帮扶预约Controller
 *
 * @author YJH
 * @date 2022-09-13
 */
@RestController
@RequestMapping("/reserve")
public class ReserveController extends BaseController {
    @Autowired
    private IReserveService reserveService;
    
    /**
     * 查询帮扶预约列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Reserve reserve) {
        startPage();
        List<Reserve> list = reserveService.selectReserveList(reserve);
        return getDataTable(list);
    }
    
    /**
     * 导出帮扶预约列表
     */
    @Log(title = "帮扶预约", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Reserve reserve) {
        List<Reserve> list = reserveService.selectReserveList(reserve);
        ExcelUtil<Reserve> util = new ExcelUtil<Reserve>(Reserve.class);
        util.exportExcel(response, list, "帮扶预约数据");
    }
    
    /**
     * 获取帮扶预约详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(reserveService.selectReserveById(id));
    }
    
    /**
     * 新增帮扶预约
     */
    @Log(title = "帮扶预约", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Reserve reserve) {
        return toAjax(reserveService.insertReserve(reserve));
    }
    
    /**
     * 修改帮扶预约
     */
    @Log(title = "帮扶预约", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Reserve reserve) {
        return toAjax(reserveService.updateReserve(reserve));
    }
    
    /**
     * 删除帮扶预约
     */
    @Log(title = "帮扶预约", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(reserveService.deleteReserveByIds(ids));
    }
}
