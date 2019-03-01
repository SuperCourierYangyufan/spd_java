package com.my.spd.service.Management;

import com.github.pagehelper.PageInfo;
import com.my.spd.message.SO.Management.MenuSo;
import com.my.spd.pojo.Menu;

import java.util.List;

/**
 * Created by YangYuFan on 2019/2/23.
 */
public interface MenuService {
    //根据跳出查询
    PageInfo<Menu> searchMenu(MenuSo menu);

    //查询所有父节点信息
    List<Menu> searchRootMenu();

    //添加数据
    String addMenu(Menu menu);

    //更新数据
    String updateMenu(Menu menu);

    //根据Id删除数据
    int deleteMenuById(Integer id);
}
