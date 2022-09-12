package com.ruoyi.study.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 班级对象 clazz
 *
 * @author YJH
 * @date 2022-09-12
 */
public class Clazz extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    /**
     * $column.columnComment
     */
    private Long id;
    
    /**
     * 班级名
     */
    @Excel(name = "班级名")
    private String name;
    
    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;
    
    /**
     * 结课时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结课时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entTime;
    
    /**
     * 班主任
     */
    @Excel(name = "班主任")
    private Long masterId;
    
    /**
     * 就业老师
     */
    @Excel(name = "就业老师")
    private Long jobTeacherId;
    
    /**
     * 助教
     */
    @Excel(name = "助教")
    private Long studyTeacherId;
    
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
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public Date getStartTime() {
        return startTime;
    }
    
    public void setEntTime(Date entTime) {
        this.entTime = entTime;
    }
    
    public Date getEntTime() {
        return entTime;
    }
    
    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }
    
    public Long getMasterId() {
        return masterId;
    }
    
    public void setJobTeacherId(Long jobTeacherId) {
        this.jobTeacherId = jobTeacherId;
    }
    
    public Long getJobTeacherId() {
        return jobTeacherId;
    }
    
    public void setStudyTeacherId(Long studyTeacherId) {
        this.studyTeacherId = studyTeacherId;
    }
    
    public Long getStudyTeacherId() {
        return studyTeacherId;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("startTime", getStartTime())
                .append("entTime", getEntTime())
                .append("masterId", getMasterId())
                .append("jobTeacherId", getJobTeacherId())
                .append("studyTeacherId", getStudyTeacherId())
                .toString();
    }
}
