package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.TutorialEvent;
import org.ruoyi.game.domain.vo.TutorialEventVo;
import org.ruoyi.game.mapper.TutorialEventMapper;
import org.ruoyi.game.service.ITutorialEventService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 教程事件 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class TutorialEventServiceImpl implements ITutorialEventService {

    private final TutorialEventMapper tutorialEventMapper;

    @Override
    public TutorialEventVo queryById(Integer id) {
        return tutorialEventMapper.selectVoById(id);
    }

    @Override
    public TableDataInfo<TutorialEventVo> queryPageList(TutorialEvent tutorialEvent, PageQuery pageQuery) {
        LambdaQueryWrapper<TutorialEvent> lqw = buildQueryWrapper(tutorialEvent);
        Page<TutorialEventVo> result = tutorialEventMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<TutorialEventVo> queryList(TutorialEvent tutorialEvent) {
        LambdaQueryWrapper<TutorialEvent> lqw = buildQueryWrapper(tutorialEvent);
        return tutorialEventMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<TutorialEvent> buildQueryWrapper(TutorialEvent tutorialEvent) {
        LambdaQueryWrapper<TutorialEvent> lqw = Wrappers.lambdaQuery();
        lqw.eq(tutorialEvent.getId() != null, TutorialEvent::getId, tutorialEvent.getId());
        lqw.like(StringUtils.isNotBlank(tutorialEvent.getNote()), TutorialEvent::getNote, tutorialEvent.getNote());
        lqw.eq(StringUtils.isNotBlank(tutorialEvent.getRegion()), TutorialEvent::getRegion, tutorialEvent.getRegion());
        lqw.orderByAsc(TutorialEvent::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(TutorialEvent tutorialEvent) {
        return tutorialEventMapper.insert(tutorialEvent) > 0;
    }

    @Override
    public Boolean updateByBo(TutorialEvent tutorialEvent) {
        return tutorialEventMapper.updateById(tutorialEvent) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids) {
        return tutorialEventMapper.deleteByIds(ids) > 0;
    }
}
