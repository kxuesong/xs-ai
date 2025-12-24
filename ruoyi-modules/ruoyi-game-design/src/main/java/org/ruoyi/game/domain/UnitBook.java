package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 单位图鉴对象 tb_unit_book
 *
 * @author ruoyi
 */
@Data
@TableName("tb_unit_book")
public class UnitBook implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 图鉴ID
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
     * 是否隐藏单位
     */
    private Byte unitHide;

    /**
     * 分类ID
     */
    private Byte categoryId;

    /**
     * 组ID
     */
    private Integer groupId;

    /**
     * 编号
     */
    private Integer number;

    /**
     * 介绍ID
     */
    private Integer introduceId;

    /**
     * 获取方式1
     */
    @TableField("acquire_1")
    private Integer acquire1;

    /**
     * 获取方式2
     */
    @TableField("acquire_2")
    private Integer acquire2;

    /**
     * 获取方式3
     */
    @TableField("acquire_3")
    private Integer acquire3;

    /**
     * 获取方式4
     */
    @TableField("acquire_4")
    private Integer acquire4;

    /**
     * 获取方式5
     */
    @TableField("acquire_5")
    private Integer acquire5;
}
