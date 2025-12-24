package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * 单位实体
 *
 * @author ruoyi
 */
@Data
@TableName("tb_unit")
public class Unit implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 单位ID (主键)
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 备注说明
     */
    private String note;

    /**
     * 区域
     */
    private String region;

    /**
     * 品质等级 (1-5)
     */
    private Integer grade;

    /**
     * 觉醒等级
     */
    private Integer ultimate;

    /**
     * 单位分组
     */
    private Integer unitGroup;

    /**
     * 战斗类型
     */
    private Integer battleType;

    /**
     * 排他类型
     */
    private Integer unitExclusive;

    /**
     * 分类ID
     */
    private Integer unitCategoryId;

    /**
     * 最高等级分类ID
     */
    private Integer maxLevelCategoryId;

    /**
     * 配对信息 (格式：167/103/102/101/21/11/31)
     */
    private String pair;

    /**
     * 图标ID
     */
    private Integer iconId;

    /**
     * UI字符串ID
     */
    private Integer uiString;

    /**
     * 备注UI字符串ID
     */
    private Integer noteUiString;

    /**
     * 召唤UI字符串ID
     */
    private Integer summonUiString;

    /**
     * 等级奖励组
     */
    private Integer gradeRewardGroup;

    /**
     * 位置1
     */
    @TableField("position_1")
    private Integer position1;

    /**
     * 位置2
     */
    @TableField("position_2")
    private Integer position2;

    /**
     * 获取里程
     */
    private Integer getMileage;

    /**
     * 插图ID
     */
    private Integer illustId;

    /**
     * 基础视觉ID
     */
    private Integer basicVisualId;
}
