package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.UnitVisual;
import org.ruoyi.game.domain.vo.UnitVisualVo;
import org.ruoyi.game.mapper.UnitVisualMapper;
import org.ruoyi.game.service.IUnitVisualService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 单位视觉资源 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class UnitVisualServiceImpl implements IUnitVisualService {

    private final UnitVisualMapper unitVisualMapper;

    @Override
    public UnitVisualVo queryById(Integer id, String region) {
        LambdaQueryWrapper<UnitVisual> lqw = Wrappers.lambdaQuery();
        lqw.eq(UnitVisual::getId, id)
           .eq(StringUtils.isNotBlank(region), UnitVisual::getRegion, region);
        return unitVisualMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<UnitVisualVo> queryPageList(UnitVisual unitVisual, PageQuery pageQuery) {
        LambdaQueryWrapper<UnitVisual> lqw = buildQueryWrapper(unitVisual);
        Page<UnitVisualVo> result = unitVisualMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<UnitVisualVo> queryList(UnitVisual unitVisual) {
        LambdaQueryWrapper<UnitVisual> lqw = buildQueryWrapper(unitVisual);
        return unitVisualMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<UnitVisual> buildQueryWrapper(UnitVisual unitVisual) {
        LambdaQueryWrapper<UnitVisual> lqw = Wrappers.lambdaQuery();
        lqw.eq(unitVisual.getId() != null, UnitVisual::getId, unitVisual.getId());
        lqw.like(StringUtils.isNotBlank(unitVisual.getNote()), UnitVisual::getNote, unitVisual.getNote());
        lqw.eq(StringUtils.isNotBlank(unitVisual.getRegion()), UnitVisual::getRegion, unitVisual.getRegion());
        lqw.like(StringUtils.isNotBlank(unitVisual.getUnitPrefab()), UnitVisual::getUnitPrefab, unitVisual.getUnitPrefab());
        lqw.orderByAsc(UnitVisual::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(UnitVisual unitVisual) {
        return unitVisualMapper.insert(unitVisual) > 0;
    }

    @Override
    public Boolean updateByBo(UnitVisual unitVisual) {
        LambdaQueryWrapper<UnitVisual> lqw = Wrappers.lambdaQuery();
        lqw.eq(UnitVisual::getId, unitVisual.getId())
           .eq(UnitVisual::getRegion, unitVisual.getRegion());
        return unitVisualMapper.update(unitVisual, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<UnitVisual> lqw = Wrappers.lambdaQuery();
        lqw.in(UnitVisual::getId, ids)
           .eq(StringUtils.isNotBlank(region), UnitVisual::getRegion, region);
        return unitVisualMapper.delete(lqw) > 0;
    }
}
