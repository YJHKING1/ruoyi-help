package com.ruoyi.study.mapper;

import com.ruoyi.study.domain.Clazz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 班级Mapper接口
 *
 * @author YJH
 * @date 2022-09-12
 */
@Mapper
public interface ClazzMapper {
    /**
     * 查询班级
     *
     * @param id 班级主键
     * @return 班级
     */
    public Clazz selectClazzById(Long id);
    
    /**
     * 查询班级列表
     *
     * @param clazz 班级
     * @return 班级集合
     */
    public List<Clazz> selectClazzList(Clazz clazz);
    
    /**
     * 新增班级
     *
     * @param clazz 班级
     * @return 结果
     */
    public int insertClazz(Clazz clazz);
    
    /**
     * 修改班级
     *
     * @param clazz 班级
     * @return 结果
     */
    public int updateClazz(Clazz clazz);
    
    /**
     * 删除班级
     *
     * @param id 班级主键
     * @return 结果
     */
    public int deleteClazzById(Long id);
    
    /**
     * 批量删除班级
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClazzByIds(Long[] ids);
}
