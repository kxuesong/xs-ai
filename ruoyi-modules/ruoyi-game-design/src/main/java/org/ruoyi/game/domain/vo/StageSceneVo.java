package org.ruoyi.game.domain.vo;


import io.github.linpeilie.annotations.AutoMapper;
import org.ruoyi.game.domain.StageScene;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
@AutoMapper(target = StageScene.class)
public class StageSceneVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
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
    private Integer skillSlot1;
    private Integer skillSlot2;
    private Integer skillSlot3;
    private Integer bossSkillIcon1;
    private Integer bossSkillIcon2;
    private Integer bossSkillIcon3;
    private Integer skillTitle1;
    private Integer skillTitle2;
    private Integer skillTitle3;
    private Integer skillDetail1;
    private Integer skillDetail2;
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
