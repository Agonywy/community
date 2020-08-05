package cn.nwu.edu.controller;

import cn.nwu.edu.entity.Application;
import cn.nwu.edu.entity.CommunityAdmin;
import cn.nwu.edu.entity.Student;
import cn.nwu.edu.service.ICommunityAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/community_admin")
public class CommunityAdminController {

    @Autowired
    @Qualifier("communityAdminService")
    ICommunityAdminService communityAdminService;

    @RequestMapping(value = "/getMembers", produces = "application/json")
    @ResponseBody
    public List<Student> getMembers(@RequestParam("cid") Integer cid){
        return communityAdminService.queryMembersByCid(cid);
    }

    @RequestMapping(value="/deleteMember")
    public void deleteMembers(@RequestParam("cid") Integer cid, @RequestParam("sid") Integer sid){
        communityAdminService.deleteMember(cid,sid);
    }
}
