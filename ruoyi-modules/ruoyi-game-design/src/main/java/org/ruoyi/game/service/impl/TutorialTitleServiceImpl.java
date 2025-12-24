package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.TutorialTitle;
import org.ruoyi.game.domain.vo.TutorialTitleVo;
import org.ruoyi.game.mapper.TutorialTitleMapper;
import org.ruoyi.game.service.ITutorialTitleService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 教程标题 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class TutorialTitleServiceImpl implements ITutorialTitleService {

    private final TutorialTitleMapper tutorialTitleMapper;

    @Override
    public TutorialTitleVo queryById(Integer id, String region) {
        LambdaQueryWrapper<TutorialTitle> lqw = Wrappers.lambdaQuery();
        lqw.eq(TutorialTitle::getId, id)
           .eq(StringUtils.isNotBlank(region), TutorialTitle::getRegion, region);
        return tutorialTitleMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<TutorialTitleVo> queryPageList(TutorialTitle tutorialTitle, PageQuery pageQuery) {
        LambdaQueryWrapper<TutorialTitle> lqw = buildQueryWrapper(tutorialTitle);
        Page<TutorialTitleVo> result = tutorialTitleMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<TutorialTitleVo> queryList(TutorialTitle tutorialTitle) {
        LambdaQueryWrapper<TutorialTitle> lqw = buildQueryWrapper(tutorialTitle);
        return tutorialTitleMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<TutorialTitle> buildQueryWrapper(TutorialTitle tutorialTitle) {
        LambdaQueryWrapper<TutorialTitle> lqw = Wrappers.lambdaQuery();
        lqw.eq(tutorialTitle.getId() != null, TutorialTitle::getId, tutorialTitle.getId());
        lqw.like(StringUtils.isNotBlank(tutorialTitle.getNote()), TutorialTitle::getNote, tutorialTitle.getNote());
        lqw.eq(StringUtils.isNotBlank(tutorialTitle.getRegion()), TutorialTitle::getRegion, tutorialTitle.getRegion());
        lqw.orderByAsc(TutorialTitle::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(TutorialTitle tutorialTitle) {
        return tutorialTitleMapper.insert(tutorialTitle) > 0;
    }

    @Override
    public Boolean updateByBo(TutorialTitle tutorialTitle) {
        LambdaQueryWrapper<TutorialTitle> lqw = Wrappers.lambdaQuery();
        lqw.eq(TutorialTitle::getId, tutorialTitle.getId())
           .eq(TutorialTitle::getRegion, tutorialTitle.getRegion());
        return tutorialTitleMapper.update(tutorialTitle, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<TutorialTitle> lqw = Wrappers.lambdaQuery();
        lqw.in(TutorialTitle::getId, ids)
           .eq(StringUtils.isNotBlank(region), TutorialTitle::getRegion, region);
        return tutorialTitleMapper.delete(lqw) > 0;
    }
}
