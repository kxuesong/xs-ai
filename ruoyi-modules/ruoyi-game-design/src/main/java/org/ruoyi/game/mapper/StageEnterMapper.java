package org.ruoyi.game.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ruoyi.game.domain.StageEnter;
import org.ruoyi.game.domain.vo.StageEnterVo;
import org.ruoyi.core.mapper.BaseMapperPlus;

/**
 * 关卡入口 Mapper
 *
 * @author ruoyi
 */
@Mapper
@DS("game")
public interface StageEnterMapper extends BaseMapperPlus<StageEnter, StageEnterVo> {

}
