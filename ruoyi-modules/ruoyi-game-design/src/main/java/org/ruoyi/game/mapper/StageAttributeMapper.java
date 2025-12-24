package org.ruoyi.game.mapper;

import org.ruoyi.core.mapper.BaseMapperPlus;
import org.ruoyi.game.domain.StageAttribute;
import org.ruoyi.game.domain.vo.StageAttributeVo;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * 关卡属性 Mapper
 *
 * @author ruoyi
 */
@Mapper
@DS("game")
public interface StageAttributeMapper extends BaseMapperPlus<StageAttribute, StageAttributeVo> {

}
