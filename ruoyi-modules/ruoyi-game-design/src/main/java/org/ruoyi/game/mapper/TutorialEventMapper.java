package org.ruoyi.game.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.ruoyi.core.mapper.BaseMapperPlus;
import org.ruoyi.game.domain.TutorialEvent;
import org.ruoyi.game.domain.vo.TutorialEventVo;

/**
 * 教程事件 Mapper 接口
 *
 * @author ruoyi
 */
@Mapper
@DS("game")
public interface TutorialEventMapper extends BaseMapperPlus<TutorialEvent, TutorialEventVo> {

}
