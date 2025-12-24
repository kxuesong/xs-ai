-- =============================================
-- 单位觉醒升级管理模块菜单数据
-- 生成时间: 2024-12-24
-- 起始ID: 2100000000000000130
-- =============================================

-- 单位觉醒升级主菜单（类型：C 菜单）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000130, '单位觉醒升级', 2100000000000000118, 2, 'ultimate-up', 'game-design/unit/ultimate-up/index', '', 1, 0, 'C', '0', '0', 'game:unit:ultimate:list', 'mdi:star-circle', 'admin', NOW(), '单位觉醒升级管理菜单');

-- 觉醒升级查询按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000131, '觉醒升级查询', 2100000000000000130, 1, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:ultimate:query', '#', 'admin', NOW(), '单位觉醒升级查询权限');

-- 觉醒升级新增按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000132, '觉醒升级新增', 2100000000000000130, 2, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:ultimate:add', '#', 'admin', NOW(), '单位觉醒升级新增权限');

-- 觉醒升级修改按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000133, '觉醒升级修改', 2100000000000000130, 3, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:ultimate:edit', '#', 'admin', NOW(), '单位觉醒升级修改权限');

-- 觉醒升级删除按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000134, '觉醒升级删除', 2100000000000000130, 4, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:ultimate:remove', '#', 'admin', NOW(), '单位觉醒升级删除权限');

-- 觉醒升级导出按钮（类型：F 按钮）
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query_param, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
VALUES (2100000000000000135, '觉醒升级导出', 2100000000000000130, 5, '#', '', '', 1, 0, 'F', '0', '0', 'game:unit:ultimate:export', '#', 'admin', NOW(), '单位觉醒升级导出权限');

-- =============================================
-- 菜单数据生成完成
-- 总计: 6 条记录
--   - 1 个主菜单（C类型）
--   - 5 个按钮权限（F类型）
--
-- 下一个可用ID: 2100000000000000136
-- =============================================
