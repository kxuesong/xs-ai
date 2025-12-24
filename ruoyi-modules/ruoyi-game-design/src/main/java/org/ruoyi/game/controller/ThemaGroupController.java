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
import org.ruoyi.game.domain.ThemaGroup;
import org.ruoyi.game.domain.vo.ThemaGroupVo;
import org.ruoyi.game.service.IThemaGroupService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 章节组管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/thema/group")
public class ThemaGroupController extends BaseController {

    private final IThemaGroupService themaGroupService;

    /**
     * 查询章节组列表
     */
    @SaCheckPermission("game:thema:list")
    @GetMapping("/list")
    public TableDataInfo<ThemaGroupVo> list(ThemaGroup themaGroup, PageQuery pageQuery) {
        return themaGroupService.queryPageList(themaGroup, pageQuery);
    }

    /**
     * 导出章节组列表
     */
    @SaCheckPermission("game:thema:export")
    @Log(title = "章节组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(ThemaGroup themaGroup, HttpServletResponse response) {
        List<ThemaGroupVo> list = themaGroupService.queryList(themaGroup);
        ExcelUtil.exportExcel(list, "章节组", ThemaGroupVo.class, response);
    }

    /**
     * 获取章节组详细信息
     */
    @SaCheckPermission("game:thema:query")
    @GetMapping("/{id}")
    public R<ThemaGroupVo> getInfo(@NotNull(message = "章节ID不能为空") @PathVariable Integer id,
                                   @RequestParam(required = false) String region) {
        return R.ok(themaGroupService.queryById(id, region));
    }

    /**
     * 新增章节组
     */
    @SaCheckPermission("game:thema:add")
    @Log(title = "章节组", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody ThemaGroup themaGroup) {
        return toAjax(themaGroupService.insertByBo(themaGroup));
    }

    /**
     * 修改章节组
     */
    @SaCheckPermission("game:thema:edit")
    @Log(title = "章节组", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody ThemaGroup themaGroup) {
        return toAjax(themaGroupService.updateByBo(themaGroup));
    }

    /**
     * 删除章节组
     */
    @SaCheckPermission("game:thema:remove")
    @Log(title = "章节组", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "章节ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(themaGroupService.deleteByIds(Arrays.asList(ids), region));
    }
}
