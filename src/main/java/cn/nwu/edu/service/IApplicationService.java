package cn.nwu.edu.service;

import cn.nwu.edu.entity.Application;

import java.util.HashMap;
import java.util.List;

public interface IApplicationService {
    //添加申请到数据库
    public boolean addApplication(Application application);
    //学生查看自己的申请列表
    public List<HashMap<String,Object>> getStudentApplication(String sid);
    //社团id,标记获取自己社团的申请列表
    public List<Application> getApplication(Integer cid);
    //通过申请
    public boolean yesApplication(Integer sid, Integer cid);
    public boolean noApplication(Integer sid, Integer cid);
    //同意申请退出
    public boolean exitApplication(Integer sid, Integer cid);
    //拒绝申请退出
    public boolean refuseApplication(Integer sid, Integer cid);

}
