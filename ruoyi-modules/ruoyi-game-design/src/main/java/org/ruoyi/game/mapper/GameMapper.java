package org.ruoyi.game.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.ruoyi.core.mapper.BaseMapperPlus;
import org.ruoyi.game.domain.Game;
import org.ruoyi.game.domain.vo.GameVo;

/**
 * 游戏设计信息 Mapper 接口
 *
 * @author ruoyi
 */
@Mapper
@DS("game")  // 指定使用 game 数据源
public interface GameMapper extends BaseMapperPlus<Game, GameVo> {

}
