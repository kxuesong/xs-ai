package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.UnitUltimateUp;
import org.ruoyi.game.domain.vo.UnitUltimateUpVo;
import org.ruoyi.game.mapper.UnitUltimateUpMapper;
import org.ruoyi.game.service.IUnitUltimateUpService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 单位觉醒升级 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class UnitUltimateUpServiceImpl implements IUnitUltimateUpService {

    private final UnitUltimateUpMapper unitUltimateUpMapper;

    @Override
    public UnitUltimateUpVo queryById(Integer id, String region) {
        LambdaQueryWrapper<UnitUltimateUp> lqw = Wrappers.lambdaQuery();
        lqw.eq(UnitUltimateUp::getId, id)
           .eq(StringUtils.isNotBlank(region), UnitUltimateUp::getRegion, region);
        return unitUltimateUpMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<UnitUltimateUpVo> queryPageList(UnitUltimateUp unitUltimateUp, PageQuery pageQuery) {
        LambdaQueryWrapper<UnitUltimateUp> lqw = buildQueryWrapper(unitUltimateUp);
        Page<UnitUltimateUpVo> result = unitUltimateUpMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<UnitUltimateUpVo> queryList(UnitUltimateUp unitUltimateUp) {
        LambdaQueryWrapper<UnitUltimateUp> lqw = buildQueryWrapper(unitUltimateUp);
        return unitUltimateUpMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<UnitUltimateUp> buildQueryWrapper(UnitUltimateUp unitUltimateUp) {
        LambdaQueryWrapper<UnitUltimateUp> lqw = Wrappers.lambdaQuery();
        lqw.eq(unitUltimateUp.getId() != null, UnitUltimateUp::getId, unitUltimateUp.getId());
        lqw.like(StringUtils.isNotBlank(unitUltimateUp.getNote()), UnitUltimateUp::getNote, unitUltimateUp.getNote());
        lqw.eq(StringUtils.isNotBlank(unitUltimateUp.getRegion()), UnitUltimateUp::getRegion, unitUltimateUp.getRegion());
        lqw.eq(unitUltimateUp.getUnitId() != null, UnitUltimateUp::getUnitId, unitUltimateUp.getUnitId());
        lqw.orderByAsc(UnitUltimateUp::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(UnitUltimateUp unitUltimateUp) {
        return unitUltimateUpMapper.insert(unitUltimateUp) > 0;
    }

    @Override
    public Boolean updateByBo(UnitUltimateUp unitUltimateUp) {
        LambdaQueryWrapper<UnitUltimateUp> lqw = Wrappers.lambdaQuery();
        lqw.eq(UnitUltimateUp::getId, unitUltimateUp.getId())
           .eq(UnitUltimateUp::getRegion, unitUltimateUp.getRegion());
        return unitUltimateUpMapper.update(unitUltimateUp, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<UnitUltimateUp> lqw = Wrappers.lambdaQuery();
        lqw.in(UnitUltimateUp::getId, ids)
           .eq(StringUtils.isNotBlank(region), UnitUltimateUp::getRegion, region);
        return unitUltimateUpMapper.delete(lqw) > 0;
    }
}
