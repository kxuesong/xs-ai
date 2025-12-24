package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.TutorialCondition;
import org.ruoyi.game.domain.vo.TutorialConditionVo;
import org.ruoyi.game.mapper.TutorialConditionMapper;
import org.ruoyi.game.service.ITutorialConditionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 教程条件 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class TutorialConditionServiceImpl implements ITutorialConditionService {

    private final TutorialConditionMapper tutorialConditionMapper;

    @Override
    public TutorialConditionVo queryById(Integer id, String region) {
        LambdaQueryWrapper<TutorialCondition> lqw = Wrappers.lambdaQuery();
        lqw.eq(TutorialCondition::getId, id)
           .eq(StringUtils.isNotBlank(region), TutorialCondition::getRegion, region);
        return tutorialConditionMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<TutorialConditionVo> queryPageList(TutorialCondition tutorialCondition, PageQuery pageQuery) {
        LambdaQueryWrapper<TutorialCondition> lqw = buildQueryWrapper(tutorialCondition);
        Page<TutorialConditionVo> result = tutorialConditionMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<TutorialConditionVo> queryList(TutorialCondition tutorialCondition) {
        LambdaQueryWrapper<TutorialCondition> lqw = buildQueryWrapper(tutorialCondition);
        return tutorialConditionMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<TutorialCondition> buildQueryWrapper(TutorialCondition tutorialCondition) {
        LambdaQueryWrapper<TutorialCondition> lqw = Wrappers.lambdaQuery();
        lqw.eq(tutorialCondition.getId() != null, TutorialCondition::getId, tutorialCondition.getId());
        lqw.like(StringUtils.isNotBlank(tutorialCondition.getNote()), TutorialCondition::getNote, tutorialCondition.getNote());
        lqw.eq(StringUtils.isNotBlank(tutorialCondition.getRegion()), TutorialCondition::getRegion, tutorialCondition.getRegion());
        lqw.eq(tutorialCondition.getTutorialFlow() != null, TutorialCondition::getTutorialFlow, tutorialCondition.getTutorialFlow());
        lqw.eq(tutorialCondition.getTutorialConditionType() != null, TutorialCondition::getTutorialConditionType, tutorialCondition.getTutorialConditionType());
        lqw.orderByAsc(TutorialCondition::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(TutorialCondition tutorialCondition) {
        return tutorialConditionMapper.insert(tutorialCondition) > 0;
    }

    @Override
    public Boolean updateByBo(TutorialCondition tutorialCondition) {
        LambdaQueryWrapper<TutorialCondition> lqw = Wrappers.lambdaQuery();
        lqw.eq(TutorialCondition::getId, tutorialCondition.getId())
           .eq(TutorialCondition::getRegion, tutorialCondition.getRegion());
        return tutorialConditionMapper.update(tutorialCondition, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<TutorialCondition> lqw = Wrappers.lambdaQuery();
        lqw.in(TutorialCondition::getId, ids)
           .eq(StringUtils.isNotBlank(region), TutorialCondition::getRegion, region);
        return tutorialConditionMapper.delete(lqw) > 0;
    }
}
