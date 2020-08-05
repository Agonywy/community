package cn.nwu.edu.service;

import cn.nwu.edu.entity.Community;
import cn.nwu.edu.mapper.CommunityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service(value = "communityService")
public class CommunityServiceImpl implements ICommunityService {

    @Autowired
    CommunityMapper communityMapper;

    // 根据社团ID查询对应的社团
    @Override
    public Community query(Integer cid) {
        return communityMapper.queryById(cid);
    }

    // 查询所有的社团类型
    @Override
    public List<String> queryAllCommunityType() {
        return communityMapper.queryAllCommunityType();
    }

    // 查询所有的社团名称及其对应的管理员
    @Override
    public List<HashMap<String,Object>> queryAllCommunityInfo() {
        return communityMapper.queryAllCommunityInfo();
    }

    @Override
    public Integer getCount(Integer cid) {
        return communityMapper.queryNumberOfMember(cid);
    }

    @Override
    public List<Community> getCommunities(Integer ctype) {
        return communityMapper.queryCommunitiesByCtype(ctype);
    }

}
