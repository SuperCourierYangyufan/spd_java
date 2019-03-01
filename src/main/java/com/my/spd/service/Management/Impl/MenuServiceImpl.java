package com.my.spd.service.Management.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.spd.conf.baseConf.BaseConf;
import com.my.spd.dao.MenuMapper;
import com.my.spd.message.SO.Management.MenuSo;
import com.my.spd.pojo.Menu;
import com.my.spd.pojo.MenuExample;
import com.my.spd.service.Management.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by YangYuFan on 2019/2/23.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private BaseConf baseConf;

    @Override
    public PageInfo<Menu> searchMenu(MenuSo menu) {
        PageHelper.startPage(menu.getPageNum(),baseConf.getPageSize());
        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        //查询条件
        if(menu.getRoleid()!=null&&menu.getRoleid()!=0){
            criteria.andRoleidEqualTo(menu.getRoleid());
        }
        if(StringUtils.isNotBlank(menu.getIsshow())){
            criteria.andIsshowEqualTo(menu.getIsshow());
        }
        if(StringUtils.isNotBlank(menu.getIstop())){
            criteria.andIstopEqualTo(menu.getIstop());
        }
        if(menu.getId()!=null&&menu.getId()!=0){
            criteria.andParentidEqualTo(menu.getId());
        }
        //查询
        List<Menu> menus = menuMapper.selectByExample(example);
        PageInfo<Menu> page = new PageInfo<>(menus);
        return page;
    }

    @Override
    public List<Menu> searchRootMenu() {
        MenuExample example = new MenuExample();
        example.createCriteria().andIstopEqualTo("1");
        List<Menu> menus = menuMapper.selectByExample(example);
        return menus;
    }

    @Transactional
    @Override
    public String addMenu(Menu menu) {
        if(menu.getIstop().equals("1")){
            //获取最大sort值+100
            menu.setSort(menuMapper.selectMaxSort()+100);
        }
        int i = menuMapper.insert(menu);
        if(i>0){
            return baseConf.getSuccessCode();
        }
        return baseConf.getFailCode();
    }

    @Override
    public String updateMenu(Menu menu) {
        int i = menuMapper.updateByPrimaryKeySelective(menu);
        if(i>0){
            return baseConf.getSuccessCode();
        }
        return baseConf.getFailCode();
    }

    @Override
    public int deleteMenuById(Integer id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

}
