package com.lmh.ph.dao.impl;

import com.lmh.ph.dao.UserDao;
import com.lmh.ph.entity.User;
import com.lmh.ph.util.JDBCDruidUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User selectUser(String username, String pwd) {
        String sql = "select * from user where username=? and pwd=?";
        Object onj[] ={username,pwd};
        User user = null;
        ResultSet resultSet = JDBCDruidUtil.query(sql,onj);

        try {
            if (resultSet.next()){
                user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JDBCDruidUtil.close();
        return user;
    }
}
