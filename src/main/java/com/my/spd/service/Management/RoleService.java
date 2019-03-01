package com.my.spd.service.Management;

import java.util.List;
import java.util.Map;

/**
 * Created by YangYuFan on 2019/2/28.
 */
public interface RoleService {
    //展现权限角色页面所需数据
    // (权限名,Array（列表显示菜单数量）)
    Map<String, List<Integer>> showRoles();

    //添加权限名
    Boolean addRole(String newName);

    //根据旧权限名,更新新权限名
    Boolean updateRole(String oldName, String newName);
}
