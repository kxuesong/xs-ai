package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.TutorialCondition;
import org.ruoyi.game.domain.vo.TutorialConditionVo;

import java.util.Collection;
import java.util.List;

/**
 * 教程条件 Service 接口
 *
 * @author ruoyi
 */
public interface ITutorialConditionService {

    /**
     * 查询教程条件
     */
    TutorialConditionVo queryById(Integer id, String region);

    /**
     * 查询教程条件列表（分页）
     */
    TableDataInfo<TutorialConditionVo> queryPageList(TutorialCondition tutorialCondition, PageQuery pageQuery);

    /**
     * 查询教程条件列表
     */
    List<TutorialConditionVo> queryList(TutorialCondition tutorialCondition);

    /**
     * 新增教程条件
     */
    Boolean insertByBo(TutorialCondition tutorialCondition);

    /**
     * 修改教程条件
     */
    Boolean updateByBo(TutorialCondition tutorialCondition);

    /**
     * 批量删除教程条件
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
