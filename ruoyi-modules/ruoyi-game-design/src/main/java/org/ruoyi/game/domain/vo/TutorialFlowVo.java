package org.ruoyi.game.domain.vo;


import io.github.linpeilie.annotations.AutoMapper;
import org.ruoyi.game.domain.TutorialFlow;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 教程流程视图对象
 *
 * @author ruoyi
 */
@Data
@AutoMapper(target = TutorialFlow.class)
public class TutorialFlowVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 教程ID
     */
    @ExcelProperty(value = "教程ID")
    private Integer id;

    /**
     * 备注说明
     */
    @ExcelProperty(value = "备注说明")
    private String note;

    /**
     * 区域
     */
    @ExcelProperty(value = "区域")
    private String region;

    /**
     * 冻结检查
     */
    @ExcelProperty(value = "冻结检查")
    private Integer freezeCheck;

    /**
     * 事件脚本
     */
    @ExcelProperty(value = "事件脚本")
    private Integer eventScript;

    /**
     * 事件值
     */
    @ExcelProperty(value = "事件值")
    private Integer eventValue;

    /**
     * 下一步条件
     */
    @ExcelProperty(value = "下一步条件")
    private String nextStepCondition;

    /**
     * 教程步骤
     */
    @ExcelProperty(value = "教程步骤")
    private Integer tutorialStep;

    /**
     * 下一步ID
     */
    @ExcelProperty(value = "下一步ID")
    private Integer nextStepId;

    /**
     * 加载场景
     */
    @ExcelProperty(value = "加载场景")
    private String loadScene;

    /**
     * 标题字符串ID
     */
    @ExcelProperty(value = "标题字符串")
    private Integer titleString;

    /**
     * 备注字符串ID
     */
    @ExcelProperty(value = "备注字符串")
    private Integer noteString;

    /**
     * 引导字符串ID
     */
    @ExcelProperty(value = "引导字符串")
    private Integer guideString;

    /**
     * 引导延迟时间
     */
    @ExcelProperty(value = "引导延迟时间")
    private Float guideDelayTime;
}
