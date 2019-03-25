package com.my.spd.service.Management.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.spd.dao.DictionaryMapper;
import com.my.spd.message.SO.Management.DictionarySo;
import com.my.spd.pojo.Dictionary;
import com.my.spd.pojo.DictionaryExample;
import com.my.spd.service.Management.DictionaryService;
import com.my.spd.utils.Excel.ExcelData;
import com.my.spd.utils.Excel.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YangYuFan on 2019/2/27.
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryMapper dictionaryMapper;


    @Override
    public Integer addDictionary(Dictionary dictionary) {
        return dictionaryMapper.insert(dictionary);
    }

    @Override
    public Integer updateDictionary(Dictionary dictionary) {
        return dictionaryMapper.updateByPrimaryKeySelective(dictionary);
    }

    @Override
    public PageInfo<Dictionary> searchDictionary(DictionarySo dictionarySo) {
        //分页
        PageHelper.startPage(dictionarySo.getPageNum(),dictionarySo.getPageSize());
        DictionaryExample example = new DictionaryExample();
        DictionaryExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNoneBlank(dictionarySo.getName())){
            criteria.andNameLike("%"+dictionarySo.getName()+"%");
        }else if(StringUtils.isNoneBlank(dictionarySo.getCategory())){
            criteria.andCategoryEqualTo(dictionarySo.getCategory());
        }else if(dictionarySo.getValue()!=null&&dictionarySo.getValue()!=0){
            criteria.andValueEqualTo(dictionarySo.getValue());
        }
        List<Dictionary> dictionaries = dictionaryMapper.selectByExample(example);
        PageInfo<Dictionary> pageInfo = new PageInfo<>(dictionaries);
        return pageInfo;
    }

    @Override
    public List<String> getAllCategory() {
        return dictionaryMapper.getAllCategory();
    }

    @Override
    public Integer deleteDictionaryById(Integer id) {
        return dictionaryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Boolean exportDictionaryExcel(HttpServletResponse response) {
        //查出所有数据
        List<Dictionary> dictionaries = dictionaryMapper.selectByExample(new DictionaryExample());
        //设置表头
        String[] head ={"序列Id值","字典名","字典值","字典类别"};
        //设置文件名
        String fileName = "字典数据";
        //设置值
        List<String[]> list = new ArrayList<String[]>();
        for(Dictionary dictionary : dictionaries){
            String[] arrs = new String[5];
            arrs[0] = dictionary.getId().toString();
            arrs[1] = dictionary.getName();
            arrs[2] = dictionary.getValue().toString();
            arrs[3] = dictionary.getCategory();
            list.add(arrs);
        }

        //填充
        ExcelData data = new ExcelData();
        data.setHead(head);
        data.setData(list);
        data.setFileName(fileName);
        //实现导出
        try {
            ExcelUtil.exportExcel(response, data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
