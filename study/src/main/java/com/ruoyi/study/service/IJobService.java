package com.ruoyi.study.service;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.study.domain.Job;
import com.ruoyi.study.dto.HelpDto;
import com.ruoyi.study.dto.JobDto;

import java.util.List;

/**
 * 就业帮扶Service接口
 *
 * @author YJH
 * @date 2022-09-12
 */
public interface IJobService {
    /**
     * 查询就业帮扶
     *
     * @param id 就业帮扶主键
     * @return 就业帮扶
     */
    public Job selectJobById(Long id);
    
    /**
     * 查询就业帮扶列表
     *
     * @param job 就业帮扶
     * @return 就业帮扶集合
     */
    public List<Job> selectJobList(Job job);
    
    /**
     * 新增就业帮扶
     *
     * @param job 就业帮扶
     * @return 结果
     */
    public int insertJob(Job job);
    
    /**
     * 修改就业帮扶
     *
     * @param job 就业帮扶
     * @return 结果
     */
    public int updateJob(Job job);
    
    /**
     * 批量删除就业帮扶
     *
     * @param ids 需要删除的就业帮扶主键集合
     * @return 结果
     */
    public int deleteJobByIds(Long[] ids);
    
    /**
     * 删除就业帮扶信息
     *
     * @param id 就业帮扶主键
     * @return 结果
     */
    public int deleteJobById(Long id);
    
    int saveHelp(HelpDto dto);
    
    int saveJob(JobDto dto);
    
    Job getJobFinal(String id);
    
    AjaxResult jobTask();
}
