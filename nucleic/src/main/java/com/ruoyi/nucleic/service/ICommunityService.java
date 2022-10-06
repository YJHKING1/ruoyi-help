package com.ruoyi.nucleic.service;

import java.util.List;

import com.ruoyi.nucleic.domain.Community;

/**
 * 小区Service接口
 *
 * @author YJH
 * @date 2022-10-06
 */
public interface ICommunityService {
    /**
     * 查询小区
     *
     * @param id 小区主键
     * @return 小区
     */
    public Community selectCommunityById(Long id);

    /**
     * 查询小区列表
     *
     * @param community 小区
     * @return 小区集合
     */
    public List<Community> selectCommunityList(Community community);

    /**
     * 新增小区
     *
     * @param community 小区
     * @return 结果
     */
    public int insertCommunity(Community community);

    /**
     * 修改小区
     *
     * @param community 小区
     * @return 结果
     */
    public int updateCommunity(Community community);

    /**
     * 批量删除小区
     *
     * @param ids 需要删除的小区主键集合
     * @return 结果
     */
    public int deleteCommunityByIds(Long[] ids);

    /**
     * 删除小区信息
     *
     * @param id 小区主键
     * @return 结果
     */
    public int deleteCommunityById(Long id);
}
