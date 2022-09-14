package com.ruoyi.study.service.impl;

import com.ruoyi.study.domain.Evaluation;
import com.ruoyi.study.mapper.EvaluationMapper;
import com.ruoyi.study.service.IEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评价Service业务层处理
 *
 * @author YJH
 * @date 2022-09-13
 */
@Service
public class EvaluationServiceImpl implements IEvaluationService {
    @Autowired
    private EvaluationMapper evaluationMapper;
    
    /**
     * 查询评价
     *
     * @param id 评价主键
     * @return 评价
     */
    @Override
    public Evaluation selectEvaluationById(Long id) {
        return evaluationMapper.selectEvaluationById(id);
    }
    
    /**
     * 查询评价列表
     *
     * @param evaluation 评价
     * @return 评价
     */
    @Override
    public List<Evaluation> selectEvaluationList(Evaluation evaluation) {
        return evaluationMapper.selectEvaluationList(evaluation);
    }
    
    /**
     * 新增评价
     *
     * @param evaluation 评价
     * @return 结果
     */
    @Override
    public int insertEvaluation(Evaluation evaluation) {
        return evaluationMapper.insertEvaluation(evaluation);
    }
    
    /**
     * 修改评价
     *
     * @param evaluation 评价
     * @return 结果
     */
    @Override
    public int updateEvaluation(Evaluation evaluation) {
        return evaluationMapper.updateEvaluation(evaluation);
    }
    
    /**
     * 批量删除评价
     *
     * @param ids 需要删除的评价主键
     * @return 结果
     */
    @Override
    public int deleteEvaluationByIds(Long[] ids) {
        return evaluationMapper.deleteEvaluationByIds(ids);
    }
    
    /**
     * 删除评价信息
     *
     * @param id 评价主键
     * @return 结果
     */
    @Override
    public int deleteEvaluationById(Long id) {
        return evaluationMapper.deleteEvaluationById(id);
    }
}
