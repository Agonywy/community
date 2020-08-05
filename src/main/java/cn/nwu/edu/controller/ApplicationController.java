package cn.nwu.edu.controller;

import cn.nwu.edu.entity.Application;
import cn.nwu.edu.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    @Qualifier("applicationService")
    private IApplicationService applicationService;

    @RequestMapping("/add")
    public HashMap<String,Object> addApplication(Application application){
        HashMap<String,Object> message = new HashMap<>();
        message.put("message","fail");
        try{
            if(applicationService.addApplication(application)){
                message.put("message", "success");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }

    @RequestMapping("/get")
    public List<Application> getApplication(Integer cid){
        return applicationService.getApplication(cid);
    }

    //当社团管理员同意申请加入
    @RequestMapping("/yes")
    public HashMap<String, Object> yesApplication(Integer sid, Integer cid){
        //把学生加入社团中去
        //把状态置为1
        HashMap<String, Object> message = new HashMap<>();
        if(applicationService.yesApplication(sid,cid)){
            message.put("message","success");
        }else{
            message.put("message","fail");
        }
        return message;
    }
    //当社团管理员拒绝申请
    @RequestMapping("/no")
    public HashMap<String, Object> noApplication(Integer sid, Integer cid){
        //不做处理
        //把状态置为1即可
        HashMap<String, Object> message = new HashMap<>();
        if(applicationService.noApplication(sid,cid)){
            message.put("message","success");
        }else{
            message.put("message","fail");
        }
        return message;
    }

    //同意退出申请
    @RequestMapping("/exit")
    public HashMap<String, Object> exitApplication(Integer sid, Integer cid){
        HashMap<String, Object> message = new HashMap<>();
        if(applicationService.exitApplication(sid,cid)){
            message.put("message","success");
        }else{
            message.put("message","fail");
        }
        return message;
    }

    //拒绝退出申请
    @RequestMapping("/refuse")
    public HashMap<String, Object> refuseApplication(Integer sid, Integer cid){
        HashMap<String, Object> message = new HashMap<>();
        if(applicationService.refuseApplication(sid,cid)){
            message.put("message","success");
        }else{
            message.put("message","fail");
        }
        return message;
    }
}
