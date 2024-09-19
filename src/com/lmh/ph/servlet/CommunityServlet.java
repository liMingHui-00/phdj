package com.lmh.ph.servlet;

import com.alibaba.fastjson.JSON;
import com.lmh.ph.dao.impl.CommunityDaoImpl;
import com.lmh.ph.entity.Community;
import com.lmh.ph.util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//小区管理
@WebServlet("/community")
public class CommunityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        读取action判断是哪个操作
        String action = req.getParameter("action");
        if ("selectAll".equals(action)) {
//            接受数据
            String communityName = req.getParameter("communityName");
            String startTime = req.getParameter("startTime");
            String endTime = req.getParameter("endTime");
            String pageNum = req.getParameter("pageNum");
            String pageSize = req.getParameter("pageSize");
//          封装到集合中
            CommunityDaoImpl communityDao = new CommunityDaoImpl();
            Map<String, String> map = new HashMap<>();
            map.put("communityName",communityName);
            map.put("startTime",startTime);
            map.put("endTime",endTime);
            map.put("pageNum",pageNum);
            map.put("pageSize",pageSize);
//            连接数据库
            List<Community> communityList = communityDao.selectAll(map);
//           查询所有的条数
            int total = communityDao.selectCount(map);
//            给出响应
            Map resultMap = new HashMap<>();
           resultMap.put("list",communityList);
           resultMap.put("total",total);
            Result result = Result.success(resultMap);
            resp.getWriter().write(JSON.toJSONString(result));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
