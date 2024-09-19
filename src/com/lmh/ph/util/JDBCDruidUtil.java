package com.lmh.ph.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *  使用Druid数据库编写的JDBC的工具类
 */
public class JDBCDruidUtil {
    private static DataSource dataSource = null;
    private static  Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    // 1.加载驱动 -- 只需要加载一次
    static{
        try {
            // 使用properties来实现读取配置文件，创建数据源对象
            Properties properties = new Properties();
            InputStream ins = JDBCDruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(ins);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // 2.建立链接
    public static  void getConnection(){
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 增加 删除 修改
    // insert into student values(?,?,?);    [name,age,birthday]
    public static int update(String sql,Object obj[]){
        int row = 0;
        // 调用获取链接对象
        getConnection();
        try {
            // 3.创建sql语句对象
            preparedStatement = connection.prepareStatement(sql);
            // 数据注入
            if(obj!=null){
                for(int i=0;i<obj.length;i++){
                    preparedStatement.setObject(i+1,obj[i]);
                }
            }
            // 4.执行sql语句
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close();
        }
        return row;
    }

    // 查询方法 -- 不要释放资源，谁用谁在释放
    public static ResultSet query(String sql,Object obj[]){
        // 调用获取链接对象的方法
        getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            // 注入数据
            if(obj!=null){
                for(int i=0;i<obj.length;i++){
                    preparedStatement.setObject(i+1,obj[i]);
                }
            }
            // 执行sql语句
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
    // 5.处理结果集
    // 6.释放资源
    public static void close(){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
