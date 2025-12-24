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
import org.ruoyi.game.domain.UnitVisual;
import org.ruoyi.game.domain.vo.UnitVisualVo;
import org.ruoyi.game.service.IUnitVisualService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 单位视觉资源管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/unit/visual")
public class UnitVisualController extends BaseController {

    private final IUnitVisualService unitVisualService;

    /**
     * 查询单位视觉资源列表
     */
    @SaCheckPermission("game:unit:visual:list")
    @GetMapping("/list")
    public TableDataInfo<UnitVisualVo> list(UnitVisual unitVisual, PageQuery pageQuery) {
        return unitVisualService.queryPageList(unitVisual, pageQuery);
    }

    /**
     * 导出单位视觉资源列表
     */
    @SaCheckPermission("game:unit:visual:export")
    @Log(title = "单位视觉资源管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(UnitVisual unitVisual, HttpServletResponse response) {
        List<UnitVisualVo> list = unitVisualService.queryList(unitVisual);
        ExcelUtil.exportExcel(list, "单位视觉资源数据", UnitVisualVo.class, response);
    }

    /**
     * 获取单位视觉资源详细信息
     */
    @SaCheckPermission("game:unit:visual:query")
    @GetMapping("/{id}")
    public R<UnitVisualVo> getInfo(@NotNull(message = "视觉资源ID不能为空") @PathVariable Integer id,
                                    @RequestParam(required = false) String region) {
        return R.ok(unitVisualService.queryById(id, region));
    }

    /**
     * 新增单位视觉资源
     */
    @SaCheckPermission("game:unit:visual:add")
    @Log(title = "单位视觉资源管理", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@Validated @RequestBody UnitVisual unitVisual) {
        return toAjax(unitVisualService.insertByBo(unitVisual));
    }

    /**
     * 修改单位视觉资源
     */
    @SaCheckPermission("game:unit:visual:edit")
    @Log(title = "单位视觉资源管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@Validated @RequestBody UnitVisual unitVisual) {
        return toAjax(unitVisualService.updateByBo(unitVisual));
    }

    /**
     * 删除单位视觉资源
     */
    @SaCheckPermission("game:unit:visual:remove")
    @Log(title = "单位视觉资源管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "视觉资源ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(unitVisualService.deleteByIds(Arrays.asList(ids), region));
    }
}
