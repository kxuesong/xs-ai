package org.ruoyi.game.mapper;

import org.ruoyi.core.mapper.BaseMapperPlus;
import org.ruoyi.game.domain.ThemaGroup;
import org.ruoyi.game.domain.vo.ThemaGroupVo;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * 章节组 Mapper
 *
 * @author ruoyi
 */
@Mapper
@DS("game")
public interface ThemaGroupMapper extends BaseMapperPlus<ThemaGroup, ThemaGroupVo> {

}
