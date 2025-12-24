package org.ruoyi.game.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.ruoyi.core.mapper.BaseMapperPlus;
import org.ruoyi.game.domain.TutorialCondition;
import org.ruoyi.game.domain.vo.TutorialConditionVo;

/**
 * 教程条件 Mapper 接口
 *
 * @author ruoyi
 */
@Mapper
@DS("game")
public interface TutorialConditionMapper extends BaseMapperPlus<TutorialCondition, TutorialConditionVo> {

}
