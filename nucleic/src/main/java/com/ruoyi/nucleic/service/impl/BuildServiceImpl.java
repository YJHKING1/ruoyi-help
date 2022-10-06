package com.ruoyi.nucleic.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.nucleic.mapper.BuildMapper;
import com.ruoyi.nucleic.domain.Build;
import com.ruoyi.nucleic.service.IBuildService;

/**
 * 楼栋Service业务层处理
 *
 * @author YJH
 * @date 2022-10-06
 */
@Service
public class BuildServiceImpl implements IBuildService {
    @Autowired
    private BuildMapper buildMapper;

    /**
     * 查询楼栋
     *
     * @param id 楼栋主键
     * @return 楼栋
     */
    @Override
    public Build selectBuildById(Long id) {
        return buildMapper.selectBuildById(id);
    }

    /**
     * 查询楼栋列表
     *
     * @param build 楼栋
     * @return 楼栋
     */
    @Override
    public List<Build> selectBuildList(Build build) {
        return buildMapper.selectBuildList(build);
    }

    /**
     * 新增楼栋
     *
     * @param build 楼栋
     * @return 结果
     */
    @Override
    public int insertBuild(Build build) {
            return buildMapper.insertBuild(build);
    }

    /**
     * 修改楼栋
     *
     * @param build 楼栋
     * @return 结果
     */
    @Override
    public int updateBuild(Build build) {
        return buildMapper.updateBuild(build);
    }

    /**
     * 批量删除楼栋
     *
     * @param ids 需要删除的楼栋主键
     * @return 结果
     */
    @Override
    public int deleteBuildByIds(Long[] ids) {
        return buildMapper.deleteBuildByIds(ids);
    }

    /**
     * 删除楼栋信息
     *
     * @param id 楼栋主键
     * @return 结果
     */
    @Override
    public int deleteBuildById(Long id) {
        return buildMapper.deleteBuildById(id);
    }
}
