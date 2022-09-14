package com.ruoyi.study.service.impl;

import com.ruoyi.study.domain.Reserve;
import com.ruoyi.study.mapper.ReserveMapper;
import com.ruoyi.study.service.IReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 帮扶预约Service业务层处理
 *
 * @author YJH
 * @date 2022-09-13
 */
@Service
public class ReserveServiceImpl implements IReserveService {
    @Autowired
    private ReserveMapper reserveMapper;
    
    /**
     * 查询帮扶预约
     *
     * @param id 帮扶预约主键
     * @return 帮扶预约
     */
    @Override
    public Reserve selectReserveById(Long id) {
        return reserveMapper.selectReserveById(id);
    }
    
    /**
     * 查询帮扶预约列表
     *
     * @param reserve 帮扶预约
     * @return 帮扶预约
     */
    @Override
    public List<Reserve> selectReserveList(Reserve reserve) {
        return reserveMapper.selectReserveList(reserve);
    }
    
    /**
     * 新增帮扶预约
     *
     * @param reserve 帮扶预约
     * @return 结果
     */
    @Override
    public int insertReserve(Reserve reserve) {
        return reserveMapper.insertReserve(reserve);
    }
    
    /**
     * 修改帮扶预约
     *
     * @param reserve 帮扶预约
     * @return 结果
     */
    @Override
    public int updateReserve(Reserve reserve) {
        return reserveMapper.updateReserve(reserve);
    }
    
    /**
     * 批量删除帮扶预约
     *
     * @param ids 需要删除的帮扶预约主键
     * @return 结果
     */
    @Override
    public int deleteReserveByIds(Long[] ids) {
        return reserveMapper.deleteReserveByIds(ids);
    }
    
    /**
     * 删除帮扶预约信息
     *
     * @param id 帮扶预约主键
     * @return 结果
     */
    @Override
    public int deleteReserveById(Long id) {
        return reserveMapper.deleteReserveById(id);
    }
}
