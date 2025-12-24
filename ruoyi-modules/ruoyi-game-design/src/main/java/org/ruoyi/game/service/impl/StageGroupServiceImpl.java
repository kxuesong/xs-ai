package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.StageGroup;
import org.ruoyi.game.domain.vo.StageGroupVo;
import org.ruoyi.game.mapper.StageGroupMapper;
import org.ruoyi.game.service.IStageGroupService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 关卡组 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class StageGroupServiceImpl implements IStageGroupService {

    private final StageGroupMapper stageGroupMapper;

    @Override
    public StageGroupVo queryById(Integer id, String region) {
        LambdaQueryWrapper<StageGroup> lqw = Wrappers.lambdaQuery();
        lqw.eq(StageGroup::getId, id)
           .eq(StringUtils.isNotBlank(region), StageGroup::getRegion, region);
        return stageGroupMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<StageGroupVo> queryPageList(StageGroup stageGroup, PageQuery pageQuery) {
        LambdaQueryWrapper<StageGroup> lqw = buildQueryWrapper(stageGroup);
        Page<StageGroupVo> result = stageGroupMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<StageGroupVo> queryList(StageGroup stageGroup) {
        LambdaQueryWrapper<StageGroup> lqw = buildQueryWrapper(stageGroup);
        return stageGroupMapper.selectVoList(lqw);
    }

    @Override
    public List<StageGroupVo> queryByThemaId(Integer themaId, String region) {
        LambdaQueryWrapper<StageGroup> lqw = Wrappers.lambdaQuery();
        lqw.eq(StageGroup::getThemaGroupId, themaId)
           .eq(StringUtils.isNotBlank(region), StageGroup::getRegion, region)
           .orderByAsc(StageGroup::getId);
        return stageGroupMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<StageGroup> buildQueryWrapper(StageGroup stageGroup) {
        LambdaQueryWrapper<StageGroup> lqw = Wrappers.lambdaQuery();
        lqw.eq(stageGroup.getId() != null, StageGroup::getId, stageGroup.getId());
        lqw.like(StringUtils.isNotBlank(stageGroup.getNote()), StageGroup::getNote, stageGroup.getNote());
        lqw.eq(StringUtils.isNotBlank(stageGroup.getRegion()), StageGroup::getRegion, stageGroup.getRegion());
        lqw.eq(stageGroup.getThemaGroupId() != null, StageGroup::getThemaGroupId, stageGroup.getThemaGroupId());
        lqw.orderByAsc(StageGroup::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(StageGroup stageGroup) {
        return stageGroupMapper.insert(stageGroup) > 0;
    }

    @Override
    public Boolean updateByBo(StageGroup stageGroup) {
        LambdaQueryWrapper<StageGroup> lqw = Wrappers.lambdaQuery();
        lqw.eq(StageGroup::getId, stageGroup.getId())
           .eq(StageGroup::getRegion, stageGroup.getRegion());
        return stageGroupMapper.update(stageGroup, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<StageGroup> lqw = Wrappers.lambdaQuery();
        lqw.in(StageGroup::getId, ids)
           .eq(StringUtils.isNotBlank(region), StageGroup::getRegion, region);
        return stageGroupMapper.delete(lqw) > 0;
    }
}
