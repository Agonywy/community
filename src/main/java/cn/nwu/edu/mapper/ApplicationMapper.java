package cn.nwu.edu.mapper;

import cn.nwu.edu.entity.Application;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ApplicationMapper {
    //添加申请到数据库
    public boolean addApplication(Application application);

    //学生查看自己的申请列表
    public List<HashMap<String,Object>> getStudentApplication(String sid);

    //社团id,标记获取自己社团的申请列表
    public List<Application> getApplication(Integer cid);

    //通过申请
    public boolean yesApplication(@Param("sid")Integer sid, @Param("cid") Integer cid);

    //添加学生
    public boolean addStudent(@Param("sid")Integer sid, @Param("cid")Integer cid);

    public boolean noApplication(@Param("sid")Integer sid, @Param("cid")Integer cid);

    public boolean exitApplication(@Param("sid")Integer sid, @Param("cid")Integer cid);

    public boolean refuseApplication(@Param("sid")Integer sid, @Param("cid")Integer cid);

    public boolean deleteStudent(@Param("sid")Integer sid, @Param("cid")Integer cid);
}
