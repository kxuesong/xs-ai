package org.ruoyi.game.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * 教程标题实体
 *
 * @author ruoyi
 */
@Data
@TableName("tb_tutorial_title")
public class TutorialTitle implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 标题ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 备注说明
     */
    private String note;

    /**
     * 区域
     */
    private String region;

    /**
     * 获取标题字符串
     */
    private String titleGetString;

    /**
     * 单位标题ID
     */
    private Integer unitTitleId;
}
