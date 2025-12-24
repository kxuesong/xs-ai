package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * 教程流程实体
 *
 * @author ruoyi
 */
@Data
@TableName("tb_tutorial_flow")
public class TutorialFlow implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 教程ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 备注说明
     */
    private String note;

    /**
     * 区域
     */
    private String region;

    /**
     * 冻结检查
     */
    private Integer freezeCheck;

    /**
     * 事件脚本
     */
    private Integer eventScript;

    /**
     * 事件值
     */
    private Integer eventValue;

    /**
     * 下一步条件
     */
    private String nextStepCondition;

    /**
     * 启用按钮事件
     */
    private Integer enableButtonEvent;

    /**
     * 切换场景
     */
    private Integer switchScene;

    /**
     * 下一步ID
     */
    private Integer nextStepId;

    /**
     * 教程步骤
     */
    private Integer tutorialStep;

    /**
     * 加载场景
     */
    private String loadScene;

    /**
     * 剧情场景
     */
    private String slateScene;

    /**
     * 剧情章节
     */
    private String slateSection;

    /**
     * 标题字符串ID
     */
    private Integer titleString;

    /**
     * 备注字符串ID
     */
    private Integer noteString;

    /**
     * 图片类型
     */
    private Integer imgType;

    /**
     * 左侧图片
     */
    private String imgLeft;

    /**
     * 右侧图片
     */
    private String imgRight;

    /**
     * 左侧图标ID
     */
    private Integer imgIconLeft;

    /**
     * 右侧图标ID
     */
    private Integer imgIconRight;

    /**
     * 引导字符串ID
     */
    private Integer guideString;

    /**
     * 引导延迟时间
     */
    private Float guideDelayTime;

    /**
     * 引导箭头方向
     */
    private Integer guideArrowDirection;

    /**
     * 引导箭头字符串ID
     */
    private Integer guideArrowString;

    /**
     * 引导框类型
     */
    private Integer guideBoxType;

    /**
     * 引导框X坐标
     */
    private Integer guideBoxPositionX;

    /**
     * 引导框Y坐标
     */
    private Integer guideBoxPositionY;

    /**
     * 引导框X缩放
     */
    private Integer guideBoxScaleX;

    /**
     * 引导框Y缩放
     */
    private Integer guideBoxScaleY;
}
