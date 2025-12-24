package org.ruoyi.game.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.ruoyi.game.domain.UnitGradeReward;

import java.io.Serializable;

/**
 * 单位品质奖励 VO
 *
 * @author ruoyi
 */
@Data
@AutoMapper(target = UnitGradeReward.class)
public class UnitGradeRewardVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 品质奖励ID
     */
    @ExcelProperty(value = "品质奖励ID")
    private Integer id;

    /**
     * 备注说明
     */
    @ExcelProperty(value = "备注说明")
    private String note;

    /**
     * 备注说明2
     */
    @ExcelProperty(value = "备注说明2")
    private String note2;

    /**
     * 区域标识
     */
    @ExcelProperty(value = "区域标识")
    private String region;

    /**
     * 品质奖励组
     */
    @ExcelProperty(value = "品质奖励组")
    private Integer gradeRewardGroup;

    /**
     * 品质字符串
     */
    @ExcelProperty(value = "品质字符串")
    private Integer gradeString;

    /**
     * 品质类型
     */
    @ExcelProperty(value = "品质类型")
    private String gradeType;

    /**
     * 单位品质
     */
    @ExcelProperty(value = "单位品质")
    private Integer unitGrade;

    /**
     * 品质奖励类型
     */
    @ExcelProperty(value = "品质奖励类型")
    private Integer gradeRewardType;

    /**
     * 品质奖励ID
     */
    @ExcelProperty(value = "品质奖励ID")
    private Integer gradeRewardId;

    /**
     * 品质奖励数量
     */
    @ExcelProperty(value = "品质奖励数量")
    private Integer gradeRewardCount;
}
