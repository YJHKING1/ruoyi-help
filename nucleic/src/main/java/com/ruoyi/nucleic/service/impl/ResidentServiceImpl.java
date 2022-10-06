package com.ruoyi.nucleic.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.nucleic.mapper.ResidentMapper;
import com.ruoyi.nucleic.domain.Resident;
import com.ruoyi.nucleic.service.IResidentService;

/**
 * 住户Service业务层处理
 *
 * @author YJH
 * @date 2022-10-06
 */
@Service
public class ResidentServiceImpl implements IResidentService {
    @Autowired
    private ResidentMapper residentMapper;

    /**
     * 查询住户
     *
     * @param id 住户主键
     * @return 住户
     */
    @Override
    public Resident selectResidentById(Long id) {
        return residentMapper.selectResidentById(id);
    }

    /**
     * 查询住户列表
     *
     * @param resident 住户
     * @return 住户
     */
    @Override
    public List<Resident> selectResidentList(Resident resident) {
        return residentMapper.selectResidentList(resident);
    }

    /**
     * 新增住户
     *
     * @param resident 住户
     * @return 结果
     */
    @Override
    public int insertResident(Resident resident) {
            return residentMapper.insertResident(resident);
    }

    /**
     * 修改住户
     *
     * @param resident 住户
     * @return 结果
     */
    @Override
    public int updateResident(Resident resident) {
        return residentMapper.updateResident(resident);
    }

    /**
     * 批量删除住户
     *
     * @param ids 需要删除的住户主键
     * @return 结果
     */
    @Override
    public int deleteResidentByIds(Long[] ids) {
        return residentMapper.deleteResidentByIds(ids);
    }

    /**
     * 删除住户信息
     *
     * @param id 住户主键
     * @return 结果
     */
    @Override
    public int deleteResidentById(Long id) {
        return residentMapper.deleteResidentById(id);
    }
}
