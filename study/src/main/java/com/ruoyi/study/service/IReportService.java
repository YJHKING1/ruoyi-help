package com.ruoyi.study.service;

import com.ruoyi.study.domain.Report;

import java.util.List;

/**
 * 报表统计Service接口
 *
 * @author YJH
 * @date 2022-09-12
 */
public interface IReportService {
    /**
     * 查询报表统计
     *
     * @param id 报表统计主键
     * @return 报表统计
     */
    public Report selectReportById(Long id);
    
    /**
     * 查询报表统计列表
     *
     * @param report 报表统计
     * @return 报表统计集合
     */
    public List<Report> selectReportList(Report report);
    
    /**
     * 新增报表统计
     *
     * @param report 报表统计
     * @return 结果
     */
    public int insertReport(Report report);
    
    /**
     * 修改报表统计
     *
     * @param report 报表统计
     * @return 结果
     */
    public int updateReport(Report report);
    
    /**
     * 批量删除报表统计
     *
     * @param ids 需要删除的报表统计主键集合
     * @return 结果
     */
    public int deleteReportByIds(Long[] ids);
    
    /**
     * 删除报表统计信息
     *
     * @param id 报表统计主键
     * @return 结果
     */
    public int deleteReportById(Long id);
}
