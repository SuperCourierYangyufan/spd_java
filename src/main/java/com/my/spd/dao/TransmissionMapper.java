package com.my.spd.dao;

import com.my.spd.pojo.Transmission;
import com.my.spd.pojo.TransmissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransmissionMapper {
    long countByExample(TransmissionExample example);

    int deleteByExample(TransmissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Transmission record);

    int insertSelective(Transmission record);

    List<Transmission> selectByExample(TransmissionExample example);

    Transmission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Transmission record, @Param("example") TransmissionExample example);

    int updateByExample(@Param("record") Transmission record, @Param("example") TransmissionExample example);

    int updateByPrimaryKeySelective(Transmission record);

    int updateByPrimaryKey(Transmission record);
}