package com.ruoyi.nucleic.service;

import java.util.List;

import com.ruoyi.nucleic.domain.Resident;

/**
 * 住户Service接口
 *
 * @author YJH
 * @date 2022-10-06
 */
public interface IResidentService {
    /**
     * 查询住户
     *
     * @param id 住户主键
     * @return 住户
     */
    public Resident selectResidentById(Long id);

    /**
     * 查询住户列表
     *
     * @param resident 住户
     * @return 住户集合
     */
    public List<Resident> selectResidentList(Resident resident);

    /**
     * 新增住户
     *
     * @param resident 住户
     * @return 结果
     */
    public int insertResident(Resident resident);

    /**
     * 修改住户
     *
     * @param resident 住户
     * @return 结果
     */
    public int updateResident(Resident resident);

    /**
     * 批量删除住户
     *
     * @param ids 需要删除的住户主键集合
     * @return 结果
     */
    public int deleteResidentByIds(Long[] ids);

    /**
     * 删除住户信息
     *
     * @param id 住户主键
     * @return 结果
     */
    public int deleteResidentById(Long id);
}
