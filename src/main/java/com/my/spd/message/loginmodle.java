package com.my.spd.message;

import com.my.spd.pojo.Menu;
import com.my.spd.pojo.Role;
import com.my.spd.pojo.User;

import java.util.List;

/**
 * Created by YangYuFan on 2019/2/1.
 */
public  class loginmodle {
    private  String code;
    private  String message;
    private  User user;
    private List<List<Menu>> menuList;
    private List<Role> roleList;

    public static loginmodle success(User user,List<List<Menu>> menuList,List<Role> roleList){
        loginmodle modle = new loginmodle();
        modle.setCode("0");
        modle.setMessage("success");
        modle.setUser(user);
        modle.setMenuList(menuList);
        modle.setRoleList(roleList);
        return  modle;
    }

    public static loginmodle fail(String message){
        loginmodle modle = new loginmodle();
        modle.setCode("1");
        modle.setMessage(message);
        return  modle;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<List<Menu>> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<List<Menu>> menuList) {
        this.menuList = menuList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
