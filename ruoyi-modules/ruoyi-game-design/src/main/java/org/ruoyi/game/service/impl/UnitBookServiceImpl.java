package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.UnitBook;
import org.ruoyi.game.domain.vo.UnitBookVo;
import org.ruoyi.game.mapper.UnitBookMapper;
import org.ruoyi.game.service.IUnitBookService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 单位图鉴 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class UnitBookServiceImpl implements IUnitBookService {

    private final UnitBookMapper unitBookMapper;

    @Override
    public UnitBookVo queryById(Integer id, String region) {
        LambdaQueryWrapper<UnitBook> lqw = Wrappers.lambdaQuery();
        lqw.eq(UnitBook::getId, id)
           .eq(StringUtils.isNotBlank(region), UnitBook::getRegion, region);
        return unitBookMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<UnitBookVo> queryPageList(UnitBook unitBook, PageQuery pageQuery) {
        LambdaQueryWrapper<UnitBook> lqw = buildQueryWrapper(unitBook);
        Page<UnitBookVo> result = unitBookMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<UnitBookVo> queryList(UnitBook unitBook) {
        LambdaQueryWrapper<UnitBook> lqw = buildQueryWrapper(unitBook);
        return unitBookMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<UnitBook> buildQueryWrapper(UnitBook unitBook) {
        LambdaQueryWrapper<UnitBook> lqw = Wrappers.lambdaQuery();
        lqw.eq(unitBook.getId() != null, UnitBook::getId, unitBook.getId());
        lqw.like(StringUtils.isNotBlank(unitBook.getNote()), UnitBook::getNote, unitBook.getNote());
        lqw.eq(StringUtils.isNotBlank(unitBook.getRegion()), UnitBook::getRegion, unitBook.getRegion());
        lqw.eq(unitBook.getUnitHide() != null, UnitBook::getUnitHide, unitBook.getUnitHide());
        lqw.eq(unitBook.getCategoryId() != null, UnitBook::getCategoryId, unitBook.getCategoryId());
        lqw.eq(unitBook.getGroupId() != null, UnitBook::getGroupId, unitBook.getGroupId());
        lqw.eq(unitBook.getNumber() != null, UnitBook::getNumber, unitBook.getNumber());
        lqw.orderByAsc(UnitBook::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(UnitBook unitBook) {
        return unitBookMapper.insert(unitBook) > 0;
    }

    @Override
    public Boolean updateByBo(UnitBook unitBook) {
        LambdaQueryWrapper<UnitBook> lqw = Wrappers.lambdaQuery();
        lqw.eq(UnitBook::getId, unitBook.getId())
           .eq(UnitBook::getRegion, unitBook.getRegion());
        return unitBookMapper.update(unitBook, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<UnitBook> lqw = Wrappers.lambdaQuery();
        lqw.in(UnitBook::getId, ids)
           .eq(StringUtils.isNotBlank(region), UnitBook::getRegion, region);
        return unitBookMapper.delete(lqw) > 0;
    }
}
