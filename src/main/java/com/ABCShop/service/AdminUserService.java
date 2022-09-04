package com.ABCShop.service;

import com.ABCShop.entity.AdminUser;

public interface AdminUserService {
    AdminUser selectByUser(String ausername, String apassword);

}
