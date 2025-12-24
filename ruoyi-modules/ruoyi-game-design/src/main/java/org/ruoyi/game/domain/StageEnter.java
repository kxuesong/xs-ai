package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * 关卡入口实体
 *
 * @author ruoyi
 */
@Data
@TableName("tb_stage_enter")
public class StageEnter implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    private String note;
    private String region;
    private Integer stageGrade;
    private Integer uiString;
    private Integer bossIconId;
    private Integer bossMonId;
    private Integer bossLv;
    private Integer bossUiString;
    private Integer fightingPower;
    private Integer bossPassive;
    private Integer bossGuideString;

    @TableField(exist = false)
    private Integer timeLimit;
    @TableField(exist = false)
    private Integer alarmTime;
    @TableField(exist = false)
    private Integer alarmTick;

    @TableField("clear1_type")
    private Integer clear1Type;
    @TableField("clear1_value")
    private Integer clear1Value;
    @TableField("clear2_type")
    private Integer clear2Type;
    @TableField("clear2_value")
    private Integer clear2Value;
    @TableField("clear3_type")
    private Integer clear3Type;
    @TableField("clear3_value")
    private Integer clear3Value;

    @TableField("reward_type_1")
    private Integer rewardType1;
    @TableField("reward_icon_1_id")
    private Integer rewardIcon1Id;
    @TableField("reward_icon_1_note")
    private Integer rewardIcon1Note;
    @TableField("preview_table_id_1")
    private Integer previewTableId1;
    @TableField("preview_ui_string_1")
    private Integer previewUiString1;

    @TableField("reward_type_2")
    private Integer rewardType2;
    @TableField("reward_icon_2_id")
    private Integer rewardIcon2Id;
    @TableField("reward_icon_2_note")
    private Integer rewardIcon2Note;
    @TableField("preview_table_id_2")
    private Integer previewTableId2;
    @TableField("preview_ui_string_2")
    private Integer previewUiString2;

    @TableField("reward_type_3")
    private Integer rewardType3;
    @TableField("reward_icon_3_id")
    private Integer rewardIcon3Id;
    @TableField("reward_icon_3_note")
    private Integer rewardIcon3Note;
    @TableField("preview_table_id_3")
    private Integer previewTableId3;
    @TableField("preview_ui_string_3")
    private Integer previewUiString3;

    private Integer reviveCount;
    private Integer masterAbility;
    private Integer stageAdvantage;
}
