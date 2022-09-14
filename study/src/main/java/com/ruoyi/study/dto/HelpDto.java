package com.ruoyi.study.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author YJH
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelpDto {
    private String name;
    private String email;
    private String wechat;
    private String phone;
    private Long clazz;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date proDate;
    private Long proType;
    private Long teacher;
    private String proText;
}
