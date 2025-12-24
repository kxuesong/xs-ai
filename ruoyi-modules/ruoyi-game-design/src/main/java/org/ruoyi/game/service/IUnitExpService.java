package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.UnitExp;
import org.ruoyi.game.domain.vo.UnitExpVo;

import java.util.Collection;
import java.util.List;

/**
 * 单位经验表 Service 接口
 *
 * @author ruoyi
 */
public interface IUnitExpService {

    /**
     * 查询单位经验配置
     *
     * @param id 经验配置ID
     * @param region 区域标识
     * @return 单位经验配置
     */
    UnitExpVo queryById(Integer id, String region);

    /**
     * 查询单位经验配置列表（分页）
     *
     * @param unitExp 查询条件
     * @param pageQuery 分页参数
     * @return 单位经验配置集合
     */
    TableDataInfo<UnitExpVo> queryPageList(UnitExp unitExp, PageQuery pageQuery);

    /**
     * 查询单位经验配置列表（不分页）
     *
     * @param unitExp 查询条件
     * @return 单位经验配置集合
     */
    List<UnitExpVo> queryList(UnitExp unitExp);

    /**
     * 新增单位经验配置
     *
     * @param unitExp 单位经验配置
     * @return 结果
     */
    Boolean insertByBo(UnitExp unitExp);

    /**
     * 修改单位经验配置
     *
     * @param unitExp 单位经验配置
     * @return 结果
     */
    Boolean updateByBo(UnitExp unitExp);

    /**
     * 批量删除单位经验配置
     *
     * @param ids 经验配置ID集合
     * @param region 区域标识
     * @return 结果
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
