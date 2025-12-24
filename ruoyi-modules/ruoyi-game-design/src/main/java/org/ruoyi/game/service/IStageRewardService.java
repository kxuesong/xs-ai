package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.StageReward;
import org.ruoyi.game.domain.vo.StageRewardVo;

import java.util.Collection;
import java.util.List;

/**
 * 关卡奖励 Service 接口
 *
 * @author ruoyi
 */
public interface IStageRewardService {

    /**
     * 查询关卡奖励
     */
    StageRewardVo queryById(Integer id, String region);

    /**
     * 查询关卡奖励列表（分页）
     */
    TableDataInfo<StageRewardVo> queryPageList(StageReward stageReward, PageQuery pageQuery);

    /**
     * 查询关卡奖励列表
     */
    List<StageRewardVo> queryList(StageReward stageReward);

    /**
     * 按关卡属性ID查询奖励
     */
    List<StageRewardVo> queryByStageAttributeId(Integer stageAttributeId, String region);

    /**
     * 新增关卡奖励
     */
    Boolean insertByBo(StageReward stageReward);

    /**
     * 修改关卡奖励
     */
    Boolean updateByBo(StageReward stageReward);

    /**
     * 批量删除关卡奖励
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
