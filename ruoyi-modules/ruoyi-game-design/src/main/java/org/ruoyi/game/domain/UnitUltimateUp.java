package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 单位觉醒升级对象 tb_unit_ultimate_up
 *
 * @author ruoyi
 */
@Data
@TableName("tb_unit_ultimate_up")
public class UnitUltimateUp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 觉醒升级ID
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
     * UI字符串ID
     */
    private Integer uiString;

    /**
     * 觉醒消耗
     */
    private Integer ultimateCost;

    /**
     * 材料ID_1
     */
    @TableField("material_id_1")
    private Integer materialId1;

    /**
     * 材料数量_1
     */
    @TableField("material_count_1")
    private Integer materialCount1;

    /**
     * 材料ID_2
     */
    @TableField("material_id_2")
    private Integer materialId2;

    /**
     * 材料数量_2
     */
    @TableField("material_count_2")
    private Integer materialCount2;

    /**
     * 材料ID_3
     */
    @TableField("material_id_3")
    private Integer materialId3;

    /**
     * 材料数量_3
     */
    @TableField("material_count_3")
    private Integer materialCount3;

    /**
     * 材料ID_4
     */
    @TableField("material_id_4")
    private Integer materialId4;

    /**
     * 材料数量_4
     */
    @TableField("material_count_4")
    private Integer materialCount4;

    /**
     * 材料ID_5
     */
    @TableField("material_id_5")
    private Integer materialId5;

    /**
     * 材料数量_5
     */
    @TableField("material_count_5")
    private Integer materialCount5;

    /**
     * 生命值
     */
    private Integer hp;

    /**
     * 攻击力
     */
    private Integer attack;

    /**
     * 护甲
     */
    private Integer armor;

    /**
     * 槽位开放
     */
    private Integer slotOpen;

    /**
     * 单位ID
     */
    private Integer unitId;
}
