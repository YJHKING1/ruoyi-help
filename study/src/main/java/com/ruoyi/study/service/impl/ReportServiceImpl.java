package com.ruoyi.study.service.impl;

import com.ruoyi.study.domain.Report;
import com.ruoyi.study.mapper.ReportMapper;
import com.ruoyi.study.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 报表统计Service业务层处理
 *
 * @author YJH
 * @date 2022-09-12
 */
@Service
public class ReportServiceImpl implements IReportService {
    @Autowired
    private ReportMapper reportMapper;
    
    /**
     * 查询报表统计
     *
     * @param id 报表统计主键
     * @return 报表统计
     */
    @Override
    public Report selectReportById(Long id) {
        return reportMapper.selectReportById(id);
    }
    
    /**
     * 查询报表统计列表
     *
     * @param report 报表统计
     * @return 报表统计
     */
    @Override
    public List<Report> selectReportList(Report report) {
        return reportMapper.selectReportList(report);
    }
    
    /**
     * 新增报表统计
     *
     * @param report 报表统计
     * @return 结果
     */
    @Override
    public int insertReport(Report report) {
        return reportMapper.insertReport(report);
    }
    
    /**
     * 修改报表统计
     *
     * @param report 报表统计
     * @return 结果
     */
    @Override
    public int updateReport(Report report) {
        return reportMapper.updateReport(report);
    }
    
    /**
     * 批量删除报表统计
     *
     * @param ids 需要删除的报表统计主键
     * @return 结果
     */
    @Override
    public int deleteReportByIds(Long[] ids) {
        return reportMapper.deleteReportByIds(ids);
    }
    
    /**
     * 删除报表统计信息
     *
     * @param id 报表统计主键
     * @return 结果
     */
    @Override
    public int deleteReportById(Long id) {
        return reportMapper.deleteReportById(id);
    }
}
