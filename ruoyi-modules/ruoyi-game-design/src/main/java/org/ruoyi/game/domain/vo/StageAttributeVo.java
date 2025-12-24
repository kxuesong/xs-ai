package org.ruoyi.game.domain.vo;


import io.github.linpeilie.annotations.AutoMapper;
import org.ruoyi.game.domain.StageAttribute;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * 关卡属性值对象
 *
 * @author ruoyi
 */
@Data
@AutoMapper(target = StageAttribute.class)
public class StageAttributeVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String note;
    private String region;
    private Integer stageId;
    private Integer stageGroupId;
    private Integer stageType;
    private Integer unitExp;
    private Integer accountExp;
    private Integer goldMin;
    private Integer goldMax;
    private Integer rewardGroupId;
    private Integer staminaCount;
    private Integer secretGageMin;
    private Integer secretGageMax;
    private Integer themaGroupId;
    private Integer checkitemId;
    private Integer stageGrade;
    private Integer rankRewardId;
}
