package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.TutorialEvent;
import org.ruoyi.game.domain.vo.TutorialEventVo;

import java.util.Collection;
import java.util.List;

/**
 * 教程事件 Service 接口
 *
 * @author ruoyi
 */
public interface ITutorialEventService {

    /**
     * 查询教程事件
     */
    TutorialEventVo queryById(Integer id);

    /**
     * 查询教程事件列表（分页）
     */
    TableDataInfo<TutorialEventVo> queryPageList(TutorialEvent tutorialEvent, PageQuery pageQuery);

    /**
     * 查询教程事件列表
     */
    List<TutorialEventVo> queryList(TutorialEvent tutorialEvent);

    /**
     * 新增教程事件
     */
    Boolean insertByBo(TutorialEvent tutorialEvent);

    /**
     * 修改教程事件
     */
    Boolean updateByBo(TutorialEvent tutorialEvent);

    /**
     * 批量删除教程事件
     */
    Boolean deleteByIds(Collection<Integer> ids);
}
