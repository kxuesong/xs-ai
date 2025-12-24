package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.UnitPosition;
import org.ruoyi.game.domain.vo.UnitPositionVo;

import java.util.Collection;
import java.util.List;

/**
 * 单位位置定义 Service 接口
 *
 * @author ruoyi
 */
public interface IUnitPositionService {

    /**
     * 查询单位位置定义
     *
     * @param id 位置ID
     * @param region 区域标识
     * @return 单位位置定义
     */
    UnitPositionVo queryById(Integer id, String region);

    /**
     * 查询单位位置定义列表（分页）
     *
     * @param unitPosition 查询条件
     * @param pageQuery 分页参数
     * @return 单位位置定义集合
     */
    TableDataInfo<UnitPositionVo> queryPageList(UnitPosition unitPosition, PageQuery pageQuery);

    /**
     * 查询单位位置定义列表（不分页）
     *
     * @param unitPosition 查询条件
     * @return 单位位置定义集合
     */
    List<UnitPositionVo> queryList(UnitPosition unitPosition);

    /**
     * 新增单位位置定义
     *
     * @param unitPosition 单位位置定义
     * @return 结果
     */
    Boolean insertByBo(UnitPosition unitPosition);

    /**
     * 修改单位位置定义
     *
     * @param unitPosition 单位位置定义
     * @return 结果
     */
    Boolean updateByBo(UnitPosition unitPosition);

    /**
     * 批量删除单位位置定义
     *
     * @param ids 位置ID集合
     * @param region 区域标识
     * @return 结果
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
