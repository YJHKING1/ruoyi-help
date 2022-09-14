package com.ruoyi.study.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.study.domain.Evaluation;
import com.ruoyi.study.service.IEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 评价Controller
 *
 * @author YJH
 * @date 2022-09-13
 */
@RestController
@RequestMapping("/evaluation")
public class EvaluationController extends BaseController {
    @Autowired
    private IEvaluationService evaluationService;
    
    /**
     * 查询评价列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Evaluation evaluation) {
        startPage();
        List<Evaluation> list = evaluationService.selectEvaluationList(evaluation);
        return getDataTable(list);
    }
    
    /**
     * 导出评价列表
     */
    @Log(title = "评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Evaluation evaluation) {
        List<Evaluation> list = evaluationService.selectEvaluationList(evaluation);
        ExcelUtil<Evaluation> util = new ExcelUtil<Evaluation>(Evaluation.class);
        util.exportExcel(response, list, "评价数据");
    }
    
    /**
     * 获取评价详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(evaluationService.selectEvaluationById(id));
    }
    
    /**
     * 新增评价
     */
    @Log(title = "评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Evaluation evaluation) {
        return toAjax(evaluationService.insertEvaluation(evaluation));
    }
    
    /**
     * 修改评价
     */
    @Log(title = "评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Evaluation evaluation) {
        return toAjax(evaluationService.updateEvaluation(evaluation));
    }
    
    /**
     * 删除评价
     */
    @Log(title = "评价", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(evaluationService.deleteEvaluationByIds(ids));
    }
}
