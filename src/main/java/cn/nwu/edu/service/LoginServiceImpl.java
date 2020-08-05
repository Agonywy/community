package cn.nwu.edu.service;

import cn.nwu.edu.entity.CommunityAdmin;
import cn.nwu.edu.entity.Student;
import cn.nwu.edu.entity.WebsiteAdmin;
import cn.nwu.edu.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {
    @Autowired
    LoginMapper loginMapper;

    @Override
    public Student studentVerify(String sid, String password) {
        Student student = loginMapper.queryStudentBySid(sid);
        if(student == null)
            return null;
        if(!student.getPassword().equals(password))
            return null;
        return student;
    }

    @Override
    public CommunityAdmin communityAdminVerify(String caid, String password) {
        CommunityAdmin communityAdmin = loginMapper.queryCommunityAdminByCaid(caid);
        if(communityAdmin == null)
            return null;
        if(!communityAdmin.getCapassword().equals(password))
            return null;
        return communityAdmin;
    }

    @Override
    public WebsiteAdmin websiteAdminVerify(String wid, String password) {
        WebsiteAdmin websiteAdmin = loginMapper.queryWebsiteAdminByWid(wid);
        if(websiteAdmin == null)
            return null;
        if(!websiteAdmin.getWpassword().equals(password))
            return null;
        return websiteAdmin;
    }
}
