package com.ruoyi.nucleic.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 小区对象 community
 *
 * @author YJH
 * @date 2022-10-06
 */
public class Community extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** 编号 */
    private Long id;

    /** 小区名 */
            @Excel(name = "ID")
    private String name;

    /** 管理员 */
            @Excel(name = "ID")
    private String admin;

    /** 管理员电话 */
            @Excel(name = "ID")
    private String adminPhone;

    /** 地址 */
            @Excel(name = "ID")
    private String address;

    /** 状态 */
            @Excel(name = "ID")
    private Integer state;

    public void setId(Long id)
            {
            this.id = id;
            }

    public Long getId()
            {
            return id;
            }
    public void setName(String name)
            {
            this.name = name;
            }

    public String getName()
            {
            return name;
            }
    public void setAdmin(String admin)
            {
            this.admin = admin;
            }

    public String getAdmin()
            {
            return admin;
            }
    public void setAdminPhone(String adminPhone)
            {
            this.adminPhone = adminPhone;
            }

    public String getAdminPhone()
            {
            return adminPhone;
            }
    public void setAddress(String address)
            {
            this.address = address;
            }

    public String getAddress()
            {
            return address;
            }
    public void setState(Integer state)
            {
            this.state = state;
            }

    public Integer getState()
            {
            return state;
            }

@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id",getId())
            .append("name",getName())
            .append("admin",getAdmin())
            .append("adminPhone",getAdminPhone())
            .append("address",getAddress())
            .append("state",getState())
        .toString();
        }
        }
