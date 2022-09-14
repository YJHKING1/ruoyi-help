package com.ruoyi.study.domain;

import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 帮扶问题类型对象 reserve_type
 *
 * @author YJH
 * @date 2022-09-13
 */
public class ReserveType extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 问题类型
     */
    @Excel(name = "问题类型")
    private String type;
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("type", getType())
                .toString();
    }
}
