package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * 教程条件实体
 *
 * @author ruoyi
 */
@Data
@TableName("tb_tutorial_condition")
public class TutorialCondition implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 教程条件ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 备注说明
     */
    private String note;

    /**
     * 备注操作
     */
    private Integer noteOperation;

    /**
     * 区域
     */
    private String region;

    /**
     * 教程流程ID
     */
    private Integer tutorialFlow;

    /**
     * 教程开始场景
     */
    private Integer tutorialStartScene;

    /**
     * 教程条件类型
     */
    private Integer tutorialConditionType;

    /**
     * 教程条件值
     */
    private Integer tutorialConditionValue;

    /**
     * 教程地图ID
     */
    private Integer tutorialMapId;

    /**
     * 下一个教程ID
     */
    private Integer tutorialNextId;

    /**
     * 教程类型
     */
    private Integer tutorialType;

    /**
     * 奖励表类型1
     */
    @TableField("tutorial_table_type_1")
    private Integer tutorialTableType_1;

    /**
     * 奖励道具ID1
     */
    @TableField("tutorial_item_id_1")
    private Integer tutorialItemId_1;

    /**
     * 奖励道具数量1
     */
    @TableField("tutorial_item_count_1")
    private Integer tutorialItemCount_1;

    /**
     * 奖励表类型2
     */
    @TableField("tutorial_table_type_2")
    private Integer tutorialTableType_2;

    /**
     * 奖励道具ID2
     */
    @TableField("tutorial_item_id_2")
    private Integer tutorialItemId_2;

    /**
     * 奖励道具数量2
     */
    @TableField("tutorial_item_count_2")
    private Integer tutorialItemCount_2;

    /**
     * 奖励表类型3
     */
    @TableField("tutorial_table_type_3")
    private Integer tutorialTableType_3;

    /**
     * 奖励道具ID3
     */
    @TableField("tutorial_item_id_3")
    private Integer tutorialItemId_3;

    /**
     * 奖励道具数量3
     */
    @TableField("tutorial_item_count_3")
    private Integer tutorialItemCount_3;

    /**
     * 奖励表类型4
     */
    @TableField("tutorial_table_type_4")
    private Integer tutorialTableType_4;

    /**
     * 奖励道具ID4
     */
    @TableField("tutorial_item_id_4")
    private Integer tutorialItemId_4;

    /**
     * 奖励道具数量4
     */
    @TableField("tutorial_item_count_4")
    private Integer tutorialItemCount_4;

    /**
     * 奖励表类型5
     */
    @TableField("tutorial_table_type_5")
    private Integer tutorialTableType_5;

    /**
     * 奖励道具ID5
     */
    @TableField("tutorial_item_id_5")
    private Integer tutorialItemId_5;

    /**
     * 奖励道具数量5
     */
    @TableField("tutorial_item_count_5")
    private Integer tutorialItemCount_5;

    /**
     * 奖励表类型6
     */
    @TableField("tutorial_table_type_6")
    private Integer tutorialTableType_6;

    /**
     * 奖励道具ID6
     */
    @TableField("tutorial_item_id_6")
    private Integer tutorialItemId_6;

    /**
     * 奖励道具数量6
     */
    @TableField("tutorial_item_count_6")
    private Integer tutorialItemCount_6;
}
