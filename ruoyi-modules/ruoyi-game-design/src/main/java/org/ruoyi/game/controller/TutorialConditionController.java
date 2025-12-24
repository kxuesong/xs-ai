package org.ruoyi.game.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.domain.R;
import org.ruoyi.common.excel.utils.ExcelUtil;
import org.ruoyi.common.log.annotation.Log;
import org.ruoyi.common.log.enums.BusinessType;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.common.web.core.BaseController;
import org.ruoyi.game.domain.TutorialCondition;
import org.ruoyi.game.domain.vo.TutorialConditionVo;
import org.ruoyi.game.service.ITutorialConditionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 教程条件管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/tutorial/condition")
public class TutorialConditionController extends BaseController {

    private final ITutorialConditionService tutorialConditionService;

    /**
     * 查询教程条件列表
     */
    @SaCheckPermission("game:tutorial:list")
    @GetMapping("/list")
    public TableDataInfo<TutorialConditionVo> list(TutorialCondition tutorialCondition, PageQuery pageQuery) {
        return tutorialConditionService.queryPageList(tutorialCondition, pageQuery);
    }

    /**
     * 导出教程条件列表
     */
    @SaCheckPermission("game:tutorial:export")
    @Log(title = "教程条件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(TutorialCondition tutorialCondition, HttpServletResponse response) {
        List<TutorialConditionVo> list = tutorialConditionService.queryList(tutorialCondition);
        ExcelUtil.exportExcel(list, "教程条件", TutorialConditionVo.class, response);
    }

    /**
     * 获取教程条件详细信息
     */
    @SaCheckPermission("game:tutorial:query")
    @GetMapping("/{id}")
    public R<TutorialConditionVo> getInfo(@NotNull(message = "条件ID不能为空") @PathVariable Integer id,
                                          @RequestParam(required = false) String region) {
        return R.ok(tutorialConditionService.queryById(id, region));
    }

    /**
     * 新增教程条件
     */
    @SaCheckPermission("game:tutorial:add")
    @Log(title = "教程条件", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody TutorialCondition tutorialCondition) {
        return toAjax(tutorialConditionService.insertByBo(tutorialCondition));
    }

    /**
     * 修改教程条件
     */
    @SaCheckPermission("game:tutorial:edit")
    @Log(title = "教程条件", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody TutorialCondition tutorialCondition) {
        return toAjax(tutorialConditionService.updateByBo(tutorialCondition));
    }

    /**
     * 删除教程条件
     */
    @SaCheckPermission("game:tutorial:remove")
    @Log(title = "教程条件", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "条件ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(tutorialConditionService.deleteByIds(Arrays.asList(ids), region));
    }
}
