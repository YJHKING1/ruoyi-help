package com.ruoyi.study.service;

import com.ruoyi.study.domain.Evaluation;

import java.util.List;

/**
 * 评价Service接口
 *
 * @author YJH
 * @date 2022-09-13
 */
public interface IEvaluationService {
    /**
     * 查询评价
     *
     * @param id 评价主键
     * @return 评价
     */
    public Evaluation selectEvaluationById(Long id);
    
    /**
     * 查询评价列表
     *
     * @param evaluation 评价
     * @return 评价集合
     */
    public List<Evaluation> selectEvaluationList(Evaluation evaluation);
    
    /**
     * 新增评价
     *
     * @param evaluation 评价
     * @return 结果
     */
    public int insertEvaluation(Evaluation evaluation);
    
    /**
     * 修改评价
     *
     * @param evaluation 评价
     * @return 结果
     */
    public int updateEvaluation(Evaluation evaluation);
    
    /**
     * 批量删除评价
     *
     * @param ids 需要删除的评价主键集合
     * @return 结果
     */
    public int deleteEvaluationByIds(Long[] ids);
    
    /**
     * 删除评价信息
     *
     * @param id 评价主键
     * @return 结果
     */
    public int deleteEvaluationById(Long id);
}
