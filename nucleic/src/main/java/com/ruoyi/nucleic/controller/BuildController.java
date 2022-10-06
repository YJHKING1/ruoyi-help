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
import com.ruoyi.nucleic.domain.Build;
import com.ruoyi.nucleic.service.IBuildService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 楼栋Controller
 *
 * @author YJH
 * @date 2022-10-06
 */
@RestController
@RequestMapping("/build")
public class BuildController extends BaseController {
    @Autowired
    private IBuildService buildService;

/**
 * 查询楼栋列表
 */
@RequiresPermissions("nucleic:build:list")
@GetMapping("/list")
    public TableDataInfo list(Build build) {
        startPage();
        List<Build> list = buildService.selectBuildList(build);
        return getDataTable(list);
    }

    /**
     * 导出楼栋列表
     */
    @RequiresPermissions("nucleic:build:export")
    @Log(title = "楼栋", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Build build) {
        List<Build> list = buildService.selectBuildList(build);
        ExcelUtil<Build> util = new ExcelUtil<Build>(Build. class);
        util.exportExcel(response, list, "楼栋数据");
    }

    /**
     * 获取楼栋详细信息
     */
    @RequiresPermissions("nucleic:build:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(buildService.selectBuildById(id));
    }

    /**
     * 新增楼栋
     */
    @RequiresPermissions("nucleic:build:add")
    @Log(title = "楼栋", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Build build) {
        return toAjax(buildService.insertBuild(build));
    }

    /**
     * 修改楼栋
     */
    @RequiresPermissions("nucleic:build:edit")
    @Log(title = "楼栋", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Build build) {
        return toAjax(buildService.updateBuild(build));
    }

    /**
     * 删除楼栋
     */
    @RequiresPermissions("nucleic:build:remove")
    @Log(title = "楼栋", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(buildService.deleteBuildByIds(ids));
    }
}
