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
import org.ruoyi.game.domain.UnitGradeReward;
import org.ruoyi.game.domain.vo.UnitGradeRewardVo;
import org.ruoyi.game.service.IUnitGradeRewardService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 单位品质奖励管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/unit/grade-reward")
public class UnitGradeRewardController extends BaseController {

    private final IUnitGradeRewardService unitGradeRewardService;

    /**
     * 查询单位品质奖励列表
     */
    @SaCheckPermission("game:unit:reward:list")
    @GetMapping("/list")
    public TableDataInfo<UnitGradeRewardVo> list(UnitGradeReward unitGradeReward, PageQuery pageQuery) {
        return unitGradeRewardService.queryPageList(unitGradeReward, pageQuery);
    }

    /**
     * 导出单位品质奖励列表
     */
    @SaCheckPermission("game:unit:reward:export")
    @Log(title = "单位品质奖励管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(UnitGradeReward unitGradeReward, HttpServletResponse response) {
        List<UnitGradeRewardVo> list = unitGradeRewardService.queryList(unitGradeReward);
        ExcelUtil.exportExcel(list, "单位品质奖励数据", UnitGradeRewardVo.class, response);
    }

    /**
     * 获取单位品质奖励详细信息
     */
    @SaCheckPermission("game:unit:reward:query")
    @GetMapping("/{id}")
    public R<UnitGradeRewardVo> getInfo(@NotNull(message = "品质奖励ID不能为空") @PathVariable Integer id,
                                         @RequestParam(required = false) String region) {
        return R.ok(unitGradeRewardService.queryById(id, region));
    }

    /**
     * 新增单位品质奖励
     */
    @SaCheckPermission("game:unit:reward:add")
    @Log(title = "单位品质奖励管理", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@Validated @RequestBody UnitGradeReward unitGradeReward) {
        return toAjax(unitGradeRewardService.insertByBo(unitGradeReward));
    }

    /**
     * 修改单位品质奖励
     */
    @SaCheckPermission("game:unit:reward:edit")
    @Log(title = "单位品质奖励管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@Validated @RequestBody UnitGradeReward unitGradeReward) {
        return toAjax(unitGradeRewardService.updateByBo(unitGradeReward));
    }

    /**
     * 删除单位品质奖励
     */
    @SaCheckPermission("game:unit:reward:remove")
    @Log(title = "单位品质奖励管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "品质奖励ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(unitGradeRewardService.deleteByIds(Arrays.asList(ids), region));
    }
}
