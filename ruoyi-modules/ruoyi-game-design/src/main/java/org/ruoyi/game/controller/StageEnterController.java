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
import org.ruoyi.game.domain.StageEnter;
import org.ruoyi.game.domain.vo.StageEnterVo;
import org.ruoyi.game.service.IStageEnterService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 关卡入口管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/stage/enter")
public class StageEnterController extends BaseController {

    private final IStageEnterService stageEnterService;

    /**
     * 查询关卡入口列表
     */
    @SaCheckPermission("game:stage:list")
    @GetMapping("/list")
    public TableDataInfo<StageEnterVo> list(StageEnter stageEnter, PageQuery pageQuery) {
        return stageEnterService.queryPageList(stageEnter, pageQuery);
    }

    /**
     * 导出关卡入口列表
     */
    @SaCheckPermission("game:stage:export")
    @Log(title = "关卡入口", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(StageEnter stageEnter, HttpServletResponse response) {
        List<StageEnterVo> list = stageEnterService.queryList(stageEnter);
        ExcelUtil.exportExcel(list, "关卡入口", StageEnterVo.class, response);
    }

    /**
     * 获取关卡入口详细信息
     */
    @SaCheckPermission("game:stage:query")
    @GetMapping("/{id}")
    public R<StageEnterVo> getInfo(@NotNull(message = "入口ID不能为空") @PathVariable Integer id,
                                   @RequestParam(required = false) String region) {
        return R.ok(stageEnterService.queryById(id, region));
    }

    /**
     * 按关卡组ID查询入口
     */
    @SaCheckPermission("game:stage:list")
    @GetMapping("/by-stage-group/{stageGroupId}")
    public R<List<StageEnterVo>> getByStageGroupId(@NotNull(message = "关卡组ID不能为空") @PathVariable Integer stageGroupId,
                                                   @RequestParam(required = false) String region) {
        return R.ok(stageEnterService.queryByStageGroupId(stageGroupId, region));
    }

    /**
     * 新增关卡入口
     */
    @SaCheckPermission("game:stage:add")
    @Log(title = "关卡入口", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody StageEnter stageEnter) {
        return toAjax(stageEnterService.insertByBo(stageEnter));
    }

    /**
     * 修改关卡入口
     */
    @SaCheckPermission("game:stage:edit")
    @Log(title = "关卡入口", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody StageEnter stageEnter) {
        return toAjax(stageEnterService.updateByBo(stageEnter));
    }

    /**
     * 删除关卡入口
     */
    @SaCheckPermission("game:stage:remove")
    @Log(title = "关卡入口", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "入口ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(stageEnterService.deleteByIds(Arrays.asList(ids), region));
    }
}
