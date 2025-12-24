package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.UnitGradeReward;
import org.ruoyi.game.domain.vo.UnitGradeRewardVo;
import org.ruoyi.game.mapper.UnitGradeRewardMapper;
import org.ruoyi.game.service.IUnitGradeRewardService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 单位品质奖励 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class UnitGradeRewardServiceImpl implements IUnitGradeRewardService {

    private final UnitGradeRewardMapper unitGradeRewardMapper;

    @Override
    public UnitGradeRewardVo queryById(Integer id, String region) {
        LambdaQueryWrapper<UnitGradeReward> lqw = Wrappers.lambdaQuery();
        lqw.eq(UnitGradeReward::getId, id)
           .eq(StringUtils.isNotBlank(region), UnitGradeReward::getRegion, region);
        return unitGradeRewardMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<UnitGradeRewardVo> queryPageList(UnitGradeReward unitGradeReward, PageQuery pageQuery) {
        LambdaQueryWrapper<UnitGradeReward> lqw = buildQueryWrapper(unitGradeReward);
        Page<UnitGradeRewardVo> result = unitGradeRewardMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<UnitGradeRewardVo> queryList(UnitGradeReward unitGradeReward) {
        LambdaQueryWrapper<UnitGradeReward> lqw = buildQueryWrapper(unitGradeReward);
        return unitGradeRewardMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<UnitGradeReward> buildQueryWrapper(UnitGradeReward unitGradeReward) {
        LambdaQueryWrapper<UnitGradeReward> lqw = Wrappers.lambdaQuery();
        lqw.eq(unitGradeReward.getId() != null, UnitGradeReward::getId, unitGradeReward.getId());
        lqw.like(StringUtils.isNotBlank(unitGradeReward.getNote()), UnitGradeReward::getNote, unitGradeReward.getNote());
        lqw.eq(StringUtils.isNotBlank(unitGradeReward.getRegion()), UnitGradeReward::getRegion, unitGradeReward.getRegion());
        lqw.eq(unitGradeReward.getGradeRewardGroup() != null, UnitGradeReward::getGradeRewardGroup, unitGradeReward.getGradeRewardGroup());
        lqw.eq(unitGradeReward.getUnitGrade() != null, UnitGradeReward::getUnitGrade, unitGradeReward.getUnitGrade());
        lqw.eq(StringUtils.isNotBlank(unitGradeReward.getGradeType()), UnitGradeReward::getGradeType, unitGradeReward.getGradeType());
        lqw.orderByAsc(UnitGradeReward::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(UnitGradeReward unitGradeReward) {
        return unitGradeRewardMapper.insert(unitGradeReward) > 0;
    }

    @Override
    public Boolean updateByBo(UnitGradeReward unitGradeReward) {
        LambdaQueryWrapper<UnitGradeReward> lqw = Wrappers.lambdaQuery();
        lqw.eq(UnitGradeReward::getId, unitGradeReward.getId())
           .eq(UnitGradeReward::getRegion, unitGradeReward.getRegion());
        return unitGradeRewardMapper.update(unitGradeReward, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<UnitGradeReward> lqw = Wrappers.lambdaQuery();
        lqw.in(UnitGradeReward::getId, ids)
           .eq(StringUtils.isNotBlank(region), UnitGradeReward::getRegion, region);
        return unitGradeRewardMapper.delete(lqw) > 0;
    }
}
