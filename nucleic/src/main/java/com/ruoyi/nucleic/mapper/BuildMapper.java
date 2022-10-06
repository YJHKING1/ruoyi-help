package com.ruoyi.nucleic.mapper;

import java.util.List;

import com.ruoyi.nucleic.domain.Build;

/**
 * 楼栋Mapper接口
 *
 * @author YJH
 * @date 2022-10-06
 */
public interface BuildMapper {
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
     * 删除楼栋
     *
     * @param id 楼栋主键
     * @return 结果
     */
    public int deleteBuildById(Long id);

    /**
     * 批量删除楼栋
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBuildByIds(Long[] ids);
}
