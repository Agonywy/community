package cn.nwu.edu.mapper;

import cn.nwu.edu.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityAdminMapper {

    public List<Student> queryMembersByCid(Integer cid);

    public Integer getNumberOfMemberByCid(Integer cid);

    public void deleteMember(@Param("cid") Integer cid, @Param("sid") Integer sid);
}
