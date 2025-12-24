-- =============================================
-- 单位管理模块完整菜单数据（合并版）
-- 生成时间: 2024-12-24
-- 菜单ID范围: 2100000000000000118 - 2100000000000000159
-- 总计: 42 条记录（7个主菜单 + 35个按钮权限）
-- =============================================

-- =============================================
-- 1. 单位管理主表菜单（ID: 118-123）
-- =============================================

-- 单位管理主菜单（类型：C 菜单）
INSERT INTO sys_menu (
    menu_id,
    menu_name,
    parent_id,
    order_num,
    path,
    component,
    query_param,
    is_frame,
    is_cache,
    menu_type,
    visible,
    status,
    perms,
    icon,
    create_by,
    create_time,
    remark
) VALUES (
    2100000000000000118,                          -- menu_id
    '单位管理',                                    -- menu_name
    0,                                             -- parent_id（请根据实际的"游戏设计"父菜单ID修改）
    5,                                             -- order_num（排序）
    'unit',                                        -- path
    'game-design/unit/index',                      -- component
    '',                                            -- query_param
    1,                                             -- is_frame（1=否，0=是）
    0,                                             -- is_cache（0=缓存，1=不缓存）
    'C',                                           -- menu_type（C=菜单）
    '0',                                           -- visible（0=显示，1=隐藏）
    '0',                                           -- status（0=正常，1=停用）
    'game:unit:list',                              -- perms
    'mdi:robot',                                   -- icon
    1,                                             -- create_by（改为用户ID）
    NOW(),                                         -- create_time
    '单位管理菜单'                                 -- remark
);

-- 单位查询按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000119, '单位查询', 2100000000000000118, 1, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:query', '#', 1, NOW(), '单位查询权限');

-- 单位新增按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000120, '单位新增', 2100000000000000118, 2, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:add', '#', 1, NOW(), '单位新增权限');

-- 单位修改按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000121, '单位修改', 2100000000000000118, 3, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:edit', '#', 1, NOW(), '单位修改权限');

-- 单位删除按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000122, '单位删除', 2100000000000000118, 4, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:remove', '#', 1, NOW(), '单位删除权限');

-- 单位导出按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000123, '单位导出', 2100000000000000118, 5, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:export', '#', 1, NOW(), '单位导出权限');


-- =============================================
-- 2. 单位视觉资源菜单（ID: 124-129）
-- =============================================

-- 单位视觉资源主菜单（类型：C 菜单）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000124, '单位视觉资源', 2100000000000000118, 1, 'visual', 'game-design/unit/visual/index', '', 1, 0, 'C', '0', '0', 'game:unit:visual:list', 'mdi:image-multiple', 1, NOW(), '单位视觉资源管理菜单');

-- 视觉资源查询按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000125, '视觉资源查询', 2100000000000000124, 1, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:visual:query', '#', 1, NOW(), '单位视觉资源查询权限');

-- 视觉资源新增按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000126, '视觉资源新增', 2100000000000000124, 2, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:visual:add', '#', 1, NOW(), '单位视觉资源新增权限');

-- 视觉资源修改按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000127, '视觉资源修改', 2100000000000000124, 3, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:visual:edit', '#', 1, NOW(), '单位视觉资源修改权限');

-- 视觉资源删除按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000128, '视觉资源删除', 2100000000000000124, 4, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:visual:remove', '#', 1, NOW(), '单位视觉资源删除权限');

-- 视觉资源导出按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000129, '视觉资源导出', 2100000000000000124, 5, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:visual:export', '#', 1, NOW(), '单位视觉资源导出权限');


-- =============================================
-- 3. 单位觉醒升级菜单（ID: 130-135）
-- =============================================

-- 单位觉醒升级主菜单（类型：C 菜单）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000130, '单位觉醒升级', 2100000000000000118, 2, 'ultimate-up', 'game-design/unit/ultimate-up/index', '', 1, 0, 'C', '0', '0', 'game:unit:ultimate:list', 'mdi:star-circle', 1, NOW(), '单位觉醒升级管理菜单');

-- 觉醒升级查询按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000131, '觉醒升级查询', 2100000000000000130, 1, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:ultimate:query', '#', 1, NOW(), '单位觉醒升级查询权限');

-- 觉醒升级新增按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000132, '觉醒升级新增', 2100000000000000130, 2, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:ultimate:add', '#', 1, NOW(), '单位觉醒升级新增权限');

-- 觉醒升级修改按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000133, '觉醒升级修改', 2100000000000000130, 3, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:ultimate:edit', '#', 1, NOW(), '单位觉醒升级修改权限');

-- 觉醒升级删除按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000134, '觉醒升级删除', 2100000000000000130, 4, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:ultimate:remove', '#', 1, NOW(), '单位觉醒升级删除权限');

-- 觉醒升级导出按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000135, '觉醒升级导出', 2100000000000000130, 5, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:ultimate:export', '#', 1, NOW(), '单位觉醒升级导出权限');


-- =============================================
-- 4. 单位图鉴管理菜单（ID: 136-141）
-- =============================================

-- 单位图鉴主菜单（类型：C 菜单）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000136, '单位图鉴', 2100000000000000118, 3, 'book', 'game-design/unit/book/index', '', 1, 0, 'C', '0', '0', 'game:unit:book:list', 'mdi:book-open-variant', 1, NOW(), '单位图鉴管理菜单');

