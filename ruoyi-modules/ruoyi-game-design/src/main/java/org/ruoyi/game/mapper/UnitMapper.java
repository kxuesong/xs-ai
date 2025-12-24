package org.ruoyi.game.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.ruoyi.core.mapper.BaseMapperPlus;
import org.ruoyi.game.domain.Unit;
import org.ruoyi.game.domain.vo.UnitVo;

/**
 * 单位 Mapper 接口
 *
 * @author ruoyi
 */
@Mapper
@DS("game")
public interface UnitMapper extends BaseMapperPlus<Unit, UnitVo> {

}
