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
public class JobDto {
    private Long id;
    private Long teacher;
    private Long student;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date finalTime;
    private String proType;
    private String score;
    private String evaluateText;
}
