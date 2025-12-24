package org.ruoyi.game.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.ruoyi.core.mapper.BaseMapperPlus;
import org.ruoyi.game.domain.UnitVisual;
import org.ruoyi.game.domain.vo.UnitVisualVo;

/**
 * 单位视觉资源Mapper接口
 *
 * @author ruoyi
 */
@Mapper
@DS("game")
public interface UnitVisualMapper extends BaseMapperPlus<UnitVisual, UnitVisualVo> {
}
