package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.UnitUltimateUp;
import org.ruoyi.game.domain.vo.UnitUltimateUpVo;

import java.util.Collection;
import java.util.List;

/**
 * 单位觉醒升级Service接口
 *
 * @author ruoyi
 */
public interface IUnitUltimateUpService {

    /**
     * 查询单位觉醒升级
     */
    UnitUltimateUpVo queryById(Integer id, String region);

    /**
     * 查询单位觉醒升级列表（分页）
     */
    TableDataInfo<UnitUltimateUpVo> queryPageList(UnitUltimateUp unitUltimateUp, PageQuery pageQuery);

    /**
     * 查询单位觉醒升级列表
     */
    List<UnitUltimateUpVo> queryList(UnitUltimateUp unitUltimateUp);

    /**
     * 新增单位觉醒升级
     */
    Boolean insertByBo(UnitUltimateUp unitUltimateUp);

    /**
     * 修改单位觉醒升级
     */
    Boolean updateByBo(UnitUltimateUp unitUltimateUp);

    /**
     * 删除单位觉醒升级
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
