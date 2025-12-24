package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.StageScene;
import org.ruoyi.game.domain.vo.StageSceneVo;
import org.ruoyi.game.mapper.StageSceneMapper;
import org.ruoyi.game.service.IStageSceneService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 关卡场景 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")
public class StageSceneServiceImpl implements IStageSceneService {

    private final StageSceneMapper stageSceneMapper;

    @Override
    public StageSceneVo queryById(Integer id, String region) {
        LambdaQueryWrapper<StageScene> lqw = Wrappers.lambdaQuery();
        lqw.eq(StageScene::getId, id)
           .eq(StringUtils.isNotBlank(region), StageScene::getRegion, region);
        return stageSceneMapper.selectVoOne(lqw);
    }

    @Override
    public TableDataInfo<StageSceneVo> queryPageList(StageScene stageScene, PageQuery pageQuery) {
        LambdaQueryWrapper<StageScene> lqw = buildQueryWrapper(stageScene);
        Page<StageSceneVo> result = stageSceneMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<StageSceneVo> queryList(StageScene stageScene) {
        LambdaQueryWrapper<StageScene> lqw = buildQueryWrapper(stageScene);
        return stageSceneMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<StageScene> buildQueryWrapper(StageScene stageScene) {
        LambdaQueryWrapper<StageScene> lqw = Wrappers.lambdaQuery();
        lqw.eq(stageScene.getId() != null, StageScene::getId, stageScene.getId());
        lqw.like(StringUtils.isNotBlank(stageScene.getNote()), StageScene::getNote, stageScene.getNote());
        lqw.eq(StringUtils.isNotBlank(stageScene.getRegion()), StageScene::getRegion, stageScene.getRegion());
        lqw.orderByAsc(StageScene::getId);
        return lqw;
    }

    @Override
    public Boolean insertByBo(StageScene stageScene) {
        return stageSceneMapper.insert(stageScene) > 0;
    }

    @Override
    public Boolean updateByBo(StageScene stageScene) {
        LambdaQueryWrapper<StageScene> lqw = Wrappers.lambdaQuery();
        lqw.eq(StageScene::getId, stageScene.getId())
           .eq(StageScene::getRegion, stageScene.getRegion());
        return stageSceneMapper.update(stageScene, lqw) > 0;
    }

    @Override
    public Boolean deleteByIds(Collection<Integer> ids, String region) {
        LambdaQueryWrapper<StageScene> lqw = Wrappers.lambdaQuery();
        lqw.in(StageScene::getId, ids)
           .eq(StringUtils.isNotBlank(region), StageScene::getRegion, region);
        return stageSceneMapper.delete(lqw) > 0;
    }
}
