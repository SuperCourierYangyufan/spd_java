package com.my.spd.mybatisGenerator;

import com.my.spd.dao.MenuMapper;
import com.my.spd.dao.UserMapper;
import com.my.spd.pojo.Menu;
import com.my.spd.pojo.MenuExample;
import com.my.spd.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YangYuFan on 2019/1/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Generator {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserMapper userMapper;


    @Test
    public void fun(){
//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(2);
//        MenuExample example = new MenuExample();
//        //in
////        example.createCriteria().andRoleidIn(integers);
//        //order by
////        example.setOrderByClause("`sort` DESC");
//        List<Menu> menus = menuMapper.selectByExample(example);
        menuMapper.selectByPrimaryKey(1);
    }
}
