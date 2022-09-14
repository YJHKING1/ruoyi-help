package com.ruoyi.study.domain;

import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 评价对象 evaluation
 *
 * @author YJH
 * @date 2022-09-13
 */
@Data
public class Evaluation extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 帮扶
     */
    @Excel(name = "帮扶")
    private Long jobId;
    
    /**
     * 评价
     */
    @Excel(name = "评价")
    private String evaluateText;
    
    /**
     * 分数
     */
    @Excel(name = "分数")
    private String score;
    
    /**
     * 老师
     */
    @Excel(name = "老师")
    private Long teacherId;
    private Integer countNum;
    private Long scoreAvg;
    private Teacher teacher;
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
    
    public Long getJobId() {
        return jobId;
    }
    
    public void setEvaluateText(String evaluateText) {
        this.evaluateText = evaluateText;
    }
    
    public String getEvaluateText() {
        return evaluateText;
    }
    
    public void setScore(String score) {
        this.score = score;
    }
    
    public String getScore() {
        return score;
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
                .append("jobId", getJobId())
                .append("evaluateText", getEvaluateText())
                .append("score", getScore())
                .append("teacherId", getTeacherId())
                .toString();
    }
}
