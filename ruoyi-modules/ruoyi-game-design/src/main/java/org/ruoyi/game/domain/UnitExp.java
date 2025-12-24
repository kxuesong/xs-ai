package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 单位经验表对象 tb_unit_exp
 *
 * @author ruoyi
 */
@Data
@TableName("tb_unit_exp")
public class UnitExp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 经验配置ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 区域标识
     */
    private String region;

    /**
     * 品质等级
     */
    private Byte grade;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 升级所需经验
     */
    private Integer exp;

    /**
     * 累计总经验
     */
    private Long expSum;

    /**
     * 最小经验值
     */
    private Integer expMin;

    /**
     * 最大经验值
     */
    private Integer expMax;
}
