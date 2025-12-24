package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.ThemaGroup;
import org.ruoyi.game.domain.vo.ThemaGroupVo;

import java.util.Collection;
import java.util.List;

/**
 * 章节组 Service 接口
 *
 * @author ruoyi
 */
public interface IThemaGroupService {

    /**
     * 查询章节组
     */
    ThemaGroupVo queryById(Integer id, String region);

    /**
     * 查询章节组列表（分页）
     */
    TableDataInfo<ThemaGroupVo> queryPageList(ThemaGroup themaGroup, PageQuery pageQuery);

    /**
     * 查询章节组列表
     */
    List<ThemaGroupVo> queryList(ThemaGroup themaGroup);

    /**
     * 新增章节组
     */
    Boolean insertByBo(ThemaGroup themaGroup);

    /**
     * 修改章节组
     */
    Boolean updateByBo(ThemaGroup themaGroup);

    /**
     * 批量删除章节组
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
