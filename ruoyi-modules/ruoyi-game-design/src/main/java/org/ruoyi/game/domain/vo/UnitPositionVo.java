package org.ruoyi.game.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.ruoyi.game.domain.UnitPosition;

import java.io.Serializable;

/**
 * 单位位置定义 VO
 *
 * @author ruoyi
 */
@Data
@AutoMapper(target = UnitPosition.class)
public class UnitPositionVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 位置ID
     */
    @ExcelProperty(value = "位置ID")
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
     * UI字符串ID
     */
    @ExcelProperty(value = "UI字符串ID")
    private Integer uiString;
}
