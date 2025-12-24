package org.ruoyi.game.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.ruoyi.game.domain.UnitExp;

import java.io.Serializable;

/**
 * 单位经验表 VO
 *
 * @author ruoyi
 */
@Data
@AutoMapper(target = UnitExp.class)
public class UnitExpVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 经验配置ID
     */
    @ExcelProperty(value = "经验配置ID")
    private Integer id;

    /**
     * 区域标识
     */
    @ExcelProperty(value = "区域标识")
    private String region;

    /**
     * 品质等级
     */
    @ExcelProperty(value = "品质等级")
    private Byte grade;

    /**
     * 等级
     */
    @ExcelProperty(value = "等级")
    private Integer level;

    /**
     * 升级所需经验
     */
    @ExcelProperty(value = "升级所需经验")
    private Integer exp;

    /**
     * 累计总经验
     */
    @ExcelProperty(value = "累计总经验")
    private Long expSum;

    /**
     * 最小经验值
     */
    @ExcelProperty(value = "最小经验值")
    private Integer expMin;

    /**
     * 最大经验值
     */
    @ExcelProperty(value = "最大经验值")
    private Integer expMax;
}
