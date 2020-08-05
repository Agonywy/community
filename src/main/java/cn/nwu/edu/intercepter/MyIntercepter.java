package cn.nwu.edu.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MyIntercepter implements HandlerInterceptor {
    private static final HashMap<String, List<String>> directory = new HashMap<>();
    private static final List<String> guest = Arrays.asList(new String[]{
            "_admin_login.html","community_detail.html","index.html"
    });

    static {
        directory.put("student", Arrays.asList(new String[]{"join.html", "quit.html", "homepage.html", "change.html"}));
        directory.put("manager",Arrays.asList(new String[]{"application_deal.html","announce.html","caindex.html","change.html","members.html"}));
        directory.put("admin",Arrays.asList(new String[]{"change.html"}));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if(requestURI.indexOf("editClientIfo.action")>0){
            //说明处在编辑的页面
            HttpSession session = request.getSession();
            String identity = (String) session.getAttribute("identity");
            if(identity == null){
                request.getRequestDispatcher("/cm/html/login.html").forward(request,response);
                return false;
            }

            List<String> permitURL = directory.get(identity);
            if (!permitURL.contains(requestURI) && !guest.contains(requestURI)) {
                request.getRequestDispatcher("/cm/html/login.html").forward(request,response);
                return false;
            }
        }else{
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
