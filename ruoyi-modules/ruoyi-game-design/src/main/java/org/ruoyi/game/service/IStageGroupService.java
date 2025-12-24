package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.StageGroup;
import org.ruoyi.game.domain.vo.StageGroupVo;

import java.util.Collection;
import java.util.List;

/**
 * 关卡组 Service 接口
 *
 * @author ruoyi
 */
public interface IStageGroupService {

    /**
     * 查询关卡组
     */
    StageGroupVo queryById(Integer id, String region);

    /**
     * 查询关卡组列表（分页）
     */
    TableDataInfo<StageGroupVo> queryPageList(StageGroup stageGroup, PageQuery pageQuery);

    /**
     * 查询关卡组列表
     */
    List<StageGroupVo> queryList(StageGroup stageGroup);

    /**
     * 按主题ID查询关卡组
     */
    List<StageGroupVo> queryByThemaId(Integer themaId, String region);

    /**
     * 新增关卡组
     */
    Boolean insertByBo(StageGroup stageGroup);

    /**
     * 修改关卡组
     */
    Boolean updateByBo(StageGroup stageGroup);

    /**
     * 批量删除关卡组
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
