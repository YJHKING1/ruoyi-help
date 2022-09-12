package com.ruoyi.study.mapper;

import com.ruoyi.study.domain.Job;

import java.util.List;

/**
 * 就业帮扶Mapper接口
 *
 * @author YJH
 * @date 2022-09-12
 */
public interface JobMapper {
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
     * 删除就业帮扶
     *
     * @param id 就业帮扶主键
     * @return 结果
     */
    public int deleteJobById(Long id);
    
    /**
     * 批量删除就业帮扶
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJobByIds(Long[] ids);
}
