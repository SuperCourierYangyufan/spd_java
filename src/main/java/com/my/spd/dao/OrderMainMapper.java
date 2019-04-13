package com.my.spd.dao;

import com.my.spd.pojo.OrderMain;
import com.my.spd.pojo.OrderMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMainMapper {
    long countByExample(OrderMainExample example);

    int deleteByExample(OrderMainExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderMain record);

    int insertSelective(OrderMain record);

    List<OrderMain> selectByExample(OrderMainExample example);

    OrderMain selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderMain record, @Param("example") OrderMainExample example);

    int updateByExample(@Param("record") OrderMain record, @Param("example") OrderMainExample example);

    int updateByPrimaryKeySelective(OrderMain record);

    int updateByPrimaryKey(OrderMain record);
}