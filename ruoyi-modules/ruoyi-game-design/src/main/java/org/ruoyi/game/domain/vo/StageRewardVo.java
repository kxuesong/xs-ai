package org.ruoyi.game.domain.vo;


import io.github.linpeilie.annotations.AutoMapper;
import org.ruoyi.game.domain.StageReward;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
@AutoMapper(target = StageReward.class)
public class StageRewardVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String note;
    private String region;
    private Integer stageAttributeId;
    private Integer rewardGroup;
    private Integer rewardOrder;
    private String rewardType;
    private Integer rewardItemId;
    private Integer rewardItemCount;
    private Integer rewardProbability;
    private Integer minLevel;
    private Integer maxLevel;
    private Integer dropTableId;
    private Integer bonusRewardId;
    private Integer firstClearBonus;
    private Integer challengeBonus;
    private String rewardDescription;
    private Integer rewardDisplay;
}
