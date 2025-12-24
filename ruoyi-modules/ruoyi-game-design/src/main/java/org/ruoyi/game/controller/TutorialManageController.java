package org.ruoyi.game.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.domain.R;
import org.ruoyi.common.web.core.BaseController;
import org.ruoyi.game.domain.vo.TutorialFlowVo;
import org.ruoyi.game.domain.vo.TutorialFullDataVo;
import org.ruoyi.game.domain.vo.TutorialListItemVo;
import org.ruoyi.game.service.ITutorialManageService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 教程综合管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/tutorial/manage")
public class TutorialManageController extends BaseController {

    private final ITutorialManageService tutorialManageService;

    /**
     * 获取教程列表（含统计信息）
     */
    @SaCheckPermission("game:tutorial:manage:list")
    @GetMapping("/list")
    public R<List<TutorialListItemVo>> getTutorialList(@RequestParam(required = false) String region) {
        List<TutorialListItemVo> list = tutorialManageService.getTutorialList(region);
        return R.ok(list);
    }

    /**
     * 获取教程完整数据（流程链+条件+事件+标题）
     */
    @SaCheckPermission("game:tutorial:manage:query")
    @GetMapping("/full/{flowId}")
    public R<TutorialFullDataVo> getTutorialFullData(
        @NotNull(message = "流程ID不能为空") @PathVariable Integer flowId,
        @RequestParam(required = false) String region
    ) {
        TutorialFullDataVo fullData = tutorialManageService.getTutorialFullData(flowId, region);
        return R.ok(fullData);
    }

    /**
     * 获取流程链（递归查询next_step_id）
     */
    @SaCheckPermission("game:tutorial:manage:query")
    @GetMapping("/flow-chain/{flowId}")
    public R<List<TutorialFlowVo>> getFlowChain(
        @NotNull(message = "流程ID不能为空") @PathVariable Integer flowId,
        @RequestParam(required = false) String region
    ) {
        List<TutorialFlowVo> flowChain = tutorialManageService.getFlowChain(flowId, region);
        return R.ok(flowChain);
    }
}
