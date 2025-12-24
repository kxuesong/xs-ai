package org.ruoyi.game.mapper;

import org.ruoyi.core.mapper.BaseMapperPlus;
import org.ruoyi.game.domain.StageGroup;
import org.ruoyi.game.domain.vo.StageGroupVo;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * 关卡组 Mapper
 *
 * @author ruoyi
 */
@Mapper
@DS("game")
public interface StageGroupMapper extends BaseMapperPlus<StageGroup, StageGroupVo> {

}
