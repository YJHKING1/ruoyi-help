package com.ruoyi.study.domain;

import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 学生对象 student
 *
 * @author YJH
 * @date 2022-09-12
 */
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
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setEducationId(String educationId) {
        this.educationId = educationId;
    }
    
    public String getEducationId() {
        return educationId;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    public String getMajor() {
        return major;
    }
    
    public void setClazzId(Long clazzId) {
        this.clazzId = clazzId;
    }
    
    public Long getClazzId() {
        return clazzId;
    }
    
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
    
    public String getWechat() {
        return wechat;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }
    
    public String getParentPhone() {
        return parentPhone;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("sex", getSex())
                .append("educationId", getEducationId())
                .append("major", getMajor())
                .append("clazzId", getClazzId())
                .append("wechat", getWechat())
                .append("phone", getPhone())
                .append("parentPhone", getParentPhone())
                .toString();
    }
}
