package cn.nwu.edu.service;

import cn.nwu.edu.entity.CommunityAdmin;
import cn.nwu.edu.entity.Student;
import cn.nwu.edu.entity.WebsiteAdmin;

public interface ILoginService {

    public Student studentVerify(String sid, String password);

    public CommunityAdmin communityAdminVerify(String caid, String password);

    public WebsiteAdmin websiteAdminVerify(String wid, String password);
}
