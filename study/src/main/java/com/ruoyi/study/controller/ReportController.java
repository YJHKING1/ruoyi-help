package com.ruoyi.study.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.study.domain.Report;
import com.ruoyi.study.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 报表统计Controller
 *
 * @author YJH
 * @date 2022-09-12
 */
@RestController
@RequestMapping("/report")
public class ReportController extends BaseController {
    @Autowired
    private IReportService reportService;
    
    /**
     * 查询报表统计列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Report report) {
        startPage();
        List<Report> list = reportService.selectReportList(report);
        return getDataTable(list);
    }
    
    /**
     * 导出报表统计列表
     */
    @Log(title = "报表统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Report report) {
        List<Report> list = reportService.selectReportList(report);
        ExcelUtil<Report> util = new ExcelUtil<Report>(Report.class);
        util.exportExcel(response, list, "报表统计数据");
    }
    
    /**
     * 获取报表统计详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(reportService.selectReportById(id));
    }
    
    /**
     * 新增报表统计
     */
    @Log(title = "报表统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Report report) {
        return toAjax(reportService.insertReport(report));
    }
    
    /**
     * 修改报表统计
     */
    @Log(title = "报表统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Report report) {
        return toAjax(reportService.updateReport(report));
    }
    
    /**
     * 删除报表统计
     */
    @Log(title = "报表统计", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(reportService.deleteReportByIds(ids));
    }
}
