package com.my.spd.dao;

import com.my.spd.message.VO.OrderDetailsVO;
import com.my.spd.pojo.OrderDetails;
import com.my.spd.pojo.OrderDetailsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDetailsMapper {
    long countByExample(OrderDetailsExample example);

    int deleteByExample(OrderDetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderDetails record);

    int insertSelective(OrderDetails record);

    List<OrderDetails> selectByExample(OrderDetailsExample example);

    OrderDetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderDetails record, @Param("example") OrderDetailsExample example);

    int updateByExample(@Param("record") OrderDetails record, @Param("example") OrderDetailsExample example);

    int updateByPrimaryKeySelective(OrderDetails record);

    int updateByPrimaryKey(OrderDetails record);




    //根据单号查询详情信息和货物信息
    List<OrderDetailsVO> selectDetails(String lotNumber);
}