-- 图鉴查询按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000137, '图鉴查询', 2100000000000000136, 1, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:book:query', '#', 1, NOW(), '单位图鉴查询权限');

-- 图鉴新增按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000138, '图鉴新增', 2100000000000000136, 2, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:book:add', '#', 1, NOW(), '单位图鉴新增权限');

-- 图鉴修改按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000139, '图鉴修改', 2100000000000000136, 3, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:book:edit', '#', 1, NOW(), '单位图鉴修改权限');

-- 图鉴删除按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000140, '图鉴删除', 2100000000000000136, 4, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:book:remove', '#', 1, NOW(), '单位图鉴删除权限');

-- 图鉴导出按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000141, '图鉴导出', 2100000000000000136, 5, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:book:export', '#', 1, NOW(), '单位图鉴导出权限');


-- =============================================
-- 5. 单位经验表菜单（ID: 142-147）
-- =============================================

-- 单位经验表主菜单（类型：C 菜单）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000142, '单位经验表', 2100000000000000118, 4, 'exp', 'game-design/unit/exp/index', '', 1, 0, 'C', '0', '0', 'game:unit:exp:list', 'mdi:chart-line', 1, NOW(), '单位经验表管理菜单');

-- 经验表查询按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000143, '经验表查询', 2100000000000000142, 1, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:exp:query', '#', 1, NOW(), '单位经验表查询权限');

-- 经验表新增按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000144, '经验表新增', 2100000000000000142, 2, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:exp:add', '#', 1, NOW(), '单位经验表新增权限');

-- 经验表修改按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000145, '经验表修改', 2100000000000000142, 3, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:exp:edit', '#', 1, NOW(), '单位经验表修改权限');

-- 经验表删除按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000146, '经验表删除', 2100000000000000142, 4, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:exp:remove', '#', 1, NOW(), '单位经验表删除权限');

-- 经验表导出按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000147, '经验表导出', 2100000000000000142, 5, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:exp:export', '#', 1, NOW(), '单位经验表导出权限');


-- =============================================
-- 6. 单位品质奖励菜单（ID: 148-153）
-- =============================================

-- 单位品质奖励主菜单（类型：C 菜单）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000148, '单位品质奖励', 2100000000000000118, 5, 'grade-reward', 'game-design/unit/grade-reward/index', '', 1, 0, 'C', '0', '0', 'game:unit:reward:list', 'mdi:gift', 1, NOW(), '单位品质奖励管理菜单');

-- 品质奖励查询按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000149, '品质奖励查询', 2100000000000000148, 1, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:reward:query', '#', 1, NOW(), '单位品质奖励查询权限');

-- 品质奖励新增按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000150, '品质奖励新增', 2100000000000000148, 2, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:reward:add', '#', 1, NOW(), '单位品质奖励新增权限');

-- 品质奖励修改按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000151, '品质奖励修改', 2100000000000000148, 3, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:reward:edit', '#', 1, NOW(), '单位品质奖励修改权限');

-- 品质奖励删除按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000152, '品质奖励删除', 2100000000000000148, 4, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:reward:remove', '#', 1, NOW(), '单位品质奖励删除权限');

-- 品质奖励导出按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000153, '品质奖励导出', 2100000000000000148, 5, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:reward:export', '#', 1, NOW(), '单位品质奖励导出权限');


-- =============================================
-- 7. 单位位置定义菜单（ID: 154-159）
-- =============================================

-- 单位位置定义主菜单（类型：C 菜单）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000154, '单位位置定义', 2100000000000000118, 6, 'position', 'game-design/unit/position/index', '', 1, 0, 'C', '0', '0', 'game:unit:position:list', 'mdi:map-marker', 1, NOW(), '单位位置定义管理菜单');

-- 位置定义查询按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000155, '位置定义查询', 2100000000000000154, 1, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:position:query', '#', 1, NOW(), '单位位置定义查询权限');

-- 位置定义新增按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000156, '位置定义新增', 2100000000000000154, 2, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:position:add', '#', 1, NOW(), '单位位置定义新增权限');

-- 位置定义修改按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000157, '位置定义修改', 2100000000000000154, 3, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:position:edit', '#', 1, NOW(), '单位位置定义修改权限');

-- 位置定义删除按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000158, '位置定义删除', 2100000000000000154, 4, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:position:remove', '#', 1, NOW(), '单位位置定义删除权限');

-- 位置定义导出按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000159, '位置定义导出', 2100000000000000154, 5, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:position:export', '#', 1, NOW(), '单位位置定义导出权限');


-- =============================================
-- 菜单数据生成完成
-- 总计: 42 条记录
--   - 7 个主菜单（C类型）
--   - 35 个按钮权限（F类型）
--
-- 菜单ID范围: 2100000000000000118 - 2100000000000000159
-- =============================================

-- 使用说明：
-- 1. ⚠️ 重要：请将第一条INSERT语句（第27行）中的 parent_id 修改为实际的"游戏设计"父菜单ID
--    目前设置为 0，需要根据实际情况修改
-- 2. 其他6个子菜单的 parent_id 已自动设置为单位管理菜单ID（2100000000000000118）
-- 3. create_by 字段已统一修改为用户ID: 1（而非字符串 'admin'）
-- 4. 如果需要调整菜单显示顺序，修改对应的 order_num 字段
-- 5. 如果需要更换图标，修改对应的 icon 字段（参考：https://icon-sets.iconify.design/mdi/）
-- 6. 执行这些SQL语句后，记得给相关角色分配权限
