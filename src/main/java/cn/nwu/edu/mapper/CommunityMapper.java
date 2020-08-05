package cn.nwu.edu.mapper;

import cn.nwu.edu.entity.Community;
import cn.nwu.edu.entity.Notice;
import cn.nwu.edu.entity.Student;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.ComponentUI;
import java.util.HashMap;
import java.util.List;

@Repository
public interface CommunityMapper {

    public Community queryById(Integer cid);

    public List<String> queryAllCommunityType();

    public List<HashMap<String,Object>> queryAllCommunityInfo();

    public Integer queryNumberOfMember(Integer cid);

    public List<Community> queryCommunitiesByCtype(Integer ctype);
}
