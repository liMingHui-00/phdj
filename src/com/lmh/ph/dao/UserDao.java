package com.lmh.ph.dao;

import com.lmh.ph.entity.User;

public interface UserDao {
    User selectUser(String username,String pwd);
}
