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
import com.ruoyi.nucleic.domain.Community;
import com.ruoyi.nucleic.service.ICommunityService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 小区Controller
 *
 * @author YJH
 * @date 2022-10-06
 */
@RestController
@RequestMapping("/community")
public class CommunityController extends BaseController {
    @Autowired
    private ICommunityService communityService;

/**
 * 查询小区列表
 */
@RequiresPermissions("nucleic:community:list")
@GetMapping("/list")
    public TableDataInfo list(Community community) {
        startPage();
        List<Community> list = communityService.selectCommunityList(community);
        return getDataTable(list);
    }

    /**
     * 导出小区列表
     */
    @RequiresPermissions("nucleic:community:export")
    @Log(title = "小区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Community community) {
        List<Community> list = communityService.selectCommunityList(community);
        ExcelUtil<Community> util = new ExcelUtil<Community>(Community. class);
        util.exportExcel(response, list, "小区数据");
    }

    /**
     * 获取小区详细信息
     */
    @RequiresPermissions("nucleic:community:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(communityService.selectCommunityById(id));
    }

    /**
     * 新增小区
     */
    @RequiresPermissions("nucleic:community:add")
    @Log(title = "小区", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Community community) {
        return toAjax(communityService.insertCommunity(community));
    }

    /**
     * 修改小区
     */
    @RequiresPermissions("nucleic:community:edit")
    @Log(title = "小区", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Community community) {
        return toAjax(communityService.updateCommunity(community));
    }

    /**
     * 删除小区
     */
    @RequiresPermissions("nucleic:community:remove")
    @Log(title = "小区", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(communityService.deleteCommunityByIds(ids));
    }
}
