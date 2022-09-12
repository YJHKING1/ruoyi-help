package com.ruoyi.study.mapper;

import com.ruoyi.study.domain.JobProblemType;

import java.util.List;

/**
 * 就业问题类型Mapper接口
 *
 * @author YJH
 * @date 2022-09-12
 */
public interface JobProblemTypeMapper {
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
     * 删除就业问题类型
     *
     * @param id 就业问题类型主键
     * @return 结果
     */
    public int deleteJobProblemTypeById(Long id);
    
    /**
     * 批量删除就业问题类型
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJobProblemTypeByIds(Long[] ids);
}
