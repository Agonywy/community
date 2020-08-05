package cn.nwu.edu.service;

import cn.nwu.edu.entity.Application;
import cn.nwu.edu.entity.Student;
import cn.nwu.edu.mapper.ApplicationMapper;
import cn.nwu.edu.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("applicationService")
public class ApplicationServiceImpl implements IApplicationService {

    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private StudentMapper studentMapper;
    //添加学生申请
    @Override
    public boolean addApplication(Application application) {
        Student student = studentMapper.selectStudent(application.getSid());
        application.setSname(student.getSname());
        if(application.getType() == 1) {
            application.setEmail(student.getEmail());
            application.setTele(student.getTele());
        }
        return applicationMapper.addApplication(application);
    }

    //学生获取自己的申请列表
    @Override
    public List<HashMap<String,Object>> getStudentApplication(String sid) {
        return applicationMapper.getStudentApplication(sid);
    }

    //社团管理员页面获取社团的申请列表
    @Override
    public List<Application> getApplication(Integer cid) {
        return applicationMapper.getApplication(cid);
    }
    //申请加入社团通过
    @Override
    public boolean yesApplication(Integer sid,Integer cid) {
        return applicationMapper.yesApplication(sid, cid) && applicationMapper.addStudent(sid,cid);
    }
    //通过则添加信息到学生--社团表

    //申请加入社团不通过
    @Override
    public boolean noApplication(Integer sid,Integer cid) {
        return applicationMapper.noApplication(sid,cid);
    }
    //申请退出通过
    @Override
    public boolean exitApplication(Integer sid, Integer cid) {
        return applicationMapper.exitApplication(sid, cid)&&
        applicationMapper.deleteStudent(sid,cid);
    }
    //申请退出不通过
    @Override
    public boolean refuseApplication(Integer sid, Integer cid) {
        return applicationMapper.refuseApplication(sid, cid);
    }
}
