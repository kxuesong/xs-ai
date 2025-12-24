package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.StageReward;
import org.ruoyi.game.domain.vo.StageRewardVo;
import org.ruoyi.game.mapper.StageRewardMapper;
import org.ruoyi.game.service.IStageRewardService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 关卡奖励 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class StageRewardServiceImpl implements IStageRewardService {

    private final StageRewardMapper stageRewardMapper;

    @Override
    public StageRewardVo queryById(Integer id, String region) {
        LambdaQueryWrapper<StageReward> lqw = Wrappers.lambdaQuery();
        lqw.eq(StageReward::getId, id)
           .eq(StringUtils.isNotBlank(region), StageReward::getRegion, region);
        return stageRewardMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<StageRewardVo> queryPageList(StageReward stageReward, PageQuery pageQuery) {
        LambdaQueryWrapper<StageReward> lqw = buildQueryWrapper(stageReward);
        Page<StageRewardVo> result = stageRewardMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<StageRewardVo> queryList(StageReward stageReward) {
        LambdaQueryWrapper<StageReward> lqw = buildQueryWrapper(stageReward);
        return stageRewardMapper.selectVoList(lqw);
    }

    @Override
    @Deprecated
    public List<StageRewardVo> queryByStageAttributeId(Integer stageAttributeId, String region) {
        // 注意：数据库表 tb_stage_reward 中没有 stage_attribute_id 字段
        // 此方法已废弃，返回空列表
        return List.of();
    }

    private LambdaQueryWrapper<StageReward> buildQueryWrapper(StageReward stageReward) {
        LambdaQueryWrapper<StageReward> lqw = Wrappers.lambdaQuery();
        lqw.eq(stageReward.getId() != null, StageReward::getId, stageReward.getId());
        lqw.like(StringUtils.isNotBlank(stageReward.getNote()), StageReward::getNote, stageReward.getNote());
        lqw.eq(StringUtils.isNotBlank(stageReward.getRegion()), StageReward::getRegion, stageReward.getRegion());
        // 注意：themaGroupId 字段可以使用
        lqw.eq(stageReward.getThemaGroupId() != null, StageReward::getThemaGroupId, stageReward.getThemaGroupId());
        lqw.orderByAsc(StageReward::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(StageReward stageReward) {
        return stageRewardMapper.insert(stageReward) > 0;
    }

    @Override
    public Boolean updateByBo(StageReward stageReward) {
        LambdaQueryWrapper<StageReward> lqw = Wrappers.lambdaQuery();
        lqw.eq(StageReward::getId, stageReward.getId())
           .eq(StageReward::getRegion, stageReward.getRegion());
        return stageRewardMapper.update(stageReward, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<StageReward> lqw = Wrappers.lambdaQuery();
        lqw.in(StageReward::getId, ids)
           .eq(StringUtils.isNotBlank(region), StageReward::getRegion, region);
        return stageRewardMapper.delete(lqw) > 0;
    }
}
