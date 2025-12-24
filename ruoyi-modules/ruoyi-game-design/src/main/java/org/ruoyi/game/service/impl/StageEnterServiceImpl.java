package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.StageEnter;
import org.ruoyi.game.domain.vo.StageEnterVo;
import org.ruoyi.game.mapper.StageEnterMapper;
import org.ruoyi.game.service.IStageEnterService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 关卡入口 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class StageEnterServiceImpl implements IStageEnterService {

    private final StageEnterMapper stageEnterMapper;

    @Override
    public StageEnterVo queryById(Integer id, String region) {
        LambdaQueryWrapper<StageEnter> lqw = Wrappers.lambdaQuery();
        lqw.eq(StageEnter::getId, id)
           .eq(StringUtils.isNotBlank(region), StageEnter::getRegion, region);
        return stageEnterMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<StageEnterVo> queryPageList(StageEnter stageEnter, PageQuery pageQuery) {
        LambdaQueryWrapper<StageEnter> lqw = buildQueryWrapper(stageEnter);
        Page<StageEnterVo> result = stageEnterMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<StageEnterVo> queryList(StageEnter stageEnter) {
        LambdaQueryWrapper<StageEnter> lqw = buildQueryWrapper(stageEnter);
        return stageEnterMapper.selectVoList(lqw);
    }

    @Override
    @Deprecated
    public List<StageEnterVo> queryByStageGroupId(Integer stageGroupId, String region) {
        // 注意：数据库表 tb_stage_enter 中没有 stage_group_id 字段
        // 此方法已废弃，返回空列表
        return List.of();
    }

    private LambdaQueryWrapper<StageEnter> buildQueryWrapper(StageEnter stageEnter) {
        LambdaQueryWrapper<StageEnter> lqw = Wrappers.lambdaQuery();
        lqw.eq(stageEnter.getId() != null, StageEnter::getId, stageEnter.getId());
        lqw.like(StringUtils.isNotBlank(stageEnter.getNote()), StageEnter::getNote, stageEnter.getNote());
        lqw.eq(StringUtils.isNotBlank(stageEnter.getRegion()), StageEnter::getRegion, stageEnter.getRegion());
        // 注意：stageGroupId 字段在数据库中不存在，已移除相关查询条件
        lqw.orderByAsc(StageEnter::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(StageEnter stageEnter) {
        return stageEnterMapper.insert(stageEnter) > 0;
    }

    @Override
    public Boolean updateByBo(StageEnter stageEnter) {
        LambdaQueryWrapper<StageEnter> lqw = Wrappers.lambdaQuery();
        lqw.eq(StageEnter::getId, stageEnter.getId())
           .eq(StageEnter::getRegion, stageEnter.getRegion());
        return stageEnterMapper.update(stageEnter, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<StageEnter> lqw = Wrappers.lambdaQuery();
        lqw.in(StageEnter::getId, ids)
           .eq(StringUtils.isNotBlank(region), StageEnter::getRegion, region);
        return stageEnterMapper.delete(lqw) > 0;
    }
}
