-- =============================================
-- 单位经验表管理模块菜单数据
-- 生成时间: 2024-12-24
-- 起始ID: 2100000000000000142
-- =============================================

-- 单位经验表主菜单（类型：C 菜单）
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
    2100000000000000142,                          -- menu_id
    '单位经验表',                                  -- menu_name
    2100000000000000118,                          -- parent_id（单位管理菜单ID）
    5,                                             -- order_num（排序）
    'exp',                                         -- path
    'game-design/unit/exp/index',                  -- component
    '',                                            -- query_param
    1,                                             -- is_frame（1=否，0=是）
    0,                                             -- is_cache（0=缓存，1=不缓存）
    'C',                                           -- menu_type（C=菜单）
    '0',                                           -- visible（0=显示，1=隐藏）
    '0',                                           -- status（0=正常，1=停用）
    'game:unit:exp:list',                          -- perms
    'mdi:chart-line',                              -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位经验表管理菜单'                           -- remark
);

-- 单位经验表查询按钮（类型：F 按钮）
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
    2100000000000000143,                          -- menu_id
    '经验表查询',                                  -- menu_name
    2100000000000000142,                          -- parent_id（单位经验表菜单ID）
    1,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type（F=按钮）
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:exp:query',                         -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位经验表查询权限'                           -- remark
);

-- 单位经验表新增按钮（类型：F 按钮）
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
    2100000000000000144,                          -- menu_id
    '经验表新增',                                  -- menu_name
    2100000000000000142,                          -- parent_id
    2,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:exp:add',                           -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位经验表新增权限'                           -- remark
);

-- 单位经验表修改按钮（类型：F 按钮）
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
    2100000000000000145,                          -- menu_id
    '经验表修改',                                  -- menu_name
    2100000000000000142,                          -- parent_id
    3,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:exp:edit',                          -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位经验表修改权限'                           -- remark
);

-- 单位经验表删除按钮（类型：F 按钮）
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
    2100000000000000146,                          -- menu_id
    '经验表删除',                                  -- menu_name
    2100000000000000142,                          -- parent_id
    4,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:exp:remove',                        -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位经验表删除权限'                           -- remark
);

-- 单位经验表导出按钮（类型：F 按钮）
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
    2100000000000000147,                          -- menu_id
    '经验表导出',                                  -- menu_name
    2100000000000000142,                          -- parent_id
    5,                                             -- order_num
    '#',                                           -- path
    '',                                            -- component
    '',                                            -- query_param
    1,                                             -- is_frame
    0,                                             -- is_cache
    'F',                                           -- menu_type
    '0',                                           -- visible
    '0',                                           -- status
    'game:unit:exp:export',                        -- perms
    '#',                                           -- icon
    'admin',                                       -- create_by
    NOW(),                                         -- create_time
    '单位经验表导出权限'                           -- remark
);

-- =============================================
-- 菜单数据生成完成
-- 总计: 6 条记录
--   - 1 个主菜单（C类型）
--   - 5 个按钮权限（F类型）
--
-- 下一个可用ID: 2100000000000000148
-- =============================================
