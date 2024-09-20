package com.lmh.ph.servlet;

import com.alibaba.fastjson.JSON;
import com.lmh.ph.dao.CommunityDao;
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
            map.put("communityName", communityName);
            map.put("startTime", startTime);
            map.put("endTime", endTime);
            map.put("pageNum", pageNum);
            map.put("pageSize", pageSize);
//            连接数据库
            List<Community> communityList = communityDao.selectAll(map);
//           查询所有的条数
            int total = communityDao.selectCount(map);
//            给出响应
            Map resultMap = new HashMap<>();
            resultMap.put("list", communityList);
            resultMap.put("total", total);
            Result result = Result.success(resultMap);
            resp.getWriter().write(JSON.toJSONString(result));
        }
//        删除
        if ("communityRemove".equals(action)) {
            String communityId = req.getParameter("communityId");
//            System.out.println(communityId);
//            调用数据库删除数据
            CommunityDaoImpl communityDao = new CommunityDaoImpl();
            communityDao.delete(Integer.parseInt(communityId));
            Result result = Result.success("删除成功");
            resp.getWriter().write(JSON.toJSONString(result));
        }
//        增加 修改
        if ("communityUpdate".equals(action)) {
            String addOrUpdateFlag = req.getParameter("addOrUpdateFlag");
            String communityAddress = req.getParameter("communityAddress");
            String communityCode = req.getParameter("communityAreaCode");
            int communityAreaCode = 0;
            if (communityCode!=null && !"".equals(communityCode)){
                communityAreaCode = Integer.parseInt(communityCode);
            }
            String communityCity = req.getParameter("communityCity");
            String communityCoordinates = req.getParameter("communityCoordinates");
            String communityDistrict = req.getParameter("communityDistrict");
            String cid = req.getParameter("communityId");
//            如果是新增的  id自增
            int communityId = 0;
//            修改的话，id是传过来的
            if (cid!=null&&!"".equals(cid)){
                communityId = Integer.parseInt(cid);
            }
            String communityLatitude = req.getParameter("communityLatitude");
            String communityLongitude = req.getParameter("communityLongitude");
            String communityName = req.getParameter("communityName");
            String communityProvince = req.getParameter("communityProvince");
//            组成对象
            Community community = new Community(communityId, communityName, communityProvince,
                    communityCity, communityDistrict, communityAddress, communityLatitude, communityLongitude,
                    communityAreaCode, communityCoordinates);
//            判断是新增还是修改
            if ("1".equals(addOrUpdateFlag)){
//                新增
                //            连接数据库
                int insert = new CommunityDaoImpl().insert(community);
                if (insert!=0){
                    Result msg = Result.success("添加成功");
                    resp.getWriter().write(JSON.toJSONString(msg));
                }else {
                    Result msg = Result.error("添加失败");
                    resp.getWriter().write(JSON.toJSONString(msg));
                }
            }else {
//                修改
                int insert = new CommunityDaoImpl().update(community);
                if (insert!=0){
                    Result msg = Result.success("修改成功");
                    resp.getWriter().write(JSON.toJSONString(msg));
                }else {
                    Result msg = Result.error("修改失败");
                    resp.getWriter().write(JSON.toJSONString(msg));
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
