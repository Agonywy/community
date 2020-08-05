package cn.nwu.edu.service;

import cn.nwu.edu.entity.Community;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IWebsiteAdminService {
    public List<Community> selectCommunity();
    public List<Community> deleteCommunity(Integer cid);
}
