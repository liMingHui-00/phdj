package com.lmh.ph.dao.impl;

import com.lmh.ph.dao.StationsDao;
import com.lmh.ph.entity.Community;
import com.lmh.ph.entity.Stations;
import com.lmh.ph.util.JDBCDruidUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StationsDaoImpl implements StationsDao {
    @Override
    public int insert(Stations stations) {
        return 0;
    }

    @Override
    public int delete(int courierStationId) {
        return 0;
    }

    @Override
    public int update(Stations stations) {
        return 0;
    }

    @Override
    public List<Stations> selectAll(Map<String, String> map) {
        ArrayList<Stations> list = new ArrayList<>();
        String sql = "select * from  stations where 1=1 ";
        List params = new ArrayList<>();
//        根据驿站名字
        String courierStationName = map.get("courierStationName");
        if (courierStationName != null && !"".equals(courierStationName)) {
            sql += " and courierStationName like ? ";
            params.add("%" + courierStationName + "%");
        }
//      根据小区名字
        String communityName = map.get("communityName");
        if (communityName != null && !"".equals(communityName)) {
            sql += " and communityName like ? ";
            params.add("%" + communityName + "%");
        }
//        根据时间
        String startTime = map.get("startTime");
        if (startTime != null && !"".equals(startTime)) {

            sql += " and addTime between ? and ? ";
            params.add(startTime);
            params.add(map.get("endTime"));
        }
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
                Stations stations = new Stations(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getInt(4),
                resultSet.getInt(5),
                resultSet.getDate(6),
                resultSet.getString(7),
                resultSet.getString(8),
                resultSet.getString(9),
                resultSet.getString(10),
                resultSet.getInt(11),
                resultSet.getString(12),
                resultSet.getInt(13)
           );
                list.add(stations);
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
        String sql = "select  count(1) from  stations where 1=1 ";
        List params = new ArrayList<>();
//        动态sql
//        根据驿站名字
        String courierStationName = map.get("courierStationName");
        if (courierStationName != null && !"".equals(courierStationName)) {
            sql += " and courierStationName like ? ";
            params.add("%" + courierStationName + "%");
        }
//      根据小区名字
        String communityName = map.get("communityName");
        if (communityName != null && !"".equals(communityName)) {
            sql += " and communityName like ? ";
            params.add("%" + communityName + "%");
        }
//        根据时间
        String startTime = map.get("startTime");
        if (startTime!=null&& !"".equals(startTime)){
            sql+=" and addTime between ? and ? ";
            params.add(startTime);
            params.add(map.get("endTime"));
        }
//        查询
        Object obj[] = params.toArray();
        ResultSet resultSet = JDBCDruidUtil.query(sql, obj);
        while (true){
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
