package org.ruoyi.game.domain.vo;


import io.github.linpeilie.annotations.AutoMapper;
import org.ruoyi.game.domain.TutorialTitle;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 教程标题视图对象
 *
 * @author ruoyi
 */
@Data
@AutoMapper(target = TutorialTitle.class)
public class TutorialTitleVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 标题ID
     */
    @ExcelProperty(value = "标题ID")
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
     * 获取标题字符串
     */
    @ExcelProperty(value = "标题字符串")
    private String titleGetString;

    /**
     * 单位标题ID
     */
    @ExcelProperty(value = "单位标题ID")
    private Integer unitTitleId;
}
