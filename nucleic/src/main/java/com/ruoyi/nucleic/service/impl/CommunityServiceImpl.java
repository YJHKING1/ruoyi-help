package com.ruoyi.nucleic.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.nucleic.mapper.CommunityMapper;
import com.ruoyi.nucleic.domain.Community;
import com.ruoyi.nucleic.service.ICommunityService;

/**
 * 小区Service业务层处理
 *
 * @author YJH
 * @date 2022-10-06
 */
@Service
public class CommunityServiceImpl implements ICommunityService {
    @Autowired
    private CommunityMapper communityMapper;

    /**
     * 查询小区
     *
     * @param id 小区主键
     * @return 小区
     */
    @Override
    public Community selectCommunityById(Long id) {
        return communityMapper.selectCommunityById(id);
    }

    /**
     * 查询小区列表
     *
     * @param community 小区
     * @return 小区
     */
    @Override
    public List<Community> selectCommunityList(Community community) {
        return communityMapper.selectCommunityList(community);
    }

    /**
     * 新增小区
     *
     * @param community 小区
     * @return 结果
     */
    @Override
    public int insertCommunity(Community community) {
            return communityMapper.insertCommunity(community);
    }

    /**
     * 修改小区
     *
     * @param community 小区
     * @return 结果
     */
    @Override
    public int updateCommunity(Community community) {
        return communityMapper.updateCommunity(community);
    }

    /**
     * 批量删除小区
     *
     * @param ids 需要删除的小区主键
     * @return 结果
     */
    @Override
    public int deleteCommunityByIds(Long[] ids) {
        return communityMapper.deleteCommunityByIds(ids);
    }

    /**
     * 删除小区信息
     *
     * @param id 小区主键
     * @return 结果
     */
    @Override
    public int deleteCommunityById(Long id) {
        return communityMapper.deleteCommunityById(id);
    }
}
