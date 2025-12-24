-- =============================================
-- 单位品质奖励管理模块菜单数据
-- 生成时间: 2024-12-24
-- 起始ID: 2100000000000000148
-- =============================================

-- 单位品质奖励主菜单（类型：C 菜单）
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
    2100000000000000148,                          -- menu_id
    '单位品质奖励',                                -- menu_name
    2100000000000000118,                          -- parent_id（单位管理菜单ID）
    6,                                             -- order_num（排序）
    'grade-reward',                                -- path
    'game-design/unit/grade-reward/index',         -- component
    '',                                            -- query_param
    1,                                             -- is_frame（1=否，0=是）
    0,                                             -- is_cache（0=缓存，1=不缓存）
    'C',                                           -- menu_type（C=菜单）
    '0',                                           -- visible（0=显示，1=隐藏）
    '0',                                           -- status（0=正常，1=停用）
    'game:unit:reward:list',                       -- perms
    'mdi:star-circle',                             -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位品质奖励管理菜单'                         -- remark
);

-- 单位品质奖励查询按钮（类型：F 按钮）
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
    2100000000000000149,                          -- menu_id
    '品质奖励查询',                                -- menu_name
    2100000000000000148,                          -- parent_id（单位品质奖励菜单ID）
    1,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type（F=按钮）
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:reward:query',                      -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位品质奖励查询权限'                         -- remark
);

-- 单位品质奖励新增按钮（类型：F 按钮）
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
    2100000000000000150,                          -- menu_id
    '品质奖励新增',                                -- menu_name
    2100000000000000148,                          -- parent_id
    2,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:reward:add',                        -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位品质奖励新增权限'                         -- remark
);

-- 单位品质奖励修改按钮（类型：F 按钮）
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
    2100000000000000151,                          -- menu_id
    '品质奖励修改',                                -- menu_name
    2100000000000000148,                          -- parent_id
    3,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:reward:edit',                       -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位品质奖励修改权限'                         -- remark
);

-- 单位品质奖励删除按钮（类型：F 按钮）
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
    2100000000000000152,                          -- menu_id
    '品质奖励删除',                                -- menu_name
    2100000000000000148,                          -- parent_id
    4,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:reward:remove',                     -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位品质奖励删除权限'                         -- remark
);

-- 单位品质奖励导出按钮（类型：F 按钮）
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
    2100000000000000153,                          -- menu_id
    '品质奖励导出',                                -- menu_name
    2100000000000000148,                          -- parent_id
    5,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:reward:export',                     -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位品质奖励导出权限'                         -- remark
);

-- =============================================
-- 菜单数据生成完成
-- 总计: 6 条记录
--   - 1 个主菜单（C类型）
--   - 5 个按钮权限（F类型）
--
-- 下一个可用ID: 2100000000000000154
-- =============================================
