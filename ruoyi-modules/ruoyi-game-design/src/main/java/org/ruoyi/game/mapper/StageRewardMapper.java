package org.ruoyi.game.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.ruoyi.game.domain.StageReward;
import org.ruoyi.game.domain.vo.StageRewardVo;
import org.ruoyi.core.mapper.BaseMapperPlus;

/**
 * 关卡奖励 Mapper
 *
 * @author ruoyi
 */
@Mapper
@DS("game")
public interface StageRewardMapper extends BaseMapperPlus<StageReward, StageRewardVo> {

}
