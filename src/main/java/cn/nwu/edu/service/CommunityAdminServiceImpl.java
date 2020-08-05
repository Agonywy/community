package cn.nwu.edu.service;


import cn.nwu.edu.entity.Student;
import cn.nwu.edu.mapper.CommunityAdminMapper;
import cn.nwu.edu.mapper.CommunityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("communityAdminService")
public class CommunityAdminServiceImpl implements ICommunityAdminService {

    @Autowired
    CommunityAdminMapper communityAdminMapper;

    // 根据社团ID查询社团的所有成员
    @Override
    public List<Student> queryMembersByCid(Integer cid) {
        return communityAdminMapper.queryMembersByCid(cid);
    }

    // 根据社团ID查询社团的人员总数
    @Override
    public Integer getNumberOfMemberByCid(Integer cid) {
        return communityAdminMapper.getNumberOfMemberByCid(cid);
    }

    @Override
    public void deleteMember(Integer cid, Integer sid) {
        communityAdminMapper.deleteMember(cid,sid);
    }
}
