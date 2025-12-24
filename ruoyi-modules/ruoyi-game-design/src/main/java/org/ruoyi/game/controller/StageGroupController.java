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
import org.ruoyi.game.domain.StageGroup;
import org.ruoyi.game.domain.vo.StageGroupVo;
import org.ruoyi.game.service.IStageGroupService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 关卡组管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/stage/group")
public class StageGroupController extends BaseController {

    private final IStageGroupService stageGroupService;

    /**
     * 查询关卡组列表
     */
    @SaCheckPermission("game:stage:list")
    @GetMapping("/list")
    public TableDataInfo<StageGroupVo> list(StageGroup stageGroup, PageQuery pageQuery) {
        return stageGroupService.queryPageList(stageGroup, pageQuery);
    }

    /**
     * 导出关卡组列表
     */
    @SaCheckPermission("game:stage:export")
    @Log(title = "关卡组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(StageGroup stageGroup, HttpServletResponse response) {
        List<StageGroupVo> list = stageGroupService.queryList(stageGroup);
        ExcelUtil.exportExcel(list, "关卡组", StageGroupVo.class, response);
    }

    /**
     * 获取关卡组详细信息
     */
    @SaCheckPermission("game:stage:query")
    @GetMapping("/{id}")
    public R<StageGroupVo> getInfo(@NotNull(message = "关卡组ID不能为空") @PathVariable Integer id,
                                   @RequestParam(required = false) String region) {
        return R.ok(stageGroupService.queryById(id, region));
    }

    /**
     * 按主题ID查询关卡组
     */
    @SaCheckPermission("game:stage:list")
    @GetMapping("/by-thema/{themaId}")
    public R<List<StageGroupVo>> getByThemaId(@NotNull(message = "主题ID不能为空") @PathVariable Integer themaId,
                                              @RequestParam(required = false) String region) {
        return R.ok(stageGroupService.queryByThemaId(themaId, region));
    }

    /**
     * 新增关卡组
     */
    @SaCheckPermission("game:stage:add")
    @Log(title = "关卡组", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody StageGroup stageGroup) {
        return toAjax(stageGroupService.insertByBo(stageGroup));
    }

    /**
     * 修改关卡组
     */
    @SaCheckPermission("game:stage:edit")
    @Log(title = "关卡组", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody StageGroup stageGroup) {
        return toAjax(stageGroupService.updateByBo(stageGroup));
    }

    /**
     * 删除关卡组
     */
    @SaCheckPermission("game:stage:remove")
    @Log(title = "关卡组", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "关卡组ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(stageGroupService.deleteByIds(Arrays.asList(ids), region));
    }
}
