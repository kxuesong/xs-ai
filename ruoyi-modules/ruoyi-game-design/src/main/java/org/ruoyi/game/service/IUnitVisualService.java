package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.UnitVisual;
import org.ruoyi.game.domain.vo.UnitVisualVo;

import java.util.Collection;
import java.util.List;

/**
 * 单位视觉资源Service接口
 *
 * @author ruoyi
 */
public interface IUnitVisualService {

    /**
     * 查询单位视觉资源
     */
    UnitVisualVo queryById(Integer id, String region);

    /**
     * 查询单位视觉资源列表（分页）
     */
    TableDataInfo<UnitVisualVo> queryPageList(UnitVisual unitVisual, PageQuery pageQuery);

    /**
     * 查询单位视觉资源列表
     */
    List<UnitVisualVo> queryList(UnitVisual unitVisual);

    /**
     * 新增单位视觉资源
     */
    Boolean insertByBo(UnitVisual unitVisual);

    /**
     * 修改单位视觉资源
     */
    Boolean updateByBo(UnitVisual unitVisual);

    /**
     * 删除单位视觉资源
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
