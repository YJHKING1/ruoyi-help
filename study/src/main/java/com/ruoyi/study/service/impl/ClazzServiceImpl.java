package com.ruoyi.study.service.impl;

import com.ruoyi.study.domain.Clazz;
import com.ruoyi.study.mapper.ClazzMapper;
import com.ruoyi.study.service.IClazzService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 班级Service业务层处理
 *
 * @author YJH
 * @date 2022-09-12
 */
@Service
public class ClazzServiceImpl implements IClazzService {
    @Resource
    private ClazzMapper clazzMapper;
    
    /**
     * 查询班级
     *
     * @param id 班级主键
     * @return 班级
     */
    @Override
    public Clazz selectClazzById(Long id) {
        return clazzMapper.selectClazzById(id);
    }
    
    /**
     * 查询班级列表
     *
     * @param clazz 班级
     * @return 班级
     */
    @Override
    public List<Clazz> selectClazzList(Clazz clazz) {
        return clazzMapper.selectClazzList(clazz);
    }
    
    /**
     * 新增班级
     *
     * @param clazz 班级
     * @return 结果
     */
    @Override
    public int insertClazz(Clazz clazz) {
        return clazzMapper.insertClazz(clazz);
    }
    
    /**
     * 修改班级
     *
     * @param clazz 班级
     * @return 结果
     */
    @Override
    public int updateClazz(Clazz clazz) {
        return clazzMapper.updateClazz(clazz);
    }
    
    /**
     * 批量删除班级
     *
     * @param ids 需要删除的班级主键
     * @return 结果
     */
    @Override
    public int deleteClazzByIds(Long[] ids) {
        return clazzMapper.deleteClazzByIds(ids);
    }
    
    /**
     * 删除班级信息
     *
     * @param id 班级主键
     * @return 结果
     */
    @Override
    public int deleteClazzById(Long id) {
        return clazzMapper.deleteClazzById(id);
    }
}
