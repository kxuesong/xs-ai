package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.TutorialFlow;
import org.ruoyi.game.domain.vo.TutorialFlowVo;
import org.ruoyi.game.mapper.TutorialFlowMapper;
import org.ruoyi.game.service.ITutorialFlowService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 教程流程 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class TutorialFlowServiceImpl implements ITutorialFlowService {

    private final TutorialFlowMapper tutorialFlowMapper;

    @Override
    public TutorialFlowVo queryById(Integer id, String region) {
        LambdaQueryWrapper<TutorialFlow> lqw = Wrappers.lambdaQuery();
        lqw.eq(TutorialFlow::getId, id)
           .eq(StringUtils.isNotBlank(region), TutorialFlow::getRegion, region);
        return tutorialFlowMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<TutorialFlowVo> queryPageList(TutorialFlow tutorialFlow, PageQuery pageQuery) {
        LambdaQueryWrapper<TutorialFlow> lqw = buildQueryWrapper(tutorialFlow);
        Page<TutorialFlowVo> result = tutorialFlowMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<TutorialFlowVo> queryList(TutorialFlow tutorialFlow) {
        LambdaQueryWrapper<TutorialFlow> lqw = buildQueryWrapper(tutorialFlow);
        return tutorialFlowMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<TutorialFlow> buildQueryWrapper(TutorialFlow tutorialFlow) {
        LambdaQueryWrapper<TutorialFlow> lqw = Wrappers.lambdaQuery();
        lqw.eq(tutorialFlow.getId() != null, TutorialFlow::getId, tutorialFlow.getId());
        lqw.like(StringUtils.isNotBlank(tutorialFlow.getNote()), TutorialFlow::getNote, tutorialFlow.getNote());
        lqw.eq(StringUtils.isNotBlank(tutorialFlow.getRegion()), TutorialFlow::getRegion, tutorialFlow.getRegion());
        lqw.eq(tutorialFlow.getTutorialStep() != null, TutorialFlow::getTutorialStep, tutorialFlow.getTutorialStep());
        lqw.orderByAsc(TutorialFlow::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(TutorialFlow tutorialFlow) {
        return tutorialFlowMapper.insert(tutorialFlow) > 0;
    }

    @Override
    public Boolean updateByBo(TutorialFlow tutorialFlow) {
        LambdaQueryWrapper<TutorialFlow> lqw = Wrappers.lambdaQuery();
        lqw.eq(TutorialFlow::getId, tutorialFlow.getId())
           .eq(TutorialFlow::getRegion, tutorialFlow.getRegion());
        return tutorialFlowMapper.update(tutorialFlow, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<TutorialFlow> lqw = Wrappers.lambdaQuery();
        lqw.in(TutorialFlow::getId, ids)
           .eq(StringUtils.isNotBlank(region), TutorialFlow::getRegion, region);
        return tutorialFlowMapper.delete(lqw) > 0;
    }
}
