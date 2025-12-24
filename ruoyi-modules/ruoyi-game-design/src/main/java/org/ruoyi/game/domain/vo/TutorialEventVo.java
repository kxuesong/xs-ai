package org.ruoyi.game.domain.vo;


import io.github.linpeilie.annotations.AutoMapper;
import org.ruoyi.game.domain.TutorialEvent;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 教程事件视图对象
 *
 * @author ruoyi
 */
@Data
@AutoMapper(target = TutorialEvent.class)
public class TutorialEventVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 事件ID
     */
    @ExcelProperty(value = "事件ID")
    private Integer id;

    /**
     * 备注说明
     */
    @ExcelProperty(value = "备注说明")
    private String note;

    /**
     * 区域
     */
    @ExcelProperty(value = "区域")
    private String region;

    /**
     * 教程任务ID
     */
    @ExcelProperty(value = "任务ID")
    private Integer tutorialTask;

    /**
     * 教程任务数量
     */
    @ExcelProperty(value = "任务数量")
    private Integer tutorialTaskCount;

    /**
     * 教程任务字符串ID
     */
    @ExcelProperty(value = "任务字符串")
    private Integer tutorialTaskString;

    /**
     * 教程弹窗字符串ID
     */
    @ExcelProperty(value = "弹窗字符串")
    private Integer tutorialPopupString;

    /**
     * 教程弹窗数量
     */
    @ExcelProperty(value = "弹窗数量")
    private Integer tutorialPopupCount;
}
