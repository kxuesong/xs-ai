package org.ruoyi.game.domain.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 教程列表项视图对象
 *
 * @author ruoyi
 */
@Data
public class TutorialListItemVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 起始流程ID
     */
    private Integer startFlowId;

    /**
     * 教程名称
     */
    private String name;

    /**
     * 区域
     */
    private String region;

    /**
     * 步骤数量
     */
    private Integer stepCount;

    /**
     * 条件数量
     */
    private Integer conditionCount;

    /**
     * 事件数量
     */
    private Integer eventCount;

    /**
     * 标题数量
     */
    private Integer titleCount;
}
