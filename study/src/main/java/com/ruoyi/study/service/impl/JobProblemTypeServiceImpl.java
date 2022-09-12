package com.ruoyi.study.service.impl;

import com.ruoyi.study.domain.JobProblemType;
import com.ruoyi.study.mapper.JobProblemTypeMapper;
import com.ruoyi.study.service.IJobProblemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 就业问题类型Service业务层处理
 *
 * @author YJH
 * @date 2022-09-12
 */
@Service
public class JobProblemTypeServiceImpl implements IJobProblemTypeService {
    @Autowired
    private JobProblemTypeMapper jobProblemTypeMapper;
    
    /**
     * 查询就业问题类型
     *
     * @param id 就业问题类型主键
     * @return 就业问题类型
     */
    @Override
    public JobProblemType selectJobProblemTypeById(Long id) {
        return jobProblemTypeMapper.selectJobProblemTypeById(id);
    }
    
    /**
     * 查询就业问题类型列表
     *
     * @param jobProblemType 就业问题类型
     * @return 就业问题类型
     */
    @Override
    public List<JobProblemType> selectJobProblemTypeList(JobProblemType jobProblemType) {
        return jobProblemTypeMapper.selectJobProblemTypeList(jobProblemType);
    }
    
    /**
     * 新增就业问题类型
     *
     * @param jobProblemType 就业问题类型
     * @return 结果
     */
    @Override
    public int insertJobProblemType(JobProblemType jobProblemType) {
        return jobProblemTypeMapper.insertJobProblemType(jobProblemType);
    }
    
    /**
     * 修改就业问题类型
     *
     * @param jobProblemType 就业问题类型
     * @return 结果
     */
    @Override
    public int updateJobProblemType(JobProblemType jobProblemType) {
        return jobProblemTypeMapper.updateJobProblemType(jobProblemType);
    }
    
    /**
     * 批量删除就业问题类型
     *
     * @param ids 需要删除的就业问题类型主键
     * @return 结果
     */
    @Override
    public int deleteJobProblemTypeByIds(Long[] ids) {
        return jobProblemTypeMapper.deleteJobProblemTypeByIds(ids);
    }
    
    /**
     * 删除就业问题类型信息
     *
     * @param id 就业问题类型主键
     * @return 结果
     */
    @Override
    public int deleteJobProblemTypeById(Long id) {
        return jobProblemTypeMapper.deleteJobProblemTypeById(id);
    }
}
