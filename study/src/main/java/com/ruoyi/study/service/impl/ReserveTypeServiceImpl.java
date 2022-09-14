package com.ruoyi.study.service.impl;

import com.ruoyi.study.domain.ReserveType;
import com.ruoyi.study.mapper.ReserveTypeMapper;
import com.ruoyi.study.service.IReserveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 帮扶问题类型Service业务层处理
 *
 * @author YJH
 * @date 2022-09-13
 */
@Service
public class ReserveTypeServiceImpl implements IReserveTypeService {
    @Autowired
    private ReserveTypeMapper reserveTypeMapper;
    
    /**
     * 查询帮扶问题类型
     *
     * @param id 帮扶问题类型主键
     * @return 帮扶问题类型
     */
    @Override
    public ReserveType selectReserveTypeById(Long id) {
        return reserveTypeMapper.selectReserveTypeById(id);
    }
    
    /**
     * 查询帮扶问题类型列表
     *
     * @param reserveType 帮扶问题类型
     * @return 帮扶问题类型
     */
    @Override
    public List<ReserveType> selectReserveTypeList(ReserveType reserveType) {
        return reserveTypeMapper.selectReserveTypeList(reserveType);
    }
    
    /**
     * 新增帮扶问题类型
     *
     * @param reserveType 帮扶问题类型
     * @return 结果
     */
    @Override
    public int insertReserveType(ReserveType reserveType) {
        return reserveTypeMapper.insertReserveType(reserveType);
    }
    
    /**
     * 修改帮扶问题类型
     *
     * @param reserveType 帮扶问题类型
     * @return 结果
     */
    @Override
    public int updateReserveType(ReserveType reserveType) {
        return reserveTypeMapper.updateReserveType(reserveType);
    }
    
    /**
     * 批量删除帮扶问题类型
     *
     * @param ids 需要删除的帮扶问题类型主键
     * @return 结果
     */
    @Override
    public int deleteReserveTypeByIds(Long[] ids) {
        return reserveTypeMapper.deleteReserveTypeByIds(ids);
    }
    
    /**
     * 删除帮扶问题类型信息
     *
     * @param id 帮扶问题类型主键
     * @return 结果
     */
    @Override
    public int deleteReserveTypeById(Long id) {
        return reserveTypeMapper.deleteReserveTypeById(id);
    }
}
