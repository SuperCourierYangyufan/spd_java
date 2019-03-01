package com.my.spd.service.Management;

import com.github.pagehelper.PageInfo;
import com.my.spd.message.SO.Management.DictionarySo;
import com.my.spd.pojo.Dictionary;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by YangYuFan on 2019/2/27.
 */
public interface DictionaryService {
    //添加字典属性
    Integer addDictionary(Dictionary dictionary);

    //更新字典属性
    Integer updateDictionary(Dictionary dictionary);

    //根据查询条件查询字典列表
    PageInfo<Dictionary> searchDictionary(DictionarySo dictionarySo);

    //查询所有字典属性的类别列表
    List<String> getAllCategory();

    //删除字典菜单根据主键
    Integer deleteDictionaryById(Integer id);

    //导出字典菜单
    Boolean exportDictionaryExcel(HttpServletResponse response);
}
