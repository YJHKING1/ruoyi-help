package com.ruoyi.study.domain;

import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 教师对象 teacher
 *
 * @author YJH
 * @date 2022-09-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    /**
     * $column.columnComment
     */
    private Long id;
    
    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String name;
    
    /**
     * 电话
     */
    @Excel(name = "电话")
    private String phone;
    
    /**
     * 帮扶优先级
     */
    @Excel(name = "帮扶优先级")
    private Long priority;
    
    /**
     * 老师类型
     */
    @Excel(name = "老师类型")
    private Long typeId;
    private TeacherType teacherType;
    
    /**
     * 性别
     */
    @Excel(name = "性别")
    private String sex;
}
