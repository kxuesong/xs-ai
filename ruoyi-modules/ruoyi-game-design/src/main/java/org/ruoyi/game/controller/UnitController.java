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
import org.ruoyi.game.domain.Unit;
import org.ruoyi.game.domain.vo.UnitVo;
import org.ruoyi.game.service.IUnitService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 单位管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/unit")
public class UnitController extends BaseController {

    private final IUnitService unitService;

    /**
     * 查询单位列表
     */
    @SaCheckPermission("game:unit:list")
    @GetMapping("/list")
    public TableDataInfo<UnitVo> list(Unit unit, PageQuery pageQuery) {
        return unitService.queryPageList(unit, pageQuery);
    }

    /**
     * 导出单位列表
     */
    @SaCheckPermission("game:unit:export")
    @Log(title = "单位管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(Unit unit, HttpServletResponse response) {
        List<UnitVo> list = unitService.queryList(unit);
        ExcelUtil.exportExcel(list, "单位数据", UnitVo.class, response);
    }

    /**
     * 获取单位详细信息
     */
    @SaCheckPermission("game:unit:query")
    @GetMapping("/{id}")
    public R<UnitVo> getInfo(@NotNull(message = "单位ID不能为空") @PathVariable Integer id,
                             @RequestParam(required = false) String region) {
        return R.ok(unitService.queryById(id, region));
    }

    /**
     * 新增单位
     */
    @SaCheckPermission("game:unit:add")
    @Log(title = "单位管理", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@Validated @RequestBody Unit unit) {
        return toAjax(unitService.insertByBo(unit));
    }

    /**
     * 修改单位
     */
    @SaCheckPermission("game:unit:edit")
    @Log(title = "单位管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@Validated @RequestBody Unit unit) {
        return toAjax(unitService.updateByBo(unit));
    }

    /**
     * 删除单位
     */
    @SaCheckPermission("game:unit:remove")
    @Log(title = "单位管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "单位ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(unitService.deleteByIds(Arrays.asList(ids), region));
    }
}
