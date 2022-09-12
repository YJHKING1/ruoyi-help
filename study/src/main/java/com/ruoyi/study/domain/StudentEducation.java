package com.ruoyi.study.domain;

import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 学历对象 student_education
 *
 * @author YJH
 * @date 2022-09-12
 */
public class StudentEducation extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    /**
     * $column.columnComment
     */
    private Long id;
    
    /**
     * 学历
     */
    @Excel(name = "学历")
    private String education;
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setEducation(String education) {
        this.education = education;
    }
    
    public String getEducation() {
        return education;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("education", getEducation())
                .toString();
    }
}
