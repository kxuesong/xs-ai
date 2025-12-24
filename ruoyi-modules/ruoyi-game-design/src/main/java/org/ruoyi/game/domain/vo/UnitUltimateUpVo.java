package org.ruoyi.game.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.ruoyi.game.domain.UnitUltimateUp;

import java.io.Serializable;

/**
 * 单位觉醒升级 VO
 *
 * @author ruoyi
 */
@Data
@AutoMapper(target = UnitUltimateUp.class)
public class UnitUltimateUpVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "觉醒升级ID")
    private Integer id;

    @ExcelProperty(value = "备注说明")
    private String note;

    @ExcelProperty(value = "区域标识")
    private String region;

    @ExcelProperty(value = "UI字符串ID")
    private Integer uiString;

    @ExcelProperty(value = "觉醒消耗")
    private Integer ultimateCost;

    @ExcelProperty(value = "材料ID_1")
    private Integer materialId1;

    @ExcelProperty(value = "材料数量_1")
    private Integer materialCount1;

    @ExcelProperty(value = "材料ID_2")
    private Integer materialId2;

    @ExcelProperty(value = "材料数量_2")
    private Integer materialCount2;

    @ExcelProperty(value = "材料ID_3")
    private Integer materialId3;

    @ExcelProperty(value = "材料数量_3")
    private Integer materialCount3;

    @ExcelProperty(value = "材料ID_4")
    private Integer materialId4;

    @ExcelProperty(value = "材料数量_4")
    private Integer materialCount4;

    @ExcelProperty(value = "材料ID_5")
    private Integer materialId5;

    @ExcelProperty(value = "材料数量_5")
    private Integer materialCount5;

    @ExcelProperty(value = "生命值")
    private Integer hp;

    @ExcelProperty(value = "攻击力")
    private Integer attack;

    @ExcelProperty(value = "护甲")
    private Integer armor;

    @ExcelProperty(value = "槽位开放")
    private Integer slotOpen;

    @ExcelProperty(value = "单位ID")
    private Integer unitId;
}
