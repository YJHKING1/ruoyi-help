package com.ruoyi.study.service;

import com.ruoyi.study.domain.ReserveType;

import java.util.List;

/**
 * 帮扶问题类型Service接口
 *
 * @author YJH
 * @date 2022-09-13
 */
public interface IReserveTypeService {
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
     * 批量删除帮扶问题类型
     *
     * @param ids 需要删除的帮扶问题类型主键集合
     * @return 结果
     */
    public int deleteReserveTypeByIds(Long[] ids);
    
    /**
     * 删除帮扶问题类型信息
     *
     * @param id 帮扶问题类型主键
     * @return 结果
     */
    public int deleteReserveTypeById(Long id);
}
