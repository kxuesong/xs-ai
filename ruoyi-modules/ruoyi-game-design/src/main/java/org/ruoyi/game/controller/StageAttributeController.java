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
import org.ruoyi.game.domain.StageAttribute;
import org.ruoyi.game.domain.vo.StageAttributeVo;
import org.ruoyi.game.service.IStageAttributeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 关卡属性管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/stage/attribute")
public class StageAttributeController extends BaseController {

    private final IStageAttributeService stageAttributeService;

    /**
     * 查询关卡属性列表
     */
    @SaCheckPermission("game:stage:list")
    @GetMapping("/list")
    public TableDataInfo<StageAttributeVo> list(StageAttribute stageAttribute, PageQuery pageQuery) {
        return stageAttributeService.queryPageList(stageAttribute, pageQuery);
    }

    /**
     * 导出关卡属性列表
     */
    @SaCheckPermission("game:stage:export")
    @Log(title = "关卡属性", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(StageAttribute stageAttribute, HttpServletResponse response) {
        List<StageAttributeVo> list = stageAttributeService.queryList(stageAttribute);
        ExcelUtil.exportExcel(list, "关卡属性", StageAttributeVo.class, response);
    }

    /**
     * 获取关卡属性详细信息
     */
    @SaCheckPermission("game:stage:query")
    @GetMapping("/{id}")
    public R<StageAttributeVo> getInfo(@NotNull(message = "属性ID不能为空") @PathVariable Integer id,
                                       @RequestParam(required = false) String region) {
        return R.ok(stageAttributeService.queryById(id, region));
    }

    /**
     * 按关卡组ID查询属性
     */
    @SaCheckPermission("game:stage:list")
    @GetMapping("/by-stage-group/{stageGroupId}")
    public R<List<StageAttributeVo>> getByStageGroupId(@NotNull(message = "关卡组ID不能为空") @PathVariable Integer stageGroupId,
                                                       @RequestParam(required = false) String region) {
        return R.ok(stageAttributeService.queryByStageGroupId(stageGroupId, region));
    }

    /**
     * 新增关卡属性
     */
    @SaCheckPermission("game:stage:add")
    @Log(title = "关卡属性", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody StageAttribute stageAttribute) {
        return toAjax(stageAttributeService.insertByBo(stageAttribute));
    }

    /**
     * 修改关卡属性
     */
    @SaCheckPermission("game:stage:edit")
    @Log(title = "关卡属性", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody StageAttribute stageAttribute) {
        return toAjax(stageAttributeService.updateByBo(stageAttribute));
    }

    /**
     * 删除关卡属性
     */
    @SaCheckPermission("game:stage:remove")
    @Log(title = "关卡属性", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "属性ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(stageAttributeService.deleteByIds(Arrays.asList(ids), region));
    }
}
