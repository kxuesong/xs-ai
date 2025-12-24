package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 单位位置定义对象 tb_unit_position
 *
 * @author ruoyi
 */
@Data
@TableName("tb_unit_position")
public class UnitPosition implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 位置ID
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
}
