package com.ruoyi.study.domain;

import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 教师对象 teacher
 *
 * @author YJH
 * @date 2022-09-12
 */
public class Teacher extends BaseEntity {
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
     * 电话
     */
    @Excel(name = "电话")
    private String phone;
    
    /**
     * 帮扶优先级
     */
    @Excel(name = "帮扶优先级")
    private Long priority;
    
    /**
     * 老师类型
     */
    @Excel(name = "老师类型")
    private Long typeId;
    
    /**
     * 性别
     */
    @Excel(name = "性别")
    private String sex;
    
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
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPriority(Long priority) {
        this.priority = priority;
    }
    
    public Long getPriority() {
        return priority;
    }
    
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
    
    public Long getTypeId() {
        return typeId;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getSex() {
        return sex;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("phone", getPhone())
                .append("priority", getPriority())
                .append("typeId", getTypeId())
                .append("sex", getSex())
                .toString();
    }
}
