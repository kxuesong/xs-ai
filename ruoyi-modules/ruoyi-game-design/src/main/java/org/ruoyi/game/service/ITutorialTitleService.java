package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.TutorialTitle;
import org.ruoyi.game.domain.vo.TutorialTitleVo;

import java.util.Collection;
import java.util.List;

/**
 * 教程标题 Service 接口
 *
 * @author ruoyi
 */
public interface ITutorialTitleService {

    /**
     * 查询教程标题
     */
    TutorialTitleVo queryById(Integer id, String region);

    /**
     * 查询教程标题列表（分页）
     */
    TableDataInfo<TutorialTitleVo> queryPageList(TutorialTitle tutorialTitle, PageQuery pageQuery);

    /**
     * 查询教程标题列表
     */
    List<TutorialTitleVo> queryList(TutorialTitle tutorialTitle);

    /**
     * 新增教程标题
     */
    Boolean insertByBo(TutorialTitle tutorialTitle);

    /**
     * 修改教程标题
     */
    Boolean updateByBo(TutorialTitle tutorialTitle);

    /**
     * 批量删除教程标题
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
