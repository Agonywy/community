package cn.nwu.edu.service;

import cn.nwu.edu.entity.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IStudentService {
    //查看个人全部信息
    public Student selectStudent(String sid);

    //查询社团信息
    public List<HashMap<String,Object>> selectCommunity(String sid);

    //消息列表
    public List<HashMap<String,Object>> selectMessage(String sid);

    public boolean setPassword(String newPassword, String sid);
}
