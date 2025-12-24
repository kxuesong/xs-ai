package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.StageAttribute;
import org.ruoyi.game.domain.vo.StageAttributeVo;
import org.ruoyi.game.mapper.StageAttributeMapper;
import org.ruoyi.game.service.IStageAttributeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 关卡属性 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class StageAttributeServiceImpl implements IStageAttributeService {

    private final StageAttributeMapper stageAttributeMapper;

    @Override
    public StageAttributeVo queryById(Integer id, String region) {
        LambdaQueryWrapper<StageAttribute> lqw = Wrappers.lambdaQuery();
        lqw.eq(StageAttribute::getId, id)
           .eq(StringUtils.isNotBlank(region), StageAttribute::getRegion, region);
        return stageAttributeMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<StageAttributeVo> queryPageList(StageAttribute stageAttribute, PageQuery pageQuery) {
        LambdaQueryWrapper<StageAttribute> lqw = buildQueryWrapper(stageAttribute);
        Page<StageAttributeVo> result = stageAttributeMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<StageAttributeVo> queryList(StageAttribute stageAttribute) {
        LambdaQueryWrapper<StageAttribute> lqw = buildQueryWrapper(stageAttribute);
        return stageAttributeMapper.selectVoList(lqw);
    }

    @Override
    public List<StageAttributeVo> queryByStageGroupId(Integer stageGroupId, String region) {
        LambdaQueryWrapper<StageAttribute> lqw = Wrappers.lambdaQuery();
        lqw.eq(StageAttribute::getStageGroupId, stageGroupId)
           .eq(StringUtils.isNotBlank(region), StageAttribute::getRegion, region)
           .orderByAsc(StageAttribute::getId);
        return stageAttributeMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<StageAttribute> buildQueryWrapper(StageAttribute stageAttribute) {
        LambdaQueryWrapper<StageAttribute> lqw = Wrappers.lambdaQuery();
        lqw.eq(stageAttribute.getId() != null, StageAttribute::getId, stageAttribute.getId());
        lqw.like(StringUtils.isNotBlank(stageAttribute.getNote()), StageAttribute::getNote, stageAttribute.getNote());
        lqw.eq(StringUtils.isNotBlank(stageAttribute.getRegion()), StageAttribute::getRegion, stageAttribute.getRegion());
        lqw.eq(stageAttribute.getStageGroupId() != null, StageAttribute::getStageGroupId, stageAttribute.getStageGroupId());
        lqw.eq(stageAttribute.getStageType() != null, StageAttribute::getStageType, stageAttribute.getStageType());
        lqw.orderByAsc(StageAttribute::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(StageAttribute stageAttribute) {
        return stageAttributeMapper.insert(stageAttribute) > 0;
    }

    @Override
    public Boolean updateByBo(StageAttribute stageAttribute) {
        LambdaQueryWrapper<StageAttribute> lqw = Wrappers.lambdaQuery();
        lqw.eq(StageAttribute::getId, stageAttribute.getId())
           .eq(StageAttribute::getRegion, stageAttribute.getRegion());
        return stageAttributeMapper.update(stageAttribute, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<StageAttribute> lqw = Wrappers.lambdaQuery();
        lqw.in(StageAttribute::getId, ids)
           .eq(StringUtils.isNotBlank(region), StageAttribute::getRegion, region);
        return stageAttributeMapper.delete(lqw) > 0;
    }
}
