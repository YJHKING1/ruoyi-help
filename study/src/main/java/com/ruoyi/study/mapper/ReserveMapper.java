package com.ruoyi.study.mapper;

import com.ruoyi.study.domain.Reserve;

import java.util.List;

/**
 * 帮扶预约Mapper接口
 *
 * @author YJH
 * @date 2022-09-13
 */
public interface ReserveMapper {
    /**
     * 查询帮扶预约
     *
     * @param id 帮扶预约主键
     * @return 帮扶预约
     */
    public Reserve selectReserveById(Long id);
    
    /**
     * 查询帮扶预约列表
     *
     * @param reserve 帮扶预约
     * @return 帮扶预约集合
     */
    public List<Reserve> selectReserveList(Reserve reserve);
    
    /**
     * 新增帮扶预约
     *
     * @param reserve 帮扶预约
     * @return 结果
     */
    public int insertReserve(Reserve reserve);
    
    /**
     * 修改帮扶预约
     *
     * @param reserve 帮扶预约
     * @return 结果
     */
    public int updateReserve(Reserve reserve);
    
    /**
     * 删除帮扶预约
     *
     * @param id 帮扶预约主键
     * @return 结果
     */
    public int deleteReserveById(Long id);
    
    /**
     * 批量删除帮扶预约
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReserveByIds(Long[] ids);
}
