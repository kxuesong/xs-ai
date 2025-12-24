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
import org.ruoyi.game.domain.TutorialTitle;
import org.ruoyi.game.domain.vo.TutorialTitleVo;
import org.ruoyi.game.service.ITutorialTitleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 教程标题管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/tutorial/title")
public class TutorialTitleController extends BaseController {

    private final ITutorialTitleService tutorialTitleService;

    /**
     * 查询教程标题列表
     */
    @SaCheckPermission("game:tutorial:list")
    @GetMapping("/list")
    public TableDataInfo<TutorialTitleVo> list(TutorialTitle tutorialTitle, PageQuery pageQuery) {
        return tutorialTitleService.queryPageList(tutorialTitle, pageQuery);
    }

    /**
     * 导出教程标题列表
     */
    @SaCheckPermission("game:tutorial:export")
    @Log(title = "教程标题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(TutorialTitle tutorialTitle, HttpServletResponse response) {
        List<TutorialTitleVo> list = tutorialTitleService.queryList(tutorialTitle);
        ExcelUtil.exportExcel(list, "教程标题", TutorialTitleVo.class, response);
    }

    /**
     * 获取教程标题详细信息
     */
    @SaCheckPermission("game:tutorial:query")
    @GetMapping("/{id}")
    public R<TutorialTitleVo> getInfo(@NotNull(message = "标题ID不能为空") @PathVariable Integer id,
                                      @RequestParam(required = false) String region) {
        return R.ok(tutorialTitleService.queryById(id, region));
    }

    /**
     * 新增教程标题
     */
    @SaCheckPermission("game:tutorial:add")
    @Log(title = "教程标题", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody TutorialTitle tutorialTitle) {
        return toAjax(tutorialTitleService.insertByBo(tutorialTitle));
    }

    /**
     * 修改教程标题
     */
    @SaCheckPermission("game:tutorial:edit")
    @Log(title = "教程标题", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody TutorialTitle tutorialTitle) {
        return toAjax(tutorialTitleService.updateByBo(tutorialTitle));
    }

    /**
     * 删除教程标题
     */
    @SaCheckPermission("game:tutorial:remove")
    @Log(title = "教程标题", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "标题ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(tutorialTitleService.deleteByIds(Arrays.asList(ids), region));
    }
}
