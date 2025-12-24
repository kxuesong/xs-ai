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
import org.ruoyi.game.domain.UnitBook;
import org.ruoyi.game.domain.vo.UnitBookVo;
import org.ruoyi.game.service.IUnitBookService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 单位图鉴管理 Controller
 *
 * @author ruoyi
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/game-design/unit/book")
public class UnitBookController extends BaseController {

    private final IUnitBookService unitBookService;

    /**
     * 查询单位图鉴列表
     */
    @SaCheckPermission("game:unit:book:list")
    @GetMapping("/list")
    public TableDataInfo<UnitBookVo> list(UnitBook unitBook, PageQuery pageQuery) {
        return unitBookService.queryPageList(unitBook, pageQuery);
    }

    /**
     * 导出单位图鉴列表
     */
    @SaCheckPermission("game:unit:book:export")
    @Log(title = "单位图鉴管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(UnitBook unitBook, HttpServletResponse response) {
        List<UnitBookVo> list = unitBookService.queryList(unitBook);
        ExcelUtil.exportExcel(list, "单位图鉴数据", UnitBookVo.class, response);
    }

    /**
     * 获取单位图鉴详细信息
     */
    @SaCheckPermission("game:unit:book:query")
    @GetMapping("/{id}")
    public R<UnitBookVo> getInfo(@NotNull(message = "图鉴ID不能为空") @PathVariable Integer id,
                                  @RequestParam(required = false) String region) {
        return R.ok(unitBookService.queryById(id, region));
    }

    /**
     * 新增单位图鉴
     */
    @SaCheckPermission("game:unit:book:add")
    @Log(title = "单位图鉴管理", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@Validated @RequestBody UnitBook unitBook) {
        return toAjax(unitBookService.insertByBo(unitBook));
    }

    /**
     * 修改单位图鉴
     */
    @SaCheckPermission("game:unit:book:edit")
    @Log(title = "单位图鉴管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@Validated @RequestBody UnitBook unitBook) {
        return toAjax(unitBookService.updateByBo(unitBook));
    }

    /**
     * 删除单位图鉴
     */
    @SaCheckPermission("game:unit:book:remove")
    @Log(title = "单位图鉴管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "图鉴ID不能为空") @PathVariable Integer[] ids,
                          @RequestParam(required = false) String region) {
        return toAjax(unitBookService.deleteByIds(Arrays.asList(ids), region));
    }
}
