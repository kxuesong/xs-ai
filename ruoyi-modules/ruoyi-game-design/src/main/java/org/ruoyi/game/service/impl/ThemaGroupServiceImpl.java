package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.ThemaGroup;
import org.ruoyi.game.domain.vo.ThemaGroupVo;
import org.ruoyi.game.mapper.ThemaGroupMapper;
import org.ruoyi.game.service.IThemaGroupService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 章节组 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class ThemaGroupServiceImpl implements IThemaGroupService {

    private final ThemaGroupMapper themaGroupMapper;

    @Override
    public ThemaGroupVo queryById(Integer id, String region) {
        LambdaQueryWrapper<ThemaGroup> lqw = Wrappers.lambdaQuery();
        lqw.eq(ThemaGroup::getId, id)
           .eq(StringUtils.isNotBlank(region), ThemaGroup::getRegion, region);
        return themaGroupMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<ThemaGroupVo> queryPageList(ThemaGroup themaGroup, PageQuery pageQuery) {
        LambdaQueryWrapper<ThemaGroup> lqw = buildQueryWrapper(themaGroup);
        Page<ThemaGroupVo> result = themaGroupMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<ThemaGroupVo> queryList(ThemaGroup themaGroup) {
        LambdaQueryWrapper<ThemaGroup> lqw = buildQueryWrapper(themaGroup);
        return themaGroupMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<ThemaGroup> buildQueryWrapper(ThemaGroup themaGroup) {
        LambdaQueryWrapper<ThemaGroup> lqw = Wrappers.lambdaQuery();
        lqw.eq(themaGroup.getId() != null, ThemaGroup::getId, themaGroup.getId());
        lqw.like(StringUtils.isNotBlank(themaGroup.getNote()), ThemaGroup::getNote, themaGroup.getNote());
        lqw.eq(StringUtils.isNotBlank(themaGroup.getRegion()), ThemaGroup::getRegion, themaGroup.getRegion());
        lqw.eq(themaGroup.getStageType() != null, ThemaGroup::getStageType, themaGroup.getStageType());
        lqw.orderByAsc(ThemaGroup::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(ThemaGroup themaGroup) {
        return themaGroupMapper.insert(themaGroup) > 0;
    }

    @Override
    public Boolean updateByBo(ThemaGroup themaGroup) {
        LambdaQueryWrapper<ThemaGroup> lqw = Wrappers.lambdaQuery();
        lqw.eq(ThemaGroup::getId, themaGroup.getId())
           .eq(ThemaGroup::getRegion, themaGroup.getRegion());
        return themaGroupMapper.update(themaGroup, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<ThemaGroup> lqw = Wrappers.lambdaQuery();
        lqw.in(ThemaGroup::getId, ids)
           .eq(StringUtils.isNotBlank(region), ThemaGroup::getRegion, region);
        return themaGroupMapper.delete(lqw) > 0;
    }
}
