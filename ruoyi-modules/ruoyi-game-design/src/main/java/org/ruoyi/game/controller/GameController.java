package org.ruoyi.game.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.ruoyi.common.core.domain.R;
import org.ruoyi.common.core.validate.AddGroup;
import org.ruoyi.common.core.validate.EditGroup;
import org.ruoyi.common.excel.utils.ExcelUtil;
import org.ruoyi.common.log.annotation.Log;
import org.ruoyi.common.log.enums.BusinessType;
import org.ruoyi.core.page.PageQuery;
import org.ruoyi.core.page.TableDataInfo;
import org.ruoyi.common.web.core.BaseController;
import org.ruoyi.game.domain.Game;
import org.ruoyi.game.domain.vo.GameVo;
import org.ruoyi.game.service.IGameService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 游戏设计管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game")
public class GameController extends BaseController {

    private final IGameService gameService;

    /**
     * 查询游戏设计信息列表
     */
    @SaCheckPermission("game:list")
    @GetMapping("/list")
    public TableDataInfo<GameVo> list(Game game, PageQuery pageQuery) {
        return gameService.queryPageList(game, pageQuery);
    }

    /**
     * 导出游戏设计信息列表
     */
    @SaCheckPermission("game:export")
    @Log(title = "游戏设计管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(Game game, HttpServletResponse response) {
        List<GameVo> list = gameService.queryList(game);
        ExcelUtil.exportExcel(list, "游戏设计信息", GameVo.class, response);
    }

    /**
     * 获取游戏设计信息详细信息
     */
    @SaCheckPermission("game:query")
    @GetMapping("/{gameId}")
    public R<GameVo> getInfo(@NotNull(message = "游戏ID不能为空")
                             @PathVariable Long gameId) {
        return R.ok(gameService.queryById(gameId));
    }

    /**
     * 新增游戏设计信息
     */
    @SaCheckPermission("game:add")
    @Log(title = "游戏设计管理", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@Validated(AddGroup.class) @RequestBody Game game) {
        return toAjax(gameService.insertByBo(game));
    }

    /**
     * 修改游戏设计信息
     */
    @SaCheckPermission("game:edit")
    @Log(title = "游戏设计管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody Game game) {
        return toAjax(gameService.updateByBo(game));
    }

    /**
     * 删除游戏设计信息
     */
    @SaCheckPermission("game:remove")
    @Log(title = "游戏设计管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{gameIds}")
    public R<Void> remove(@NotEmpty(message = "游戏ID不能为空")
                          @PathVariable Long[] gameIds) {
        return toAjax(gameService.deleteWithValidByIds(List.of(gameIds)));
    }
}
