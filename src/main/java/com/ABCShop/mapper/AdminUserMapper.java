package com.ABCShop.mapper;

import com.ABCShop.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminUser record);

    AdminUser selectByPrimaryKey(Integer id);

    List<AdminUser> selectAll();

    int updateByPrimaryKey(AdminUser record);

    AdminUser selectByUser(@Param("ausername") String ausername, @Param("apassword")String apassword);
}