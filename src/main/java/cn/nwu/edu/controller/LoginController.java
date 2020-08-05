package cn.nwu.edu.controller;

import cn.nwu.edu.entity.CommunityAdmin;
import cn.nwu.edu.entity.LoginRequestInfo;
import cn.nwu.edu.entity.Student;
import cn.nwu.edu.entity.WebsiteAdmin;
import cn.nwu.edu.service.ILoginService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    @Qualifier("loginService")
    ILoginService loginService;
    private RequestDispatcher requestDispatcher;

    @RequestMapping("/login")
    public HashMap<String,Object> login(LoginRequestInfo loginRequestInfo, HttpServletResponse response, HttpSession session){
        HashMap<String, Object> message = new HashMap<>();
        if("student".equals(loginRequestInfo.getIdentify())){
            Student student = loginService.studentVerify(loginRequestInfo.getUsername(), loginRequestInfo.getPassword());
            if(student == null){
                message.put("message", "fail");
                return message;
            }

            addCookie(response,"sid", student.getSid());
            addCookie(response,"identity","student");
            addCookie(response,"name",student.getSname());
            session.setAttribute("identity","student");
            message.put("message", "success");
            message.put("identity", "student");
            message.put("name",student.getSname());
            return message;
        }else if("manager".equals(loginRequestInfo.getIdentify())){
            CommunityAdmin communityAdmin = loginService.communityAdminVerify(loginRequestInfo.getUsername(), loginRequestInfo.getPassword());
            if(communityAdmin == null){
                message.put("message", "fail");
                return message;
            }

            addCookie(response, "cid", communityAdmin.getCid().toString());
            addCookie(response,"identity","manager");
            addCookie(response, "name", communityAdmin.getCaname());
            session.setAttribute("identity","manager");
            message.put("message", "success");
            message.put("identity","manager");
            return message;
        }else if("admin".equals(loginRequestInfo.getIdentify())){
            WebsiteAdmin websiteAdmin = loginService.websiteAdminVerify(loginRequestInfo.getUsername(), loginRequestInfo.getPassword());
            if(websiteAdmin == null){
                message.put("message", "fail");
                return message;
            }

            addCookie(response, "wid", websiteAdmin.getWid());
            addCookie(response, "identity","admin");
            addCookie(response, "name", "管理员");
            session.setAttribute("identity","admin");
            message.put("message", "success");
            return message;
        }

        message.put("message", "fail");
        return message;
    }

    @RequestMapping("/logout")
    public void logout(HttpServletResponse response, HttpServletRequest request,HttpSession session) throws ServletException, IOException {
        session.invalidate();
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            System.out.println("没有cookie==============");
        } else {
            for(Cookie cookie : cookies){
                cookie.setValue(null);
                cookie.setMaxAge(0);// 立即销毁cookie
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        response.sendRedirect("/cm/html/index.html");
    }

    private void addCookie(HttpServletResponse response, String key, String value){
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookie);
    }
}
