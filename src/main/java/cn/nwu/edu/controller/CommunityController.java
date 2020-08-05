package cn.nwu.edu.controller;

import cn.nwu.edu.entity.Community;
import cn.nwu.edu.service.ICommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    @Qualifier("communityService")
    ICommunityService communityService;

    @RequestMapping(value = "/query", produces = "application/json")
    public Community query(@RequestParam(value = "cid") Integer cid){
        return communityService.query(cid);
    }

    @RequestMapping(value = "/get_community_type", produces = "application/json")
    public List<String> getCommunityTypes(){
        return communityService.queryAllCommunityType();
    }

    @RequestMapping(value = "/get_all_community_info", produces = "application/json")
    public List<HashMap<String,Object>> getAllCommunityInfo(){
        return communityService.queryAllCommunityInfo();
    }

    @RequestMapping(value = "/get_member_count", produces = "application/json")
    public Integer getCount(Integer cid){
        return communityService.getCount(cid);
    }

    @RequestMapping("/getCommunities")
    public List<Community> getCommunities(Integer ctype){
        return communityService.getCommunities(ctype);
    }
}
