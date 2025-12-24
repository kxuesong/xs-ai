package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.StageScene;
import org.ruoyi.game.domain.vo.StageSceneVo;

import java.util.Collection;
import java.util.List;

/**
 * 关卡场景 Service 接口
 *
 * @author ruoyi
 */
public interface IStageSceneService {

    /**
     * 查询关卡场景
     */
    StageSceneVo queryById(Integer id, String region);

    /**
     * 查询关卡场景列表（分页）
     */
    TableDataInfo<StageSceneVo> queryPageList(StageScene stageScene, PageQuery pageQuery);

    /**
     * 查询关卡场景列表
     */
    List<StageSceneVo> queryList(StageScene stageScene);

    /**
     * 新增关卡场景
     */
    Boolean insertByBo(StageScene stageScene);

    /**
     * 修改关卡场景
     */
    Boolean updateByBo(StageScene stageScene);

    /**
     * 批量删除关卡场景
     */
    Boolean deleteByIds(Collection<Integer> ids, String region);
}
