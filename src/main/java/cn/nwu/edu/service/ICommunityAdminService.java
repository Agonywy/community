package cn.nwu.edu.service;

import cn.nwu.edu.entity.Student;

import java.util.List;

public interface ICommunityAdminService {
    public List<Student> queryMembersByCid(Integer cid);

    public Integer getNumberOfMemberByCid(Integer cid);

    public void deleteMember(Integer cid, Integer sid);
}
