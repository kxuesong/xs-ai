package org.ruoyi.game.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.utils.MapstructUtils;
import org.ruoyi.common.core.utils.StringUtils;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.Game;
import org.ruoyi.game.domain.vo.GameVo;
import org.ruoyi.game.mapper.GameMapper;
import org.ruoyi.game.service.IGameService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 游戏设计信息 Service 实现
 *
 * @author ruoyi
 */
@RequiredArgsConstructor
@Service
@DS("game")  // 整个 Service 都使用 game 数据源
public class GameServiceImpl implements IGameService {

    private final GameMapper gameMapper;

    /**
     * 查询游戏设计信息
     */
    @Override
    public GameVo queryById(Long gameId) {
        return gameMapper.selectVoById(gameId);
    }

    /**
     * 查询游戏设计信息列表（分页）
     */
    @Override
    public TableDataInfo<GameVo> queryPageList(Game game, PageQuery pageQuery) {
        LambdaQueryWrapper<Game> lqw = buildQueryWrapper(game);
        Page<GameVo> result = gameMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询游戏设计信息列表
     */
    @Override
    public List<GameVo> queryList(Game game) {
        LambdaQueryWrapper<Game> lqw = buildQueryWrapper(game);
        return gameMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<Game> buildQueryWrapper(Game game) {
        LambdaQueryWrapper<Game> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(game.getGameName()), Game::getGameName, game.getGameName());
        lqw.eq(StringUtils.isNotBlank(game.getGameType()), Game::getGameType, game.getGameType());
        lqw.eq(StringUtils.isNotBlank(game.getStatus()), Game::getStatus, game.getStatus());
        return lqw;
    }

    /**
     * 新增游戏设计信息
     */
    @Override
    public Boolean insertByBo(Game game) {
        return gameMapper.insert(game) > 0;
    }

    /**
     * 修改游戏设计信息
     */
    @Override
    public Boolean updateByBo(Game game) {
        return gameMapper.updateById(game) > 0;
    }

    /**
     * 批量删除游戏设计信息
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids) {
        return gameMapper.deleteByIds(ids) > 0;
    }
}
