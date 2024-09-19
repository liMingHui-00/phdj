package com.lmh.ph.servlet;

import com.alibaba.fastjson.JSON;
import com.lmh.ph.dao.UserDao;
import com.lmh.ph.dao.impl.UserDaoImpl;
import com.lmh.ph.entity.User;
import com.lmh.ph.util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        处理请求参数
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
//        连接数据库
        UserDao userDao = new UserDaoImpl();
        User user = userDao.selectUser(username, pwd);
        if (user==null){
//            登录失败
            Result res = Result.error("用户名或密码错误");
            resp.getWriter().write(JSON.toJSONString(res));
        }else {
//            登录成功
            Result success = Result.success("登录成功");
            resp.getWriter().write(JSON.toJSONString(success));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
