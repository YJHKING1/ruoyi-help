package com.ruoyi.study.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.study.domain.Job;
import com.ruoyi.study.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 就业帮扶Controller
 *
 * @author YJH
 * @date 2022-09-12
 */
@RestController
@RequestMapping("/job")
public class JobController extends BaseController {
    @Autowired
    private IJobService jobService;
    
    /**
     * 查询就业帮扶列表
     */
    @RequiresPermissions("study:job:list")
    @GetMapping("/list")
    public TableDataInfo list(Job job) {
        startPage();
        List<Job> list = jobService.selectJobList(job);
        return getDataTable(list);
    }
    
    /**
     * 导出就业帮扶列表
     */
    @RequiresPermissions("study:job:export")
    @Log(title = "就业帮扶", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Job job) {
        List<Job> list = jobService.selectJobList(job);
        ExcelUtil<Job> util = new ExcelUtil<Job>(Job.class);
        util.exportExcel(response, list, "就业帮扶数据");
    }
    
    /**
     * 获取就业帮扶详细信息
     */
    @RequiresPermissions("study:job:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(jobService.selectJobById(id));
    }
    
    /**
     * 新增就业帮扶
     */
    @RequiresPermissions("study:job:add")
    @Log(title = "就业帮扶", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Job job) {
        return toAjax(jobService.insertJob(job));
    }
    
    /**
     * 修改就业帮扶
     */
    @RequiresPermissions("study:job:edit")
    @Log(title = "就业帮扶", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Job job) {
        return toAjax(jobService.updateJob(job));
    }
    
    /**
     * 删除就业帮扶
     */
    @RequiresPermissions("study:job:remove")
    @Log(title = "就业帮扶", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(jobService.deleteJobByIds(ids));
    }
}
