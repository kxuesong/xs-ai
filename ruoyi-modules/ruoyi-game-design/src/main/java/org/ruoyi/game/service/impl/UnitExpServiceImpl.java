package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.UnitExp;
import org.ruoyi.game.domain.vo.UnitExpVo;
import org.ruoyi.game.mapper.UnitExpMapper;
import org.ruoyi.game.service.IUnitExpService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 单位经验表 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class UnitExpServiceImpl implements IUnitExpService {

    private final UnitExpMapper unitExpMapper;

    @Override
    public UnitExpVo queryById(Integer id, String region) {
        LambdaQueryWrapper<UnitExp> lqw = Wrappers.lambdaQuery();
        lqw.eq(UnitExp::getId, id)
           .eq(StringUtils.isNotBlank(region), UnitExp::getRegion, region);
        return unitExpMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<UnitExpVo> queryPageList(UnitExp unitExp, PageQuery pageQuery) {
        LambdaQueryWrapper<UnitExp> lqw = buildQueryWrapper(unitExp);
        Page<UnitExpVo> result = unitExpMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<UnitExpVo> queryList(UnitExp unitExp) {
        LambdaQueryWrapper<UnitExp> lqw = buildQueryWrapper(unitExp);
        return unitExpMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<UnitExp> buildQueryWrapper(UnitExp unitExp) {
        LambdaQueryWrapper<UnitExp> lqw = Wrappers.lambdaQuery();
        lqw.eq(unitExp.getId() != null, UnitExp::getId, unitExp.getId());
        lqw.eq(StringUtils.isNotBlank(unitExp.getRegion()), UnitExp::getRegion, unitExp.getRegion());
        lqw.eq(unitExp.getGrade() != null, UnitExp::getGrade, unitExp.getGrade());
        lqw.eq(unitExp.getLevel() != null, UnitExp::getLevel, unitExp.getLevel());
        lqw.orderByAsc(UnitExp::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(UnitExp unitExp) {
        return unitExpMapper.insert(unitExp) > 0;
    }

    @Override
    public Boolean updateByBo(UnitExp unitExp) {
        LambdaQueryWrapper<UnitExp> lqw = Wrappers.lambdaQuery();
        lqw.eq(UnitExp::getId, unitExp.getId())
           .eq(UnitExp::getRegion, unitExp.getRegion());
        return unitExpMapper.update(unitExp, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<UnitExp> lqw = Wrappers.lambdaQuery();
        lqw.in(UnitExp::getId, ids)
           .eq(StringUtils.isNotBlank(region), UnitExp::getRegion, region);
        return unitExpMapper.delete(lqw) > 0;
    }
}
