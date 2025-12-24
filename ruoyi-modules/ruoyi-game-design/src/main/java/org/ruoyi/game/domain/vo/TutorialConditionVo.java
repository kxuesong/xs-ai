package org.ruoyi.game.domain.vo;


import io.github.linpeilie.annotations.AutoMapper;
import org.ruoyi.game.domain.TutorialCondition;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 教程条件视图对象
 *
 * @author ruoyi
 */
@Data
@AutoMapper(target = TutorialCondition.class)
public class TutorialConditionVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 教程条件ID
     */
    @ExcelProperty(value = "教程条件ID")
    private Integer id;

    /**
     * 备注说明
     */
    @ExcelProperty(value = "备注说明")
    private String note;

    /**
     * 备注操作
     */
    @ExcelProperty(value = "备注操作")
    private Integer noteOperation;

    /**
     * 区域
     */
    @ExcelProperty(value = "区域")
    private String region;

    /**
     * 教程流程ID
     */
    @ExcelProperty(value = "教程流程ID")
    private Integer tutorialFlow;

    /**
     * 教程条件类型
     */
    @ExcelProperty(value = "条件类型")
    private Integer tutorialConditionType;

    /**
     * 教程条件值
     */
    @ExcelProperty(value = "条件值")
    private Integer tutorialConditionValue;

    /**
     * 下一个教程ID
     */
    @ExcelProperty(value = "下一个教程ID")
    private Integer tutorialNextId;

    /**
     * 教程类型
     */
    @ExcelProperty(value = "教程类型")
    private Integer tutorialType;
}
