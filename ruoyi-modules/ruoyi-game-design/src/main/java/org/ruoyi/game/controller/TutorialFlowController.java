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
import org.ruoyi.game.domain.TutorialFlow;
import org.ruoyi.game.domain.vo.TutorialFlowVo;
import org.ruoyi.game.service.ITutorialFlowService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 教程流程管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/tutorial/flow")
public class TutorialFlowController extends BaseController {

    private final ITutorialFlowService tutorialFlowService;

    /**
     * 查询教程流程列表
     */
    @SaCheckPermission("game:tutorial:list")
    @GetMapping("/list")
    public TableDataInfo<TutorialFlowVo> list(TutorialFlow tutorialFlow, PageQuery pageQuery) {
        return tutorialFlowService.queryPageList(tutorialFlow, pageQuery);
    }

    /**
     * 导出教程流程列表
     */
    @SaCheckPermission("game:tutorial:export")
    @Log(title = "教程流程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(TutorialFlow tutorialFlow, HttpServletResponse response) {
        List<TutorialFlowVo> list = tutorialFlowService.queryList(tutorialFlow);
        ExcelUtil.exportExcel(list, "教程流程", TutorialFlowVo.class, response);
    }

    /**
     * 获取教程流程详细信息
     */
    @SaCheckPermission("game:tutorial:query")
    @GetMapping("/{id}")
    public R<TutorialFlowVo> getInfo(@NotNull(message = "教程ID不能为空") @PathVariable Integer id,
                                      @RequestParam(required = false) String region) {
        return R.ok(tutorialFlowService.queryById(id, region));
    }

    /**
     * 新增教程流程
     */
    @SaCheckPermission("game:tutorial:add")
    @Log(title = "教程流程", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody TutorialFlow tutorialFlow) {
        return toAjax(tutorialFlowService.insertByBo(tutorialFlow));
    }

    /**
     * 修改教程流程
     */
    @SaCheckPermission("game:tutorial:edit")
    @Log(title = "教程流程", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody TutorialFlow tutorialFlow) {
        return toAjax(tutorialFlowService.updateByBo(tutorialFlow));
    }

    /**
     * 删除教程流程
     */
    @SaCheckPermission("game:tutorial:remove")
    @Log(title = "教程流程", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "教程ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(tutorialFlowService.deleteByIds(Arrays.asList(ids), region));
    }
}
