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
import org.ruoyi.game.domain.TutorialEvent;
import org.ruoyi.game.domain.vo.TutorialEventVo;
import org.ruoyi.game.service.ITutorialEventService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 教程事件管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/tutorial/event")
public class TutorialEventController extends BaseController {

    private final ITutorialEventService tutorialEventService;

    /**
     * 查询教程事件列表
     */
    @SaCheckPermission("game:tutorial:list")
    @GetMapping("/list")
    public TableDataInfo<TutorialEventVo> list(TutorialEvent tutorialEvent, PageQuery pageQuery) {
        return tutorialEventService.queryPageList(tutorialEvent, pageQuery);
    }

    /**
     * 导出教程事件列表
     */
    @SaCheckPermission("game:tutorial:export")
    @Log(title = "教程事件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(TutorialEvent tutorialEvent, HttpServletResponse response) {
        List<TutorialEventVo> list = tutorialEventService.queryList(tutorialEvent);
        ExcelUtil.exportExcel(list, "教程事件", TutorialEventVo.class, response);
    }

    /**
     * 获取教程事件详细信息
     */
    @SaCheckPermission("game:tutorial:query")
    @GetMapping("/{id}")
    public R<TutorialEventVo> getInfo(@NotNull(message = "事件ID不能为空") @PathVariable Integer id) {
        return R.ok(tutorialEventService.queryById(id));
    }

    /**
     * 新增教程事件
     */
    @SaCheckPermission("game:tutorial:add")
    @Log(title = "教程事件", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody TutorialEvent tutorialEvent) {
        return toAjax(tutorialEventService.insertByBo(tutorialEvent));
    }

    /**
     * 修改教程事件
     */
    @SaCheckPermission("game:tutorial:edit")
    @Log(title = "教程事件", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody TutorialEvent tutorialEvent) {
        return toAjax(tutorialEventService.updateByBo(tutorialEvent));
    }

    /**
     * 删除教程事件
     */
    @SaCheckPermission("game:tutorial:remove")
    @Log(title = "教程事件", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "事件ID不能为空") @PathVariable Integer[] ids) {
        return toAjax(tutorialEventService.deleteByIds(Arrays.asList(ids)));
    }
}
