package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * 关卡属性实体
 *
 * @author ruoyi
 */
@Data
@TableName("tb_stage_attribute")
public class StageAttribute implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 关卡属性ID
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
     * 关卡ID
     */
    private Integer stageId;

    /**
     * 关卡组ID
     */
    private Integer stageGroupId;

    /**
     * 关卡类型
     */
    private Integer stageType;

    /**
     * 单位经验
     */
    private Integer unitExp;

    /**
     * 账号经验
     */
    private Integer accountExp;

    /**
     * 最小金币
     */
    private Integer goldMin;

    /**
     * 最大金币
     */
    private Integer goldMax;

    /**
     * 奖励组ID
     */
    private Integer rewardGroupId;

    /**
     * 体力消耗
     */
    private Integer staminaCount;

    /**
     * 秘密能量最小值
     */
    private Integer secretGageMin;

    /**
     * 秘密能量最大值
     */
    private Integer secretGageMax;

    /**
     * 主题组ID
     */
    private Integer themaGroupId;

    /**
     * 检查项ID
     */
    private Integer checkitemId;

    /**
     * 关卡评级
     */
    private Integer stageGrade;

    /**
     * 排行奖励ID
     */
    private Integer rankRewardId;
}
