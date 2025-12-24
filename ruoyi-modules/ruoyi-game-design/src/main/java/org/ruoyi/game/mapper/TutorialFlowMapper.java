package org.ruoyi.game.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.ruoyi.core.mapper.BaseMapperPlus;
import org.ruoyi.game.domain.TutorialFlow;
import org.ruoyi.game.domain.vo.TutorialFlowVo;

/**
 * 教程流程 Mapper 接口
 *
 * @author ruoyi
 */
@Mapper
@DS("game")
public interface TutorialFlowMapper extends BaseMapperPlus<TutorialFlow, TutorialFlowVo> {

}
