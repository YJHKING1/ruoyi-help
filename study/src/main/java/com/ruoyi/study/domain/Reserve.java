package com.ruoyi.study.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 帮扶预约对象 reserve
 *
 * @author YJH
 * @date 2022-09-13
 */
@Data
public class Reserve extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String name;
    
    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;
    
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
     * 班级
     */
    @Excel(name = "班级")
    private Long clazzId;
    
    /**
     * 预约时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预约时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date proDate;
    
    /**
     * 问题类型
     */
    @Excel(name = "问题类型")
    private Long proTypeId;
    
    /**
     * 意向老师
     */
    @Excel(name = "意向老师")
    private Long teacherId;
    
    /**
     * 问题描述
     */
    @Excel(name = "问题描述")
    private String proText;
    private Clazz clazz;
    private Teacher teacher;
    private JobProblemType proType;
    
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
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
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
    
    public void setClazzId(Long clazzId) {
        this.clazzId = clazzId;
    }
    
    public Long getClazzId() {
        return clazzId;
    }
    
    public void setProDate(Date proDate) {
        this.proDate = proDate;
    }
    
    public Date getProDate() {
        return proDate;
    }
    
    public void setProTypeId(Long proTypeId) {
        this.proTypeId = proTypeId;
    }
    
    public Long getProTypeId() {
        return proTypeId;
    }
    
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
    
    public Long getTeacherId() {
        return teacherId;
    }
    
    public void setProText(String proText) {
        this.proText = proText;
    }
    
    public String getProText() {
        return proText;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("email", getEmail())
                .append("wechat", getWechat())
                .append("phone", getPhone())
                .append("clazzId", getClazzId())
                .append("proDate", getProDate())
                .append("proTypeId", getProTypeId())
                .append("teacherId", getTeacherId())
                .append("proText", getProText())
                .toString();
    }
}
