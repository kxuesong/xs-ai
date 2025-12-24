package org.ruoyi.game.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.ruoyi.game.domain.UnitBook;

import java.io.Serializable;

/**
 * 单位图鉴 VO
 *
 * @author ruoyi
 */
@Data
@AutoMapper(target = UnitBook.class)
public class UnitBookVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 图鉴ID
     */
    @ExcelProperty(value = "图鉴ID")
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
     * 是否隐藏单位
     */
    @ExcelProperty(value = "是否隐藏单位")
    private Byte unitHide;

    /**
     * 分类ID
     */
    @ExcelProperty(value = "分类ID")
    private Byte categoryId;

    /**
     * 组ID
     */
    @ExcelProperty(value = "组ID")
    private Integer groupId;

    /**
     * 编号
     */
    @ExcelProperty(value = "编号")
    private Integer number;

    /**
     * 介绍ID
     */
    @ExcelProperty(value = "介绍ID")
    private Integer introduceId;

    /**
     * 获取方式1
     */
    @ExcelProperty(value = "获取方式1")
    private Integer acquire1;

    /**
     * 获取方式2
     */
    @ExcelProperty(value = "获取方式2")
    private Integer acquire2;

    /**
     * 获取方式3
     */
    @ExcelProperty(value = "获取方式3")
    private Integer acquire3;

    /**
     * 获取方式4
     */
    @ExcelProperty(value = "获取方式4")
    private Integer acquire4;

    /**
     * 获取方式5
     */
    @ExcelProperty(value = "获取方式5")
    private Integer acquire5;
}
