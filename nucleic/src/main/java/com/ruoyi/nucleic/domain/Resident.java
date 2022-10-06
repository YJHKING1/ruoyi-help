package com.ruoyi.nucleic.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 住户对象 resident
 *
 * @author YJH
 * @date 2022-10-06
 */
public class Resident extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** 编号 */
    private Long id;

    /** 小区 */
            @Excel(name = "ID")
    private Long communityId;

    /** 楼栋 */
            @Excel(name = "ID")
    private Long buildId;

    /** 用户 */
            @Excel(name = "ID")
    private Long userId;

    /** 住户 */
            @Excel(name = "ID")
    private String name;

    /** 电话 */
            @Excel(name = "ID")
    private String phone;

    /** 地址 */
            @Excel(name = "ID")
    private String address;

    /** 状态 */
            @Excel(name = "ID")
    private Long state;

    /** 描述 */
            @Excel(name = "ID")
    private String text;

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
    public void setBuildId(Long buildId)
            {
            this.buildId = buildId;
            }

    public Long getBuildId()
            {
            return buildId;
            }
    public void setUserId(Long userId)
            {
            this.userId = userId;
            }

    public Long getUserId()
            {
            return userId;
            }
    public void setName(String name)
            {
            this.name = name;
            }

    public String getName()
            {
            return name;
            }
    public void setPhone(String phone)
            {
            this.phone = phone;
            }

    public String getPhone()
            {
            return phone;
            }
    public void setAddress(String address)
            {
            this.address = address;
            }

    public String getAddress()
            {
            return address;
            }
    public void setState(Long state)
            {
            this.state = state;
            }

    public Long getState()
            {
            return state;
            }
    public void setText(String text)
            {
            this.text = text;
            }

    public String getText()
            {
            return text;
            }

@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id",getId())
            .append("communityId",getCommunityId())
            .append("buildId",getBuildId())
            .append("userId",getUserId())
            .append("name",getName())
            .append("phone",getPhone())
            .append("address",getAddress())
            .append("state",getState())
            .append("text",getText())
        .toString();
        }
        }
