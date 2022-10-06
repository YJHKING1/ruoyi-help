package com.ruoyi.nucleic.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 楼栋对象 build
 *
 * @author YJH
 * @date 2022-10-06
 */
public class Build extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** 编号 */
    private Long id;

    /** 小区 */
            @Excel(name = "ID")
    private Long communityId;

    /** 楼栋 */
            @Excel(name = "ID")
    private String name;

    /** 状态 */
            @Excel(name = "ID")
    private Long state;

    public void setId(Long id)
            {
            this.id = id;
            }

    public Long getId()
            {
            return id;
            }
    public void setCommunityId(Long communityId)
            {
            this.communityId = communityId;
            }

    public Long getCommunityId()
            {
            return communityId;
            }
    public void setName(String name)
            {
            this.name = name;
            }

    public String getName()
            {
            return name;
            }
    public void setState(Long state)
            {
            this.state = state;
            }

    public Long getState()
            {
            return state;
            }

@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id",getId())
            .append("communityId",getCommunityId())
            .append("name",getName())
            .append("state",getState())
        .toString();
        }
        }
