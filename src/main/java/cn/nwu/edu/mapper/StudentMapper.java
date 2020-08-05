package cn.nwu.edu.mapper;

import cn.nwu.edu.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface StudentMapper {
    //查看个人全部信息
    public Student selectStudent(String sid);

    //查询社团信息
    public List<HashMap<String,Object>> selectCommunity(String sid);

    //消息列表
    public List<HashMap<String,Object>> selectMessage(String sid);

    public boolean setNewPassword(@Param("newPassword") String password,@Param("sid") String sid);
}
