package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 单位品质奖励对象 tb_unit_grade_reward
 *
 * @author ruoyi
 */
@Data
@TableName("tb_unit_grade_reward")
public class UnitGradeReward implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 品质奖励ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 备注说明
     */
    private String note;

    /**
     * 备注说明2
     */
    private String note2;

    /**
     * 区域标识
     */
    private String region;

    /**
     * 品质奖励组
     */
    private Integer gradeRewardGroup;

    /**
     * 品质字符串
     */
    private Integer gradeString;

    /**
     * 品质类型
     */
    private String gradeType;

    /**
     * 单位品质
     */
    private Integer unitGrade;

    /**
     * 品质奖励类型
     */
    private Integer gradeRewardType;

    /**
     * 品质奖励ID
     */
    private Integer gradeRewardId;

    /**
     * 品质奖励数量
     */
    private Integer gradeRewardCount;
}
