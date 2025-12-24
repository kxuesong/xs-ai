package org.ruoyi.game.service;

import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.game.domain.Game;
import org.ruoyi.game.domain.vo.GameVo;

import java.util.Collection;
import java.util.List;

/**
 * 游戏设计信息 Service 接口
 *
 * @author ruoyi
 */
public interface IGameService {

    /**
     * 查询游戏设计信息
     */
    GameVo queryById(Long gameId);

    /**
     * 查询游戏设计信息列表
     */
    TableDataInfo<GameVo> queryPageList(Game game, PageQuery pageQuery);

    /**
     * 查询游戏设计信息列表
     */
    List<GameVo> queryList(Game game);

    /**
     * 新增游戏设计信息
     */
    Boolean insertByBo(Game game);

    /**
     * 修改游戏设计信息
     */
    Boolean updateByBo(Game game);

    /**
     * 批量删除游戏设计信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids);
}
