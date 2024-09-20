package com.lmh.ph.dao;

import com.lmh.ph.entity.Community;
import com.lmh.ph.entity.Stations;

import java.util.List;
import java.util.Map;

public interface StationsDao {
    // 增加 删除 修改  查询  查询总条数
    public int insert(Stations stations);
    public int delete(int courierStationId);
    public int update(Stations stations);
    public List<Stations> selectAll(Map<String,String> map);
    public int selectCount(Map<String,String> map);
}
