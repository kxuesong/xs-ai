package org.ruoyi.game.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.ruoyi.core.mapper.BaseMapperPlus;
import org.ruoyi.game.domain.UnitUltimateUp;
import org.ruoyi.game.domain.vo.UnitUltimateUpVo;

/**
 * 单位觉醒升级Mapper接口
 *
 * @author ruoyi
 */
@Mapper
@DS("game")
public interface UnitUltimateUpMapper extends BaseMapperPlus<UnitUltimateUp, UnitUltimateUpVo> {
}
