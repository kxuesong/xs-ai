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
import org.ruoyi.game.domain.UnitPosition;
import org.ruoyi.game.domain.vo.UnitPositionVo;
import org.ruoyi.game.service.IUnitPositionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 单位位置定义管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/unit/position")
public class UnitPositionController extends BaseController {

    private final IUnitPositionService unitPositionService;

    /**
     * 查询单位位置定义列表
     */
    @SaCheckPermission("game:unit:position:list")
    @GetMapping("/list")
    public TableDataInfo<UnitPositionVo> list(UnitPosition unitPosition, PageQuery pageQuery) {
        return unitPositionService.queryPageList(unitPosition, pageQuery);
    }

    /**
     * 导出单位位置定义列表
     */
    @SaCheckPermission("game:unit:position:export")
    @Log(title = "单位位置定义管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(UnitPosition unitPosition, HttpServletResponse response) {
        List<UnitPositionVo> list = unitPositionService.queryList(unitPosition);
        ExcelUtil.exportExcel(list, "单位位置定义数据", UnitPositionVo.class, response);
    }

    /**
     * 获取单位位置定义详细信息
     */
    @SaCheckPermission("game:unit:position:query")
    @GetMapping("/{id}")
    public R<UnitPositionVo> getInfo(@NotNull(message = "位置ID不能为空") @PathVariable Integer id,
                                      @RequestParam(required = false) String region) {
        return R.ok(unitPositionService.queryById(id, region));
    }

    /**
     * 新增单位位置定义
     */
    @SaCheckPermission("game:unit:position:add")
    @Log(title = "单位位置定义管理", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@Validated @RequestBody UnitPosition unitPosition) {
        return toAjax(unitPositionService.insertByBo(unitPosition));
    }

    /**
     * 修改单位位置定义
     */
    @SaCheckPermission("game:unit:position:edit")
    @Log(title = "单位位置定义管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@Validated @RequestBody UnitPosition unitPosition) {
        return toAjax(unitPositionService.updateByBo(unitPosition));
    }

    /**
     * 删除单位位置定义
     */
    @SaCheckPermission("game:unit:position:remove")
    @Log(title = "单位位置定义管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "位置ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(unitPositionService.deleteByIds(Arrays.asList(ids), region));
    }
}
