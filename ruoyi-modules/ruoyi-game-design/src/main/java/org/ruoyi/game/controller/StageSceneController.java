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
import org.ruoyi.game.domain.StageScene;
import org.ruoyi.game.domain.vo.StageSceneVo;
import org.ruoyi.game.service.IStageSceneService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 关卡场景管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/stage/scene")
public class StageSceneController extends BaseController {

    private final IStageSceneService stageSceneService;

    /**
     * 查询关卡场景列表
     */
    @SaCheckPermission("game:stage:list")
    @GetMapping("/list")
    public TableDataInfo<StageSceneVo> list(StageScene stageScene, PageQuery pageQuery) {
        return stageSceneService.queryPageList(stageScene, pageQuery);
    }

    /**
     * 导出关卡场景列表
     */
    @SaCheckPermission("game:stage:export")
    @Log(title = "关卡场景", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(StageScene stageScene, HttpServletResponse response) {
        List<StageSceneVo> list = stageSceneService.queryList(stageScene);
        ExcelUtil.exportExcel(list, "关卡场景", StageSceneVo.class, response);
    }

    /**
     * 获取关卡场景详细信息
     */
    @SaCheckPermission("game:stage:query")
    @GetMapping("/{id}")
    public R<StageSceneVo> getInfo(@NotNull(message = "场景ID不能为空") @PathVariable Integer id,
                                   @RequestParam(required = false) String region) {
        return R.ok(stageSceneService.queryById(id, region));
    }

    /**
     * 新增关卡场景
     */
    @SaCheckPermission("game:stage:add")
    @Log(title = "关卡场景", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody StageScene stageScene) {
        return toAjax(stageSceneService.insertByBo(stageScene));
    }

    /**
     * 修改关卡场景
     */
    @SaCheckPermission("game:stage:edit")
    @Log(title = "关卡场景", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody StageScene stageScene) {
        return toAjax(stageSceneService.updateByBo(stageScene));
    }

    /**
     * 删除关卡场景
     */
    @SaCheckPermission("game:stage:remove")
    @Log(title = "关卡场景", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "场景ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(stageSceneService.deleteByIds(Arrays.asList(ids), region));
    }
}
