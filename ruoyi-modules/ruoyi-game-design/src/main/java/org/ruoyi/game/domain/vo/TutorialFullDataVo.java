package org.ruoyi.game.domain.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 教程完整数据视图对象
 *
 * @author ruoyi
 */
@Data
public class TutorialFullDataVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 流程链
     */
    private List<TutorialFlowVo> flowChain;

    /**
     * 条件列表
     */
    private List<TutorialConditionVo> conditions;

    /**
     * 事件列表
     */
    private List<TutorialEventVo> events;

    /**
     * 标题列表
     */
    private List<TutorialTitleVo> titles;
}
