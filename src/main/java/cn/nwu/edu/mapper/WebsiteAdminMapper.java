package cn.nwu.edu.mapper;

import cn.nwu.edu.entity.Community;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebsiteAdminMapper {
    public List<Community> selectCommunity();
    public void deleteCommunity(Integer cid);
}
