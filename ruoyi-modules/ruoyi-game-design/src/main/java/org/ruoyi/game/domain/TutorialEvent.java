package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * 教程事件实体
 *
 * @author ruoyi
 */
@Data
@TableName("tb_tutorial_event")
public class TutorialEvent implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 事件ID
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
     * 教程任务ID
     */
    private Integer tutorialTask;

    /**
     * 教程任务数量
     */
    private Integer tutorialTaskCount;

    /**
     * 教程任务字符串ID
     */
    private Integer tutorialTaskString;

    /**
     * 教程弹窗字符串ID
     */
    private Integer tutorialPopupString;

    /**
     * 教程弹窗数量
     */
    private Integer tutorialPopupCount;

    /**
     * 教程弹窗配置1
     */
    @TableField("tutorial_popup_1")
    private Integer tutorialPopup_1;

    /**
     * 教程弹窗配置2
     */
    @TableField("tutorial_popup_2")
    private Integer tutorialPopup_2;

    /**
     * 教程弹窗配置3
     */
    @TableField("tutorial_popup_3")
    private Integer tutorialPopup_3;
}
