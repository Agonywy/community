package cn.nwu.edu.service;

import cn.nwu.edu.entity.Community;

import java.util.HashMap;
import java.util.List;

public interface ICommunityService {

    public Community query(Integer cid);

    public List<String> queryAllCommunityType();

    public List<HashMap<String,Object>> queryAllCommunityInfo();

    public Integer getCount(Integer cid);

    public List<Community> getCommunities(Integer ctype);
}
