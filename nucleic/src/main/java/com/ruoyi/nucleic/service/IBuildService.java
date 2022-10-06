package com.ruoyi.nucleic.service;

import java.util.List;

import com.ruoyi.nucleic.domain.Build;

/**
 * 楼栋Service接口
 *
 * @author YJH
 * @date 2022-10-06
 */
public interface IBuildService {
    /**
     * 查询楼栋
     *
     * @param id 楼栋主键
     * @return 楼栋
     */
    public Build selectBuildById(Long id);

    /**
     * 查询楼栋列表
     *
     * @param build 楼栋
     * @return 楼栋集合
     */
    public List<Build> selectBuildList(Build build);

    /**
     * 新增楼栋
     *
     * @param build 楼栋
     * @return 结果
     */
    public int insertBuild(Build build);

    /**
     * 修改楼栋
     *
     * @param build 楼栋
     * @return 结果
     */
    public int updateBuild(Build build);

    /**
     * 批量删除楼栋
     *
     * @param ids 需要删除的楼栋主键集合
     * @return 结果
     */
    public int deleteBuildByIds(Long[] ids);

    /**
     * 删除楼栋信息
     *
     * @param id 楼栋主键
     * @return 结果
     */
    public int deleteBuildById(Long id);
}
