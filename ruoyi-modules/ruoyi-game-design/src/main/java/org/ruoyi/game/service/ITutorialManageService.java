package org.ruoyi.game.service;

import org.ruoyi.game.domain.vo.TutorialFlowVo;
import org.ruoyi.game.domain.vo.TutorialFullDataVo;
import org.ruoyi.game.domain.vo.TutorialListItemVo;

import java.util.List;

/**
 * 教程综合管理 Service 接口
 *
 * @author ruoyi
 */
public interface ITutorialManageService {

    /**
     * 获取教程列表（含统计信息）
     *
     * @param region 区域（可选）
     * @return 教程列表
     */
    List<TutorialListItemVo> getTutorialList(String region);

    /**
     * 获取教程完整数据（流程链+条件+事件+标题）
     *
     * @param startFlowId 起始流程ID
     * @param region      区域（可选）
     * @return 教程完整数据
     */
    TutorialFullDataVo getTutorialFullData(Integer startFlowId, String region);

    /**
     * 获取流程链（递归查询next_step_id）
     *
     * @param startFlowId 起始流程ID
     * @param region      区域（可选）
     * @return 流程链列表
     */
    List<TutorialFlowVo> getFlowChain(Integer startFlowId, String region);
}
