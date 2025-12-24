package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.TutorialFlow;
import org.ruoyi.game.domain.vo.TutorialFlowVo;

import java.util.Collection;
import java.util.List;

/**
 * 教程流程 Service 接口
 *
 * @author ruoyi
 */
public interface ITutorialFlowService {

    /**
     * 查询教程流程
     */
    TutorialFlowVo queryById(Integer id, String region);

    /**
     * 查询教程流程列表（分页）
     */
    TableDataInfo<TutorialFlowVo> queryPageList(TutorialFlow tutorialFlow, PageQuery pageQuery);

    /**
     * 查询教程流程列表
     */
    List<TutorialFlowVo> queryList(TutorialFlow tutorialFlow);

    /**
     * 新增教程流程
     */
    Boolean insertByBo(TutorialFlow tutorialFlow);

    /**
     * 修改教程流程
     */
    Boolean updateByBo(TutorialFlow tutorialFlow);

    /**
     * 批量删除教程流程
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
