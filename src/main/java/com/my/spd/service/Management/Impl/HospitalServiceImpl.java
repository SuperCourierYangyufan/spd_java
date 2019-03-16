package com.my.spd.service.Management.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.spd.dao.HospitalMapper;
import com.my.spd.message.SO.Management.HospitalSo;
import com.my.spd.pojo.Hospital;
import com.my.spd.pojo.HospitalExample;
import com.my.spd.service.Management.HospitalService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杨宇帆
 * @create 2019-03-11
 */
@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalMapper hospitalMapper;


    @Override
    public boolean addHospital(Hospital hospital) {
        //初始为0人
        hospital.setEmployeecount(0);
        if(1 == hospitalMapper.insert(hospital))
            return true;
        return false;
    }

    @Override
    public boolean updatehospital(Hospital hospital) {
        if(1 == hospitalMapper.updateByPrimaryKeySelective(hospital))
            return true;
        return false;
    }

    @Override
    public PageInfo<Hospital> searchHospital(HospitalSo hospitalSo) {
        PageHelper.startPage(hospitalSo.getPageNum(), hospitalSo.getPageSize());
        HospitalExample example = new HospitalExample();
        HospitalExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNoneBlank(hospitalSo.getAddress()))
            criteria.andAddressLike("%"+hospitalSo.getAddress()+"%");
        if(StringUtils.isNotBlank(hospitalSo.getType()))
            criteria.andTypeEqualTo(hospitalSo.getType());
        List<Hospital> hospitalList = hospitalMapper.selectByExample(example);
        PageInfo<Hospital> pageInfo = new PageInfo(hospitalList);
        return pageInfo;
    }

    @Override
    public Integer deleteHospital(Integer id) {
        return hospitalMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Hospital> searchHospitalIdAndName() {
        return hospitalMapper.searchHospitalIdAndName();
    }
}
