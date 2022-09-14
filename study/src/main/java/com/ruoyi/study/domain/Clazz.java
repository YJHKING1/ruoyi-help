package com.ruoyi.study.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 班级对象 clazz
 *
 * @author YJH
 * @date 2022-09-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Teacher master;
    /**
     * 就业老师
     */
    @Excel(name = "就业老师")
    private Long jobTeacherId;
    private Teacher jobTeacher;
    /**
     * 助教
     */
    @Excel(name = "助教")
    private Long studyTeacherId;
    private Teacher studyTeacher;
}
