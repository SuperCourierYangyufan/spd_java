package com.my.spd.dao;

import com.my.spd.pojo.Hospital;
import com.my.spd.pojo.HospitalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HospitalMapper {
    long countByExample(HospitalExample example);

    int deleteByExample(HospitalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Hospital record);

    int insertSelective(Hospital record);

    List<Hospital> selectByExample(HospitalExample example);

    Hospital selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Hospital record, @Param("example") HospitalExample example);

    int updateByExample(@Param("record") Hospital record, @Param("example") HospitalExample example);

    int updateByPrimaryKeySelective(Hospital record);

    int updateByPrimaryKey(Hospital record);






    //查询所有医院的名字和id
    List<Hospital> searchHospitalIdAndName();
}