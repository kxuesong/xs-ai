package org.ruoyi.game.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.ruoyi.game.domain.UnitVisual;

import java.io.Serializable;

/**
 * 单位视觉资源 VO
 *
 * @author ruoyi
 */
@Data
@AutoMapper(target = UnitVisual.class)
public class UnitVisualVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 视觉资源ID
     */
    @ExcelProperty(value = "视觉资源ID")
    private Integer id;

    /**
     * 备注说明
     */
    @ExcelProperty(value = "备注说明")
    private String note;

    /**
     * 区域标识
     */
    @ExcelProperty(value = "区域标识")
    private String region;

    /**
     * 单位预制体路径
     */
    @ExcelProperty(value = "单位预制体路径")
    private String unitPrefab;

    /**
     * 角色动画路径
     */
    @ExcelProperty(value = "角色动画路径")
    private String characterAnim;

    /**
     * 怪物动画路径
     */
    @ExcelProperty(value = "怪物动画路径")
    private String monsterAnim;

    /**
     * 大厅动画路径
     */
    @ExcelProperty(value = "大厅动画路径")
    private String lobbyAnim;

    /**
     * 角色剪辑路径
     */
    @ExcelProperty(value = "角色剪辑路径")
    private String characterClip;

    /**
     * 怪物剪辑路径
     */
    @ExcelProperty(value = "怪物剪辑路径")
    private String monsterClip;

    /**
     * 大厅剪辑路径
     */
    @ExcelProperty(value = "大厅剪辑路径")
    private String lobbyClip;

    /**
     * 大厅缩放比例
     */
    @ExcelProperty(value = "大厅缩放比例")
    private Double lobbyScale;

    /**
     * 游戏缩放比例
     */
    @ExcelProperty(value = "游戏缩放比例")
    private Double gameScale;

    /**
     * 附加缩放比例
     */
    @ExcelProperty(value = "附加缩放比例")
    private Double attachScale;

    /**
     * PVP加载界面缩放比例
     */
    @ExcelProperty(value = "PVP加载界面缩放比例")
    private Double pvpLoadingScale;

    /**
     * 特效文件路径
     */
    @ExcelProperty(value = "特效文件路径")
    private String fxFile;

    /**
     * 特效绑定骨骼
     */
    @ExcelProperty(value = "特效绑定骨骼")
    private String fxAttachBone;

    /**
     * 特效缩放
     */
    @ExcelProperty(value = "特效缩放")
    private String fxScale;

    /**
     * 特效偏移
     */
    @ExcelProperty(value = "特效偏移")
    private String fxOffset;

    /**
     * 特效旋转
     */
    @ExcelProperty(value = "特效旋转")
    private String fxRotation;

    /**
     * 命中音效
     */
    @ExcelProperty(value = "命中音效")
    private String hitSound;
}
