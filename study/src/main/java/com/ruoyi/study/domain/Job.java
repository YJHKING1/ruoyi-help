package com.ruoyi.study.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 就业帮扶对象 job
 *
 * @author YJH
 * @date 2022-09-12
 */
public class Job extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    /**
     * $column.columnComment
     */
    private Long id;
    
    /**
     * 帮扶老师
     */
    @Excel(name = "帮扶老师")
    private Long teacherId;
    
    /**
     * 帮扶学生
     */
    @Excel(name = "帮扶学生")
    private Long studentId;
    
    /**
     * 预约时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预约时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reserveTime;
    
    /**
     * 问题类型
     */
    @Excel(name = "问题类型")
    private Long problemTypeId;
    
    /**
     * 状态
     */
    @Excel(name = "状态")
    private Integer state;
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
    
    public Long getTeacherId() {
        return teacherId;
    }
    
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    
    public Long getStudentId() {
        return studentId;
    }
    
    public void setReserveTime(Date reserveTime) {
        this.reserveTime = reserveTime;
    }
    
    public Date getReserveTime() {
        return reserveTime;
    }
    
    public void setProblemTypeId(Long problemTypeId) {
        this.problemTypeId = problemTypeId;
    }
    
    public Long getProblemTypeId() {
        return problemTypeId;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }
    
    public Integer getState() {
        return state;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("teacherId", getTeacherId())
                .append("studentId", getStudentId())
                .append("reserveTime", getReserveTime())
                .append("problemTypeId", getProblemTypeId())
                .append("state", getState())
                .toString();
    }
}
