package cn.nwu.edu.mapper;

import cn.nwu.edu.entity.CommunityAdmin;
import cn.nwu.edu.entity.Student;
import cn.nwu.edu.entity.WebsiteAdmin;

import java.util.List;

public interface LoginMapper {

    public Student queryStudentBySid(String sid);

    public CommunityAdmin queryCommunityAdminByCaid(String caid);

    public WebsiteAdmin queryWebsiteAdminByWid(String wid);
}
