package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.UnitPosition;
import org.ruoyi.game.domain.vo.UnitPositionVo;
import org.ruoyi.game.mapper.UnitPositionMapper;
import org.ruoyi.game.service.IUnitPositionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 单位位置定义 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class UnitPositionServiceImpl implements IUnitPositionService {

    private final UnitPositionMapper unitPositionMapper;

    @Override
    public UnitPositionVo queryById(Integer id, String region) {
        LambdaQueryWrapper<UnitPosition> lqw = Wrappers.lambdaQuery();
        lqw.eq(UnitPosition::getId, id)
           .eq(StringUtils.isNotBlank(region), UnitPosition::getRegion, region);
        return unitPositionMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<UnitPositionVo> queryPageList(UnitPosition unitPosition, PageQuery pageQuery) {
        LambdaQueryWrapper<UnitPosition> lqw = buildQueryWrapper(unitPosition);
        Page<UnitPositionVo> result = unitPositionMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<UnitPositionVo> queryList(UnitPosition unitPosition) {
        LambdaQueryWrapper<UnitPosition> lqw = buildQueryWrapper(unitPosition);
        return unitPositionMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<UnitPosition> buildQueryWrapper(UnitPosition unitPosition) {
        LambdaQueryWrapper<UnitPosition> lqw = Wrappers.lambdaQuery();
        lqw.eq(unitPosition.getId() != null, UnitPosition::getId, unitPosition.getId());
        lqw.like(StringUtils.isNotBlank(unitPosition.getNote()), UnitPosition::getNote, unitPosition.getNote());
        lqw.eq(StringUtils.isNotBlank(unitPosition.getRegion()), UnitPosition::getRegion, unitPosition.getRegion());
        lqw.eq(unitPosition.getUiString() != null, UnitPosition::getUiString, unitPosition.getUiString());
        lqw.orderByAsc(UnitPosition::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(UnitPosition unitPosition) {
        return unitPositionMapper.insert(unitPosition) > 0;
    }

    @Override
    public Boolean updateByBo(UnitPosition unitPosition) {
        LambdaQueryWrapper<UnitPosition> lqw = Wrappers.lambdaQuery();
        lqw.eq(UnitPosition::getId, unitPosition.getId())
           .eq(UnitPosition::getRegion, unitPosition.getRegion());
        return unitPositionMapper.update(unitPosition, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<UnitPosition> lqw = Wrappers.lambdaQuery();
        lqw.in(UnitPosition::getId, ids)
           .eq(StringUtils.isNotBlank(region), UnitPosition::getRegion, region);
        return unitPositionMapper.delete(lqw) > 0;
    }
}
