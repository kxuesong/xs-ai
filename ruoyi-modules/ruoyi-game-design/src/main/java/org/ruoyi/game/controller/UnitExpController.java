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
import org.ruoyi.game.domain.UnitExp;
import org.ruoyi.game.domain.vo.UnitExpVo;
import org.ruoyi.game.service.IUnitExpService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 单位经验表管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/unit/exp")
public class UnitExpController extends BaseController {

    private final IUnitExpService unitExpService;

    /**
     * 查询单位经验配置列表
     */
    @SaCheckPermission("game:unit:exp:list")
    @GetMapping("/list")
    public TableDataInfo<UnitExpVo> list(UnitExp unitExp, PageQuery pageQuery) {
        return unitExpService.queryPageList(unitExp, pageQuery);
    }

    /**
     * 导出单位经验配置列表
     */
    @SaCheckPermission("game:unit:exp:export")
    @Log(title = "单位经验表管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(UnitExp unitExp, HttpServletResponse response) {
        List<UnitExpVo> list = unitExpService.queryList(unitExp);
        ExcelUtil.exportExcel(list, "单位经验表数据", UnitExpVo.class, response);
    }

    /**
     * 获取单位经验配置详细信息
     */
    @SaCheckPermission("game:unit:exp:query")
    @GetMapping("/{id}")
    public R<UnitExpVo> getInfo(@NotNull(message = "经验配置ID不能为空") @PathVariable Integer id,
                                 @RequestParam(required = false) String region) {
        return R.ok(unitExpService.queryById(id, region));
    }

    /**
     * 新增单位经验配置
     */
    @SaCheckPermission("game:unit:exp:add")
    @Log(title = "单位经验表管理", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@Validated @RequestBody UnitExp unitExp) {
        return toAjax(unitExpService.insertByBo(unitExp));
    }

    /**
     * 修改单位经验配置
     */
    @SaCheckPermission("game:unit:exp:edit")
    @Log(title = "单位经验表管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@Validated @RequestBody UnitExp unitExp) {
        return toAjax(unitExpService.updateByBo(unitExp));
    }

    /**
     * 删除单位经验配置
     */
    @SaCheckPermission("game:unit:exp:remove")
    @Log(title = "单位经验表管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "经验配置ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(unitExpService.deleteByIds(Arrays.asList(ids), region));
    }
}
