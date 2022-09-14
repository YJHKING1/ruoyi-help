package com.ruoyi.study.domain;

import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生对象 student
 *
 * @author YJH
 * @date 2022-09-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    /**
     * $column.columnComment
     */
    private Long id;
    
    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String name;
    
    /**
     * 性别
     */
    @Excel(name = "性别")
    private String sex;
    
    /**
     * 学历
     */
    @Excel(name = "学历")
    private String educationId;
    private StudentEducation education;
    
    /**
     * 专业
     */
    @Excel(name = "专业")
    private String major;
    
    /**
     * 班级
     */
    @Excel(name = "班级")
    private Long clazzId;
    private Clazz clazz;
    
    /**
     * 微信
     */
    @Excel(name = "微信")
    private String wechat;
    
    /**
     * 电话
     */
    @Excel(name = "电话")
    private String phone;
    
    /**
     * 父母电话
     */
    @Excel(name = "父母电话")
    private String parentPhone;
}
