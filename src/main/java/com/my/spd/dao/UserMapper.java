package com.my.spd.dao;

import com.my.spd.message.SO.Management.UserSo;
import com.my.spd.pojo.User;
import com.my.spd.pojo.UserExample;
import com.my.spd.pojo.User_Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);





    List<User> searchUserList(UserSo userSo);

    List<Integer> selectasRoleList(Integer id);

    int insertUserAndRole(User_Role userRole);

    Integer insertShowID(User user);

    int deleteUserRoleById(Integer id);

    List<User> searchHaveWarehouseUsers();
}