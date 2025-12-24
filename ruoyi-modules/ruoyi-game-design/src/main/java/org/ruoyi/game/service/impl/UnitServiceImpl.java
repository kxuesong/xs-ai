package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.Unit;
import org.ruoyi.game.domain.vo.UnitVo;
import org.ruoyi.game.mapper.UnitMapper;
import org.ruoyi.game.service.IUnitService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 单位 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class UnitServiceImpl implements IUnitService {

    private final UnitMapper unitMapper;

    @Override
    public UnitVo queryById(Integer id, String region) {
        LambdaQueryWrapper<Unit> lqw = Wrappers.lambdaQuery();
        lqw.eq(Unit::getId, id)
           .eq(StringUtils.isNotBlank(region), Unit::getRegion, region);
        return unitMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<UnitVo> queryPageList(Unit unit, PageQuery pageQuery) {
        LambdaQueryWrapper<Unit> lqw = buildQueryWrapper(unit);
        Page<UnitVo> result = unitMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<UnitVo> queryList(Unit unit) {
        LambdaQueryWrapper<Unit> lqw = buildQueryWrapper(unit);
        return unitMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<Unit> buildQueryWrapper(Unit unit) {
        LambdaQueryWrapper<Unit> lqw = Wrappers.lambdaQuery();
        lqw.eq(unit.getId() != null, Unit::getId, unit.getId());
        lqw.like(StringUtils.isNotBlank(unit.getNote()), Unit::getNote, unit.getNote());
        lqw.eq(StringUtils.isNotBlank(unit.getRegion()), Unit::getRegion, unit.getRegion());
        lqw.eq(unit.getGrade() != null, Unit::getGrade, unit.getGrade());
        lqw.eq(unit.getUltimate() != null, Unit::getUltimate, unit.getUltimate());
        lqw.eq(unit.getUnitGroup() != null, Unit::getUnitGroup, unit.getUnitGroup());
        lqw.eq(unit.getBattleType() != null, Unit::getBattleType, unit.getBattleType());
        lqw.eq(unit.getUnitExclusive() != null, Unit::getUnitExclusive, unit.getUnitExclusive());
        lqw.eq(unit.getUnitCategoryId() != null, Unit::getUnitCategoryId, unit.getUnitCategoryId());
        lqw.orderByAsc(Unit::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(Unit unit) {
        return unitMapper.insert(unit) > 0;
    }

    @Override
    public Boolean updateByBo(Unit unit) {
        LambdaQueryWrapper<Unit> lqw = Wrappers.lambdaQuery();
        lqw.eq(Unit::getId, unit.getId())
           .eq(Unit::getRegion, unit.getRegion());
        return unitMapper.update(unit, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<Unit> lqw = Wrappers.lambdaQuery();
        lqw.in(Unit::getId, ids)
           .eq(StringUtils.isNotBlank(region), Unit::getRegion, region);
        return unitMapper.delete(lqw) > 0;
    }
}
