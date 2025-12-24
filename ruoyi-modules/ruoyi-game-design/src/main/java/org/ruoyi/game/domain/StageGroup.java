package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * 关卡组实体
 *
 * @author ruoyi
 */
@Data
@TableName("tb_stage_group")
public class StageGroup implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 关卡组ID
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
     * 主题组ID
     */
    private Integer themaGroupId;

    /**
     * 关卡UI字符串
     */
    private Integer stageUiString;

    /**
     * 关卡图片
     */
    private Integer stageImage;

    /**
     * 背景图片
     */
    private Integer stageBackground;

    /**
     * Boss单位ID
     */
    private String stageBossUnitId;

    /**
     * 下一关检查
     */
    private Integer nextCheck;

    /**
     * 关卡配置ID 1
     */
    @TableField("stage_1")
    private Integer stage1;

    /**
     * 关卡配置ID 2
     */
    @TableField("stage_2")
    private Integer stage2;

    /**
     * 关卡配置ID 3
     */
    @TableField("stage_3")
    private Integer stage3;

    /**
     * 关卡配置ID 4
     */
    @TableField("stage_4")
    private Integer stage4;

    /**
     * 关卡配置ID 5
     */
    @TableField("stage_5")
    private Integer stage5;

    /**
     * 关卡配置ID 6
     */
    @TableField("stage_6")
    private Integer stage6;

    /**
     * 关卡配置ID 7
     */
    @TableField("stage_7")
    private Integer stage7;

    /**
     * 关卡配置ID 8
     */
    @TableField("stage_8")
    private Integer stage8;

    /**
     * 关卡配置ID 9
     */
    @TableField("stage_9")
    private Integer stage9;

    /**
     * 关卡配置ID 10
     */
    @TableField("stage_10")
    private Integer stage10;

    /**
     * 关卡配置ID 11
     */
    @TableField("stage_11")
    private Integer stage11;

    /**
     * 关卡配置ID 12
     */
    @TableField("stage_12")
    private Integer stage12;

    /**
     * 关卡配置ID 13
     */
    @TableField("stage_13")
    private Integer stage13;

    /**
     * 关卡配置ID 14
     */
    @TableField("stage_14")
    private Integer stage14;

    /**
     * 关卡配置ID 15
     */
    @TableField("stage_15")
    private Integer stage15;
}
