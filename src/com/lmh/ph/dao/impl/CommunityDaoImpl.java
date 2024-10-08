package com.lmh.ph.dao.impl;

import com.alibaba.druid.util.JdbcUtils;
import com.lmh.ph.dao.CommunityDao;
import com.lmh.ph.entity.Community;
import com.lmh.ph.util.JDBCDruidUtil;

import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CommunityDaoImpl implements CommunityDao {
    @Override
    public int insert(Community community) {
//        communityName
//        communityProvince
//        communityCity
//        communityDistrict
//        communityAddress
//        communityLatitude communityLongitude
//        communityShopCount communityStatus  communityUserCount startTime distance communityCoordinates communityAreaCode
        String sql = "insert into community values (null,?, ?, ?, ?, ?, ? ,? ,? ,?, ?, ?, ?, ?,  ?) ";
        Object obj[] = {
                community.getCommunityName(),
                community.getCommunityProvince(),
                community.getCommunityCity(),
                community.getCommunityDistrict(),
                community.getCommunityAddress(),
                community.getCommunityLatitude(),
                community.getCommunityLongitude(),
                new Date(),
                community.getCommunityShopCount(),
                community.getCommunityAreaCode(),
                community.getCommunityCoordinates(),
                community.getCommunityStatus(),
                community.getCommunityUserCount(),
                community.getDistance()
        };
        return JDBCDruidUtil.update(sql, obj);
    }

    @Override
    public int update(Community community) {
        String sql = "update community set communityName= ?," +
                                            "communityProvince=?," +
                                            "communityCity=?," +
                                            "communityDistrict=?," +
                                            "communityAddress=?," +
                                            "communityLatitude=?," +
                                            "communityLongitude=? " +
                                            "where communityId = ? ";
        Object obj[] = {
                community.getCommunityName(),
                community.getCommunityProvince(),
                community.getCommunityCity(),
                community.getCommunityDistrict(),
                community.getCommunityAddress(),
                community.getCommunityLatitude(),
                community.getCommunityLongitude(),
                community.getCommunityId()
        };
        return JDBCDruidUtil.update(sql, obj);
    }

    @Override
    public int delete(int communityId) {
        String sql = "delete from community where communityId = ?";
        Object obj[] = {communityId};
        return JDBCDruidUtil.update(sql, obj);
    }

    @Override
    public List<Community> selectAll(Map<String, String> map) {
        ArrayList<Community> list = new ArrayList<>();
        String sql = "select * from  community where 1=1 ";
        List params = new ArrayList<>();
//        动态sql
//        根据名字
        String communityName = map.get("communityName");
        if (communityName != null && !"".equals(communityName)) {
            sql += " and communityName like ? ";
            params.add("%" + communityName + "%");
        }
//        根据时间
        String startTime = map.get("startTime");
        if (startTime != null && !"".equals(startTime)) {
            String endTime = map.get("endTime");
            sql += " and startTime between ? and ? ";
            params.add(startTime);
            params.add(map.get("endTime"));
        }

        sql +=" order by communityId desc ";
//       根据分页
        String pn = map.get("pageNum");
        if (pn != null && !"".equals(pn)) {
            sql += " limit ?,?";
            int pageNum = Integer.parseInt(pn);
            int pageSize = Integer.parseInt(map.get("pageSize"));
            params.add((pageNum - 1) * pageSize);
            params.add(pageSize);
        }
//        查询
        Object obj[] = params.toArray();
        ResultSet resultSet = JDBCDruidUtil.query(sql, obj);
        while (true) {
            try {
                if (!resultSet.next()) break;
                Community community = new Community(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getDate(9),
                        resultSet.getInt(10),
                        resultSet.getInt(11),
                        resultSet.getString(12),
                        resultSet.getInt(13),
                        resultSet.getInt(14),
                        resultSet.getString(15)
                );
                list.add(community);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
//        关流
        JDBCDruidUtil.close();
        return list;
    }

    @Override
    public int selectCount(Map<String, String> map) {
        int count = 0;
        String sql = "select  count(1) from  community where 1=1 ";
        List params = new ArrayList<>();
//        动态sql
//        根据名字
        String communityName = map.get("communityName");
        if (communityName != null && !"".equals(communityName)) {
            sql += " and communityName like ? ";
            params.add("%" + communityName + "%");
        }
//        根据时间
        String startTime = map.get("startTime");
        if (startTime != null && !"".equals(startTime)) {
            sql += " and startTime between ? and ? ";
            params.add(startTime);
            params.add(map.get("endTime"));
        }
//        查询
        Object obj[] = params.toArray();
        ResultSet resultSet = JDBCDruidUtil.query(sql, obj);
        while (true) {
            try {
                if (!resultSet.next()) break;
                count = resultSet.getInt(1);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
//        关流
        JDBCDruidUtil.close();
        return count;
    }
}
