package com.ruoyi.study.mapper;

import com.ruoyi.study.domain.ReserveType;

import java.util.List;

/**
 * 帮扶问题类型Mapper接口
 *
 * @author YJH
 * @date 2022-09-13
 */
public interface ReserveTypeMapper {
    /**
     * 查询帮扶问题类型
     *
     * @param id 帮扶问题类型主键
     * @return 帮扶问题类型
     */
    public ReserveType selectReserveTypeById(Long id);
    
    /**
     * 查询帮扶问题类型列表
     *
     * @param reserveType 帮扶问题类型
     * @return 帮扶问题类型集合
     */
    public List<ReserveType> selectReserveTypeList(ReserveType reserveType);
    
    /**
     * 新增帮扶问题类型
     *
     * @param reserveType 帮扶问题类型
     * @return 结果
     */
    public int insertReserveType(ReserveType reserveType);
    
    /**
     * 修改帮扶问题类型
     *
     * @param reserveType 帮扶问题类型
     * @return 结果
     */
    public int updateReserveType(ReserveType reserveType);
    
    /**
     * 删除帮扶问题类型
     *
     * @param id 帮扶问题类型主键
     * @return 结果
     */
    public int deleteReserveTypeById(Long id);
    
    /**
     * 批量删除帮扶问题类型
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReserveTypeByIds(Long[] ids);
}
