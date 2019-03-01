package com.my.spd.service.Management.Impl;

import com.my.spd.dao.MenuMapper;
import com.my.spd.dao.RoleMapper;
import com.my.spd.pojo.Menu;
import com.my.spd.pojo.MenuExample;
import com.my.spd.pojo.Role;
import com.my.spd.pojo.RoleExample;
import com.my.spd.service.Management.RoleService;
import com.my.spd.service.System.Impl.SystemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by YangYuFan on 2019/2/28.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private SystemServiceImpl systemService;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Map<String, List<Integer>> showRoles() {
        Map<String, List<Integer>> message = new LinkedHashMap<>();
        //获取所有权限
        List<Role> roles = systemService.getRoleAll();
        //根据Id排序
//        roles = roles.stream().sorted(Comparator.comparing(Role::getId)).collect(Collectors.toList());
        //获得需要的菜单信息
        List<Menu> menus = menuMapper.selectInfoNum();
        //拆分信息
        roles.forEach(role -> {
            //菜单信息 所需 数量 列表
            List<Integer> list = new ArrayList<>();
            //获得当前权限的菜单
            List<Menu> currentRoleMenu = menus.stream().filter(i -> i.getRoleid().toString().equals(role.getId().toString())).collect(Collectors.toList());
            //菜单总数
            int menuCount = (int)currentRoleMenu.stream().filter(i -> i.getIstop().toString().equals("1")).count();
            //功能总数
            int actionCount = currentRoleMenu.size()-menuCount;
            //可见总数
            int showCount = (int) currentRoleMenu.stream().filter(i -> i.getIsshow().toString().equals("1")).count();
            //不可见总数
            int hideConut = currentRoleMenu.size() - showCount;
            list.add(menuCount);
            list.add(actionCount);
            list.add(showCount);
            list.add(hideConut);
            message.put(role.getRolename(),list);
        });
        return message;
    }

    @Override
    public Boolean addRole(String newName) {
        //检查是否有重复权限名
        RoleExample example = new RoleExample();
        example.createCriteria().andRolenameEqualTo(newName);
        List<Role> roles = roleMapper.selectByExample(example);
        if(roles.size()>0){
            return false;
        }
        //添加
        Role role = new Role();
        role.setRolename(newName);
        int i = roleMapper.insert(role);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateRole(String oldName, String newName) {
        RoleExample example = new RoleExample();
        example.createCriteria().andRolenameEqualTo(oldName);

        //添加
        Role role = new Role();
        role.setRolename(newName);
        int i = roleMapper.updateByExampleSelective(role, example);
        if(i>0){
            return true;
        }
        return false;
    }
}
