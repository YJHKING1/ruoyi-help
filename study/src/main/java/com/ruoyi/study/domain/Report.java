package com.ruoyi.study.domain;

import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 报表统计对象 report
 *
 * @author YJH
 * @date 2022-09-12
 */
@Data
public class Report extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    /**
     * $column.columnComment
     */
    private Long id;
    
    /**
     * 老师
     */
    @Excel(name = "老师")
    private Long teacherId;
    
    /**
     * 帮扶数量
     */
    @Excel(name = "帮扶数量")
    private Long helpNum;
    
    /**
     * 平均分
     */
    @Excel(name = "平均分")
    private Long score;
    
    /**
     * 就业跟踪人数
     */
    @Excel(name = "就业跟踪人数")
    private Long jobNum;
    private Teacher teacher;
    
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
    
    public void setHelpNum(Long helpNum) {
        this.helpNum = helpNum;
    }
    
    public Long getHelpNum() {
        return helpNum;
    }
    
    public void setScore(Long score) {
        this.score = score;
    }
    
    public Long getScore() {
        return score;
    }
    
    public void setJobNum(Long jobNum) {
        this.jobNum = jobNum;
    }
    
    public Long getJobNum() {
        return jobNum;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("teacherId", getTeacherId())
                .append("helpNum", getHelpNum())
                .append("score", getScore())
                .append("jobNum", getJobNum())
                .toString();
    }
}
