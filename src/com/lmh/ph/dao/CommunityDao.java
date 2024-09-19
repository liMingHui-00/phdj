package com.lmh.ph.dao;

import com.lmh.ph.entity.Community;

import java.util.List;
import java.util.Map;

public interface CommunityDao {
    // 增加 删除 修改  查询  查询总条数
    public int insert(Community community);
    public int delete(int communityId);
    public int update(Community community);
    public List<Community> selectAll(Map<String,String> map);
    public int selectCount(Map<String,String> map);
}
