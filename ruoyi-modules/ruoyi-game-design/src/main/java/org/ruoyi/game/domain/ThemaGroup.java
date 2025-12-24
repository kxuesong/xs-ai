package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * 章节组/主题实体
 *
 * @author ruoyi
 */
@Data
@TableName("tb_thema_group")
public class ThemaGroup implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 章节ID
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
     * 关卡类型
     */
    private Integer stageType;

    /**
     * UI字符串ID
     */
    private Integer uiString;

    /**
     * 奖励ID
     */
    private Integer rewardId;

    /**
     * 章节关卡数量
     */
    private Integer themaStageCount;

    /**
     * 排行最大数量
     */
    private Integer rankMaxCount;

    /**
     * 开放条件组ID
     */
    private Integer themaOpenGroupid;

    /**
     * 开放条件关卡ID
     */
    private Integer themaOpenStageid;

    /**
     * 关卡组ID 1
     */
    @TableField("stage_1")
    private Integer stage1;

    /**
     * 关卡组ID 2
     */
    @TableField("stage_2")
    private Integer stage2;

    /**
     * 关卡组ID 3
     */
    @TableField("stage_3")
    private Integer stage3;

    /**
     * 关卡组ID 4
     */
    @TableField("stage_4")
    private Integer stage4;

    /**
     * 关卡组ID 5
     */
    @TableField("stage_5")
    private Integer stage5;

    /**
     * 关卡组ID 6
     */
    @TableField("stage_6")
    private Integer stage6;

    /**
     * 关卡组ID 7
     */
    @TableField("stage_7")
    private Integer stage7;

    /**
     * 关卡组ID 8
     */
    @TableField("stage_8")
    private Integer stage8;

    /**
     * 关卡组ID 9
     */
    @TableField("stage_9")
    private Integer stage9;

    /**
     * 关卡组ID 10
     */
    @TableField("stage_10")
    private Integer stage10;

    /**
     * 关卡组ID 11
     */
    @TableField("stage_11")
    private Integer stage11;

    /**
     * 关卡组ID 12
     */
    @TableField("stage_12")
    private Integer stage12;

    /**
     * 关卡组ID 13
     */
    @TableField("stage_13")
    private Integer stage13;

    /**
     * 关卡组ID 14
     */
    @TableField("stage_14")
    private Integer stage14;

    /**
     * 关卡组ID 15
     */
    @TableField("stage_15")
    private Integer stage15;
}
