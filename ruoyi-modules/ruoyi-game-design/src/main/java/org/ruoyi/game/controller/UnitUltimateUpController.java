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
import org.ruoyi.game.domain.UnitUltimateUp;
import org.ruoyi.game.domain.vo.UnitUltimateUpVo;
import org.ruoyi.game.service.IUnitUltimateUpService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 单位觉醒升级管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/unit/ultimate-up")
public class UnitUltimateUpController extends BaseController {

    private final IUnitUltimateUpService unitUltimateUpService;

    /**
     * 查询单位觉醒升级列表
     */
    @SaCheckPermission("game:unit:ultimate:list")
    @GetMapping("/list")
    public TableDataInfo<UnitUltimateUpVo> list(UnitUltimateUp unitUltimateUp, PageQuery pageQuery) {
        return unitUltimateUpService.queryPageList(unitUltimateUp, pageQuery);
    }

    /**
     * 导出单位觉醒升级列表
     */
    @SaCheckPermission("game:unit:ultimate:export")
    @Log(title = "单位觉醒升级管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(UnitUltimateUp unitUltimateUp, HttpServletResponse response) {
        List<UnitUltimateUpVo> list = unitUltimateUpService.queryList(unitUltimateUp);
        ExcelUtil.exportExcel(list, "单位觉醒升级数据", UnitUltimateUpVo.class, response);
    }

    /**
     * 获取单位觉醒升级详细信息
     */
    @SaCheckPermission("game:unit:ultimate:query")
    @GetMapping("/{id}")
    public R<UnitUltimateUpVo> getInfo(@NotNull(message = "觉醒升级ID不能为空") @PathVariable Integer id,
                                        @RequestParam(required = false) String region) {
        return R.ok(unitUltimateUpService.queryById(id, region));
    }

    /**
     * 新增单位觉醒升级
     */
    @SaCheckPermission("game:unit:ultimate:add")
    @Log(title = "单位觉醒升级管理", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@Validated @RequestBody UnitUltimateUp unitUltimateUp) {
        return toAjax(unitUltimateUpService.insertByBo(unitUltimateUp));
    }

    /**
     * 修改单位觉醒升级
     */
    @SaCheckPermission("game:unit:ultimate:edit")
    @Log(title = "单位觉醒升级管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@Validated @RequestBody UnitUltimateUp unitUltimateUp) {
        return toAjax(unitUltimateUpService.updateByBo(unitUltimateUp));
    }

    /**
     * 删除单位觉醒升级
     */
    @SaCheckPermission("game:unit:ultimate:remove")
    @Log(title = "单位觉醒升级管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "觉醒升级ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(unitUltimateUpService.deleteByIds(Arrays.asList(ids), region));
    }
}
