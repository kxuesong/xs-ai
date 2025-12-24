package org.ruoyi.game.domain.vo;



import io.github.linpeilie.annotations.AutoMapper;
import org.ruoyi.game.domain.StageEnter;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
@AutoMapper(target = StageEnter.class)
public class StageEnterVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String note;
    private String region;
    private Integer stageGroupId;
    private Integer sceneId;
    private String enterPointPrefab;
    private Integer enterPointId;
    private String enterType;
    private Integer enterLevelMin;
    private Integer enterLevelMax;
    private Integer recommendLevel;
    private Integer powerMin;
    private Integer powerMax;
    private String enterDescription;
    private Integer enterOrder;
    private Integer enterShowType;
    private String triggerCondition;
    private Integer rewardBase;
    private Integer firstClearReward;
    private Integer challengeMode;
    private Integer challengeDifficulty;
}
