package com.ruoyi.study.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.study.domain.JobProblemType;
import com.ruoyi.study.service.IJobProblemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 就业问题类型Controller
 *
 * @author YJH
 * @date 2022-09-12
 */
@RestController
@RequestMapping("/jobProblemType")
public class JobProblemTypeController extends BaseController {
    @Autowired
    private IJobProblemTypeService jobProblemTypeService;
    
    /**
     * 查询就业问题类型列表
     */
    @GetMapping("/list")
    public TableDataInfo list(JobProblemType jobProblemType) {
        startPage();
        List<JobProblemType> list = jobProblemTypeService.selectJobProblemTypeList(jobProblemType);
        return getDataTable(list);
    }
    
    /**
     * 导出就业问题类型列表
     */
    @Log(title = "就业问题类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, JobProblemType jobProblemType) {
        List<JobProblemType> list = jobProblemTypeService.selectJobProblemTypeList(jobProblemType);
        ExcelUtil<JobProblemType> util = new ExcelUtil<JobProblemType>(JobProblemType.class);
        util.exportExcel(response, list, "就业问题类型数据");
    }
    
    /**
     * 获取就业问题类型详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(jobProblemTypeService.selectJobProblemTypeById(id));
    }
    
    /**
     * 新增就业问题类型
     */
    @Log(title = "就业问题类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JobProblemType jobProblemType) {
        return toAjax(jobProblemTypeService.insertJobProblemType(jobProblemType));
    }
    
    /**
     * 修改就业问题类型
     */
    @Log(title = "就业问题类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JobProblemType jobProblemType) {
        return toAjax(jobProblemTypeService.updateJobProblemType(jobProblemType));
    }
    
    /**
     * 删除就业问题类型
     */
    @Log(title = "就业问题类型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(jobProblemTypeService.deleteJobProblemTypeByIds(ids));
    }
}
