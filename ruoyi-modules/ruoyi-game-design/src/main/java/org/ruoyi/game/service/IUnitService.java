package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.Unit;
import org.ruoyi.game.domain.vo.UnitVo;

import java.util.Collection;
import java.util.List;

/**
 * 单位 Service 接口
 *
 * @author ruoyi
 */
public interface IUnitService {

    /**
     * 查询单位
     */
    UnitVo queryById(Integer id, String region);

    /**
     * 查询单位列表（分页）
     */
    TableDataInfo<UnitVo> queryPageList(Unit unit, PageQuery pageQuery);

    /**
     * 查询单位列表
     */
    List<UnitVo> queryList(Unit unit);

    /**
     * 新增单位
     */
    Boolean insertByBo(Unit unit);

    /**
     * 修改单位
     */
    Boolean updateByBo(Unit unit);

    /**
     * 批量删除单位
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
