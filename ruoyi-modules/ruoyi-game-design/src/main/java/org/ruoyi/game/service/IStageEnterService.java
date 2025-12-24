package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.StageEnter;
import org.ruoyi.game.domain.vo.StageEnterVo;

import java.util.Collection;
import java.util.List;

/**
 * 关卡入口 Service 接口
 *
 * @author ruoyi
 */
public interface IStageEnterService {

    /**
     * 查询关卡入口
     */
    StageEnterVo queryById(Integer id, String region);

    /**
     * 查询关卡入口列表（分页）
     */
    TableDataInfo<StageEnterVo> queryPageList(StageEnter stageEnter, PageQuery pageQuery);

    /**
     * 查询关卡入口列表
     */
    List<StageEnterVo> queryList(StageEnter stageEnter);

    /**
     * 按关卡组ID查询入口
     */
    List<StageEnterVo> queryByStageGroupId(Integer stageGroupId, String region);

    /**
     * 新增关卡入口
     */
    Boolean insertByBo(StageEnter stageEnter);

    /**
     * 修改关卡入口
     */
    Boolean updateByBo(StageEnter stageEnter);

    /**
     * 批量删除关卡入口
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
