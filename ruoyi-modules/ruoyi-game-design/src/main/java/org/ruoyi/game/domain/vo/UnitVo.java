package org.ruoyi.game.domain.vo;


import io.github.linpeilie.annotations.AutoMapper;
import org.ruoyi.game.domain.Unit;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 单位视图对象
 *
 * @author ruoyi
 */
@Data
@AutoMapper(target = Unit.class)
public class UnitVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 单位ID
     */
    @ExcelProperty(value = "单位ID")
    private Integer id;

    /**
     * 备注说明
     */
    @ExcelProperty(value = "备注说明")
    private String note;

    /**
     * 区域
     */
    @ExcelProperty(value = "区域")
    private String region;

    /**
     * 品质等级
     */
    @ExcelProperty(value = "品质等级")
    private Integer grade;

    /**
     * 觉醒等级
     */
    @ExcelProperty(value = "觉醒等级")
    private Integer ultimate;

    /**
     * 单位分组
     */
    @ExcelProperty(value = "单位分组")
    private Integer unitGroup;

    /**
     * 战斗类型
     */
    @ExcelProperty(value = "战斗类型")
    private Integer battleType;

    /**
     * 排他类型
     */
    @ExcelProperty(value = "排他类型")
    private Integer unitExclusive;

    /**
     * 分类ID
     */
    @ExcelProperty(value = "分类ID")
    private Integer unitCategoryId;

    /**
     * 最高等级分类ID
     */
    @ExcelProperty(value = "最高等级分类ID")
    private Integer maxLevelCategoryId;

    /**
     * 配对信息
     */
    @ExcelProperty(value = "配对信息")
    private String pair;

    /**
     * 图标ID
     */
    @ExcelProperty(value = "图标ID")
    private Integer iconId;

    /**
     * UI字符串ID
     */
    @ExcelProperty(value = "UI字符串ID")
    private Integer uiString;

    /**
     * 备注UI字符串ID
     */
    @ExcelProperty(value = "备注UI字符串ID")
    private Integer noteUiString;

    /**
     * 召唤UI字符串ID
     */
    @ExcelProperty(value = "召唤UI字符串ID")
    private Integer summonUiString;

    /**
     * 等级奖励组
     */
    @ExcelProperty(value = "等级奖励组")
    private Integer gradeRewardGroup;

    /**
     * 位置1
     */
    @ExcelProperty(value = "位置1")
    private Integer position1;

    /**
     * 位置2
     */
    @ExcelProperty(value = "位置2")
    private Integer position2;

    /**
     * 获取里程
     */
    @ExcelProperty(value = "获取里程")
    private Integer getMileage;

    /**
     * 插图ID
     */
    @ExcelProperty(value = "插图ID")
    private Integer illustId;

    /**
     * 基础视觉ID
     */
    @ExcelProperty(value = "基础视觉ID")
    private Integer basicVisualId;
}
