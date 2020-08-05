package cn.nwu.edu.controller;

import cn.nwu.edu.entity.Application;
import cn.nwu.edu.entity.Student;
import cn.nwu.edu.service.IApplicationService;
import cn.nwu.edu.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    @Qualifier("studentService")
    private IStudentService studentService;

    @Autowired
    private IApplicationService applicationService;

   @RequestMapping("/getInfo")
    public Student selectStudent(String sid) {
       return studentService.selectStudent(sid);
    }

    @RequestMapping("/getCommunity")
    public List<HashMap<String,Object>> selectCommunity(String sid) {
        return studentService.selectCommunity(sid);
    }

    @RequestMapping("/getApplications")
    public List<HashMap<String,Object>> selectMessage(String sid) {
        List<HashMap<String,Object>> applications = applicationService.getStudentApplication(sid);
        return applications;
   }

    @RequestMapping("/setNewPassword")
    public HashMap<String,Object> setNewPassword(@RequestParam("sid") String sid, @RequestParam("newPassword") String newPassword, @RequestParam("oldPassword") String oldPassword){
        HashMap<String,Object> message = new HashMap<>();
        message.put("message","fail");
        Student student = studentService.selectStudent(sid);
        if(student.getPassword().equals(oldPassword)){
            if(studentService.setPassword(newPassword, sid))
                message.put("message","success");
        }

        return message;
    }
}
