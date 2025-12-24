-- =============================================
-- 单位视觉资源管理模块菜单数据
-- 生成时间: 2024-12-24
-- 起始ID: 2100000000000000124
-- =============================================

-- 单位视觉资源主菜单（类型：C 菜单）
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
    2100000000000000124,                          -- menu_id
    '单位视觉资源',                                -- menu_name
    2100000000000000118,                          -- parent_id（单位管理菜单ID）
    1,                                             -- order_num（排序）
    'visual',                                      -- path
    'game-design/unit/visual/index',               -- component
    '',                                            -- query_param
    1,                                             -- is_frame（1=否，0=是）
    0,                                             -- is_cache（0=缓存，1=不缓存）
    'C',                                           -- menu_type（C=菜单）
    '0',                                           -- visible（0=显示，1=隐藏）
    '0',                                           -- status（0=正常，1=停用）
    'game:unit:visual:list',                       -- perms
    'mdi:image-multiple',                          -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位视觉资源管理菜单'                         -- remark
);

-- 单位视觉资源查询按钮（类型：F 按钮）
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
    2100000000000000125,                          -- menu_id
    '视觉资源查询',                                -- menu_name
    2100000000000000124,                          -- parent_id（单位视觉资源菜单ID）
    1,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type（F=按钮）
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:visual:query',                      -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位视觉资源查询权限'                         -- remark
);

-- 单位视觉资源新增按钮（类型：F 按钮）
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
    2100000000000000126,                          -- menu_id
    '视觉资源新增',                                -- menu_name
    2100000000000000124,                          -- parent_id
    2,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:visual:add',                        -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位视觉资源新增权限'                         -- remark
);

-- 单位视觉资源修改按钮（类型：F 按钮）
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
    2100000000000000127,                          -- menu_id
    '视觉资源修改',                                -- menu_name
    2100000000000000124,                          -- parent_id
    3,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:visual:edit',                       -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位视觉资源修改权限'                         -- remark
);

-- 单位视觉资源删除按钮（类型：F 按钮）
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
    2100000000000000128,                          -- menu_id
    '视觉资源删除',                                -- menu_name
    2100000000000000124,                          -- parent_id
    4,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:visual:remove',                     -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位视觉资源删除权限'                         -- remark
);

-- 单位视觉资源导出按钮（类型：F 按钮）
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
    2100000000000000129,                          -- menu_id
    '视觉资源导出',                                -- menu_name
    2100000000000000124,                          -- parent_id
    5,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:visual:export',                     -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位视觉资源导出权限'                         -- remark
);

-- =============================================
-- 菜单数据生成完成
-- 总计: 6 条记录
--   - 1 个主菜单（C类型）
--   - 5 个按钮权限（F类型）
--
-- 下一个可用ID: 2100000000000000130
-- =============================================

-- 使用说明：
-- 1. parent_id 已设置为单位管理菜单ID（2100000000000000118），作为子菜单
-- 2. 如果需要调整菜单显示顺序，修改 order_num 字段
-- 3. 如果需要更换图标，修改 icon 字段（参考：https://icon-sets.iconify.design/mdi/）
-- 4. 执行这些SQL语句后，记得给相关角色分配权限
