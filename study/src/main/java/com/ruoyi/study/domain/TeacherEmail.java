package com.ruoyi.study.domain;

import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 老师邮箱对象 teacher_email
 *
 * @author YJH
 * @date 2022-09-13
 */
public class TeacherEmail extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;
    
    /**
     * 老师
     */
    @Excel(name = "老师")
    private Long teacherId;
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
    
    public Long getTeacherId() {
        return teacherId;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("email", getEmail())
                .append("teacherId", getTeacherId())
                .toString();
    }
}
