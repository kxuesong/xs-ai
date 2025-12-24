package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * 关卡场景实体
 *
 * @author ruoyi
 */
@Data
@TableName("tb_stage_scene")
public class StageScene implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;
    private String note;
    private String region;
    private Integer stageUiString;
    private String sceneFile;
    private Integer sceneBgmId;
    private Integer nextScene;
    private String bossCamanimPrefab;
    private String spawnPrefeb;
    private Integer bossId;

    @TableField("skill_slot1")
    private Integer skillSlot1;
    @TableField("skill_slot2")
    private Integer skillSlot2;
    @TableField("skill_slot3")
    private Integer skillSlot3;

    @TableField("boss_skill_icon1")
    private Integer bossSkillIcon1;
    @TableField("boss_skill_icon2")
    private Integer bossSkillIcon2;
    @TableField("boss_skill_icon3")
    private Integer bossSkillIcon3;

    @TableField("skill_title1")
    private Integer skillTitle1;
    @TableField("skill_title2")
    private Integer skillTitle2;
    @TableField("skill_title3")
    private Integer skillTitle3;

    @TableField("skill_detail1")
    private Integer skillDetail1;
    @TableField("skill_detail2")
    private Integer skillDetail2;
    @TableField("skill_detail3")
    private Integer skillDetail3;

    private String cameraMode;
    private Float zoomOutCameraOffset;
    private Float zoomOutCameraHeight;
    private Float zoomOutCameraSideOffset;
    private Float zoomOutCameraRotateOffset;
    private Float zoomOutCameraTargetHeight;
    private Float zoomOutCameraDistance;
    private Float zoomInCameraOffset;
}
