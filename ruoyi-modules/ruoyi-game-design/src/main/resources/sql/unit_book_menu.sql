-- =============================================
-- 单位图鉴管理模块菜单数据
-- 生成时间: 2024-12-24
-- 起始ID: 2100000000000000136
-- =============================================

-- 单位图鉴主菜单（类型：C 菜单）
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
    2100000000000000136,                          -- menu_id
    '单位图鉴',                                    -- menu_name
    2100000000000000118,                          -- parent_id（单位管理菜单ID）
    4,                                             -- order_num（排序）
    'book',                                        -- path
    'game-design/unit/book/index',                 -- component
    '',                                            -- query_param
    1,                                             -- is_frame（1=否，0=是）
    0,                                             -- is_cache（0=缓存，1=不缓存）
    'C',                                           -- menu_type（C=菜单）
    '0',                                           -- visible（0=显示，1=隐藏）
    '0',                                           -- status（0=正常，1=停用）
    'game:unit:book:list',                         -- perms
    'mdi:book-open-page-variant',                  -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位图鉴管理菜单'                             -- remark
);

-- 单位图鉴查询按钮（类型：F 按钮）
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
    2100000000000000137,                          -- menu_id
    '图鉴查询',                                    -- menu_name
    2100000000000000136,                          -- parent_id（单位图鉴菜单ID）
    1,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type（F=按钮）
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:book:query',                        -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位图鉴查询权限'                             -- remark
);

-- 单位图鉴新增按钮（类型：F 按钮）
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
    2100000000000000138,                          -- menu_id
    '图鉴新增',                                    -- menu_name
    2100000000000000136,                          -- parent_id
    2,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:book:add',                          -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位图鉴新增权限'                             -- remark
);

-- 单位图鉴修改按钮（类型：F 按钮）
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
    2100000000000000139,                          -- menu_id
    '图鉴修改',                                    -- menu_name
    2100000000000000136,                          -- parent_id
    3,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:book:edit',                         -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位图鉴修改权限'                             -- remark
);

-- 单位图鉴删除按钮（类型：F 按钮）
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
    2100000000000000140,                          -- menu_id
    '图鉴删除',                                    -- menu_name
    2100000000000000136,                          -- parent_id
    4,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:book:remove',                       -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位图鉴删除权限'                             -- remark
);

-- 单位图鉴导出按钮（类型：F 按钮）
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
    2100000000000000141,                          -- menu_id
    '图鉴导出',                                    -- menu_name
    2100000000000000136,                          -- parent_id
    5,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:book:export',                       -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位图鉴导出权限'                             -- remark
);

-- =============================================
-- 菜单数据生成完成
-- 总计: 6 条记录
--   - 1 个主菜单（C类型）
--   - 5 个按钮权限（F类型）
--
-- 下一个可用ID: 2100000000000000142
-- =============================================
