package com.ruoyi.study.mapper;

import com.ruoyi.study.domain.Report;

import java.util.List;

/**
 * 报表统计Mapper接口
 *
 * @author YJH
 * @date 2022-09-12
 */
public interface ReportMapper {
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
     * 删除报表统计
     *
     * @param id 报表统计主键
     * @return 结果
     */
    public int deleteReportById(Long id);
    
    /**
     * 批量删除报表统计
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReportByIds(Long[] ids);
}
