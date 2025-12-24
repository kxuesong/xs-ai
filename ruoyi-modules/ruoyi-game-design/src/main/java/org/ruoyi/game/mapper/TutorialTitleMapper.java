package org.ruoyi.game.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.ruoyi.core.mapper.BaseMapperPlus;
import org.ruoyi.game.domain.TutorialTitle;
import org.ruoyi.game.domain.vo.TutorialTitleVo;

/**
 * 教程标题 Mapper 接口
 *
 * @author ruoyi
 */
@Mapper
@DS("game")
public interface TutorialTitleMapper extends BaseMapperPlus<TutorialTitle, TutorialTitleVo> {

}
