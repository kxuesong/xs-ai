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
import org.ruoyi.game.domain.StageReward;
import org.ruoyi.game.domain.vo.StageRewardVo;
import org.ruoyi.game.service.IStageRewardService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 关卡奖励管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/stage/reward")
public class StageRewardController extends BaseController {

    private final IStageRewardService stageRewardService;

    /**
     * 查询关卡奖励列表
     */
    @SaCheckPermission("game:stage:list")
    @GetMapping("/list")
    public TableDataInfo<StageRewardVo> list(StageReward stageReward, PageQuery pageQuery) {
        return stageRewardService.queryPageList(stageReward, pageQuery);
    }

    /**
     * 导出关卡奖励列表
     */
    @SaCheckPermission("game:stage:export")
    @Log(title = "关卡奖励", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(StageReward stageReward, HttpServletResponse response) {
        List<StageRewardVo> list = stageRewardService.queryList(stageReward);
        ExcelUtil.exportExcel(list, "关卡奖励", StageRewardVo.class, response);
    }

    /**
     * 获取关卡奖励详细信息
     */
    @SaCheckPermission("game:stage:query")
    @GetMapping("/{id}")
    public R<StageRewardVo> getInfo(@NotNull(message = "奖励ID不能为空") @PathVariable Integer id,
                                    @RequestParam(required = false) String region) {
        return R.ok(stageRewardService.queryById(id, region));
    }

    /**
     * 按关卡属性ID查询奖励
     */
    @SaCheckPermission("game:stage:list")
    @GetMapping("/by-stage-attribute/{stageAttributeId}")
    public R<List<StageRewardVo>> getByStageAttributeId(@NotNull(message = "关卡属性ID不能为空") @PathVariable Integer stageAttributeId,
                                                        @RequestParam(required = false) String region) {
        return R.ok(stageRewardService.queryByStageAttributeId(stageAttributeId, region));
    }

    /**
     * 新增关卡奖励
     */
    @SaCheckPermission("game:stage:add")
    @Log(title = "关卡奖励", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody StageReward stageReward) {
        return toAjax(stageRewardService.insertByBo(stageReward));
    }

    /**
     * 修改关卡奖励
     */
    @SaCheckPermission("game:stage:edit")
    @Log(title = "关卡奖励", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody StageReward stageReward) {
        return toAjax(stageRewardService.updateByBo(stageReward));
    }

    /**
     * 删除关卡奖励
     */
    @SaCheckPermission("game:stage:remove")
    @Log(title = "关卡奖励", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "奖励ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(stageRewardService.deleteByIds(Arrays.asList(ids), region));
    }
}
