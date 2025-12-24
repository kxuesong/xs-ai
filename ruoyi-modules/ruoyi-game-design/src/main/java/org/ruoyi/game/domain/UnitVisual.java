package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 单位视觉资源对象 tb_unit_visual
 *
 * @author ruoyi
 */
@Data
@TableName("tb_unit_visual")
public class UnitVisual implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 视觉资源ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 备注说明
     */
    private String note;

    /**
     * 区域标识
     */
    private String region;

    /**
     * 单位预制体路径
     */
    private String unitPrefab;

    /**
     * 角色动画路径
     */
    private String characterAnim;

    /**
     * 怪物动画路径
     */
    private String monsterAnim;

    /**
     * 大厅动画路径
     */
    private String lobbyAnim;

    /**
     * 角色剪辑路径
     */
    private String characterClip;

    /**
     * 怪物剪辑路径
     */
    private String monsterClip;

    /**
     * 大厅剪辑路径
     */
    private String lobbyClip;

    /**
     * 大厅缩放比例
     */
    private Double lobbyScale;

    /**
     * 游戏缩放比例
     */
    private Double gameScale;

    /**
     * 附加缩放比例
     */
    private Double attachScale;

    /**
     * PVP加载界面缩放比例
     */
    private Double pvpLoadingScale;

    /**
     * 特效文件路径
     */
    private String fxFile;

    /**
     * 特效绑定骨骼
     */
    private String fxAttachBone;

    /**
     * 特效缩放
     */
    private String fxScale;

    /**
     * 特效偏移
     */
    private String fxOffset;

    /**
     * 特效旋转
     */
    private String fxRotation;

    /**
     * 命中音效
     */
    private String hitSound;
}
