package cn.nwu.edu.service;

import cn.nwu.edu.entity.Community;
import cn.nwu.edu.mapper.WebsiteAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("websiteAdminService")
public class WebsiteAdminServiceImpl implements IWebsiteAdminService {

    @Autowired
    private WebsiteAdminMapper websiteAdminMapper;
    @Override
    public List<Community> selectCommunity() {
        return websiteAdminMapper.selectCommunity();
    }

    @Override
    public List<Community> deleteCommunity(Integer cid) {
        websiteAdminMapper.deleteCommunity(cid);
        return websiteAdminMapper.selectCommunity();
    }
}
