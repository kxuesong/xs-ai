package org.ruoyi.game.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ruoyi.game.domain.StageScene;
import org.ruoyi.game.domain.vo.StageSceneVo;
import org.ruoyi.core.mapper.BaseMapperPlus;

/**
 * 关卡场景 Mapper
 *
 * @author ruoyi
 */
@Mapper
@DS("game")
public interface StageSceneMapper extends BaseMapperPlus<StageScene, StageSceneVo> {

}
