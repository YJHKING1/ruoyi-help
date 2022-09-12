package com.ruoyi.study.service;

import com.ruoyi.study.domain.JobProblemType;

import java.util.List;

/**
 * 就业问题类型Service接口
 *
 * @author YJH
 * @date 2022-09-12
 */
public interface IJobProblemTypeService {
    /**
     * 查询就业问题类型
     *
     * @param id 就业问题类型主键
     * @return 就业问题类型
     */
    public JobProblemType selectJobProblemTypeById(Long id);
    
    /**
     * 查询就业问题类型列表
     *
     * @param jobProblemType 就业问题类型
     * @return 就业问题类型集合
     */
    public List<JobProblemType> selectJobProblemTypeList(JobProblemType jobProblemType);
    
    /**
     * 新增就业问题类型
     *
     * @param jobProblemType 就业问题类型
     * @return 结果
     */
    public int insertJobProblemType(JobProblemType jobProblemType);
    
    /**
     * 修改就业问题类型
     *
     * @param jobProblemType 就业问题类型
     * @return 结果
     */
    public int updateJobProblemType(JobProblemType jobProblemType);
    
    /**
     * 批量删除就业问题类型
     *
     * @param ids 需要删除的就业问题类型主键集合
     * @return 结果
     */
    public int deleteJobProblemTypeByIds(Long[] ids);
    
    /**
     * 删除就业问题类型信息
     *
     * @param id 就业问题类型主键
     * @return 结果
     */
    public int deleteJobProblemTypeById(Long id);
}
