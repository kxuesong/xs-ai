package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.StageAttribute;
import org.ruoyi.game.domain.vo.StageAttributeVo;

import java.util.Collection;
import java.util.List;

/**
 * 关卡属性 Service 接口
 *
 * @author ruoyi
 */
public interface IStageAttributeService {

    /**
     * 查询关卡属性
     */
    StageAttributeVo queryById(Integer id, String region);

    /**
     * 查询关卡属性列表（分页）
     */
    TableDataInfo<StageAttributeVo> queryPageList(StageAttribute stageAttribute, PageQuery pageQuery);

    /**
     * 查询关卡属性列表
     */
    List<StageAttributeVo> queryList(StageAttribute stageAttribute);

    /**
     * 按关卡组ID查询属性
     */
    List<StageAttributeVo> queryByStageGroupId(Integer stageGroupId, String region);

    /**
     * 新增关卡属性
     */
    Boolean insertByBo(StageAttribute stageAttribute);

    /**
     * 修改关卡属性
     */
    Boolean updateByBo(StageAttribute stageAttribute);

    /**
     * 批量删除关卡属性
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
