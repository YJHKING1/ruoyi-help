package com.ruoyi.study.service.impl;

import com.ruoyi.study.domain.Job;
import com.ruoyi.study.mapper.JobMapper;
import com.ruoyi.study.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 就业帮扶Service业务层处理
 *
 * @author YJH
 * @date 2022-09-12
 */
@Service
public class JobServiceImpl implements IJobService {
    @Autowired
    private JobMapper jobMapper;
    
    /**
     * 查询就业帮扶
     *
     * @param id 就业帮扶主键
     * @return 就业帮扶
     */
    @Override
    public Job selectJobById(Long id) {
        return jobMapper.selectJobById(id);
    }
    
    /**
     * 查询就业帮扶列表
     *
     * @param job 就业帮扶
     * @return 就业帮扶
     */
    @Override
    public List<Job> selectJobList(Job job) {
        return jobMapper.selectJobList(job);
    }
    
    /**
     * 新增就业帮扶
     *
     * @param job 就业帮扶
     * @return 结果
     */
    @Override
    public int insertJob(Job job) {
        return jobMapper.insertJob(job);
    }
    
    /**
     * 修改就业帮扶
     *
     * @param job 就业帮扶
     * @return 结果
     */
    @Override
    public int updateJob(Job job) {
        return jobMapper.updateJob(job);
    }
    
    /**
     * 批量删除就业帮扶
     *
     * @param ids 需要删除的就业帮扶主键
     * @return 结果
     */
    @Override
    public int deleteJobByIds(Long[] ids) {
        return jobMapper.deleteJobByIds(ids);
    }
    
    /**
     * 删除就业帮扶信息
     *
     * @param id 就业帮扶主键
     * @return 结果
     */
    @Override
    public int deleteJobById(Long id) {
        return jobMapper.deleteJobById(id);
    }
}
