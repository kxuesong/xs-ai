package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * 关卡奖励实体
 *
 * @author ruoyi
 */
@Data
@TableName("tb_stage_reward")
public class StageReward implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "Id", type = IdType.INPUT)
    private Integer id;

    @TableField("Note")
    private String note;

    private String region;
    private Integer themaGroupId;
    private Float posX;
    private Float posY;
    private Integer rewardType;
    private Integer rewardId;
    private Integer rewardCount;
    private Integer guideType;
    private Integer guideString;
    private Integer rewardString;
    private Integer summonType;
}
