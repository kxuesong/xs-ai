package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.UnitBook;
import org.ruoyi.game.domain.vo.UnitBookVo;

import java.util.Collection;
import java.util.List;

/**
 * 单位图鉴 Service 接口
 *
 * @author ruoyi
 */
public interface IUnitBookService {

    /**
     * 查询单位图鉴
     *
     * @param id 图鉴ID
     * @param region 区域标识
     * @return 单位图鉴
     */
    UnitBookVo queryById(Integer id, String region);

    /**
     * 查询单位图鉴列表（分页）
     *
     * @param unitBook 查询条件
     * @param pageQuery 分页参数
     * @return 单位图鉴集合
     */
    TableDataInfo<UnitBookVo> queryPageList(UnitBook unitBook, PageQuery pageQuery);

    /**
     * 查询单位图鉴列表（不分页）
     *
     * @param unitBook 查询条件
     * @return 单位图鉴集合
     */
    List<UnitBookVo> queryList(UnitBook unitBook);

    /**
     * 新增单位图鉴
     *
     * @param unitBook 单位图鉴
     * @return 结果
     */
    Boolean insertByBo(UnitBook unitBook);

    /**
     * 修改单位图鉴
     *
     * @param unitBook 单位图鉴
     * @return 结果
     */
    Boolean updateByBo(UnitBook unitBook);

    /**
     * 批量删除单位图鉴
     *
     * @param ids 图鉴ID集合
     * @param region 区域标识
     * @return 结果
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
