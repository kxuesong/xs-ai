package org.ruoyi.game.domain.vo;


import io.github.linpeilie.annotations.AutoMapper;
import org.ruoyi.game.domain.StageGroup;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * 关卡组值对象
 *
 * @author ruoyi
 */
@Data
@AutoMapper(target = StageGroup.class)
public class StageGroupVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String note;
    private String region;
    private Integer themaGroupId;
    private Integer stageUiString;
    private Integer stageImage;
    private Integer stageBackground;
    private String stageBossUnitId;
    private Integer nextCheck;
    private Integer stage1;
    private Integer stage2;
    private Integer stage3;
    private Integer stage4;
    private Integer stage5;
    private Integer stage6;
    private Integer stage7;
    private Integer stage8;
    private Integer stage9;
    private Integer stage10;
    private Integer stage11;
    private Integer stage12;
    private Integer stage13;
    private Integer stage14;
    private Integer stage15;
}
