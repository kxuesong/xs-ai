package org.ruoyi.game.domain.vo;

import io.github.linpeilie.annotations.AutoMapper;
import org.ruoyi.game.domain.Game;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.ruoyi.common.excel.annotation.ExcelDictFormat;
import org.ruoyi.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 游戏设计信息视图对象
 *
 * @author ruoyi
 */
@Data
@AutoMapper(target = Game.class)
public class GameVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 游戏ID
     */
    @ExcelProperty(value = "游戏ID")
    private Long gameId;

    /**
     * 游戏名称
     */
    @ExcelProperty(value = "游戏名称")
    private String gameName;

    /**
     * 游戏类型
     */
    @ExcelProperty(value = "游戏类型")
    private String gameType;

    /**
     * 游戏描述
     */
    @ExcelProperty(value = "游戏描述")
    private String description;

    /**
     * 游戏状态
     */
    @ExcelProperty(value = "状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_normal_disable")
    private String status;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
