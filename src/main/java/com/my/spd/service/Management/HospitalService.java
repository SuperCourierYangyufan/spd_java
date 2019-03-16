package com.my.spd.service.Management;

import com.github.pagehelper.PageInfo;
import com.my.spd.message.SO.Management.HospitalSo;
import com.my.spd.pojo.Hospital;

import java.util.List;

/**
 * @author 杨宇帆
 * @create 2019-03-11
 */
public interface HospitalService {
    boolean addHospital(Hospital hospital);

    boolean updatehospital(Hospital hospital);

    PageInfo<Hospital> searchHospital(HospitalSo hospitalSo);

    Integer deleteHospital(Integer id);


    //查询所有医院的名字和id
    List<Hospital> searchHospitalIdAndName();
}
