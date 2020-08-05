package cn.nwu.edu.service;

import cn.nwu.edu.entity.Student;
import cn.nwu.edu.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student selectStudent(String sid) {
        return studentMapper.selectStudent(sid);
    }

    @Override
    public List<HashMap<String, Object>> selectCommunity(String sid) {
        return studentMapper.selectCommunity(sid);
    }

    @Override
    public List<HashMap<String, Object>> selectMessage(String sid) {
        return studentMapper.selectMessage(sid);
    }

    @Override
    public boolean setPassword(String newPassword, String sid) {
        return studentMapper.setNewPassword(newPassword,sid);
    }
}
