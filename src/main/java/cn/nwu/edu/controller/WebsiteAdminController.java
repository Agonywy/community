package cn.nwu.edu.controller;

import cn.nwu.edu.entity.Community;
import cn.nwu.edu.service.IWebsiteAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/websiteAdmin")
public class WebsiteAdminController {

    @Autowired
    @Qualifier("websiteAdminService")
    private IWebsiteAdminService websiteAdminService;

    //向网络管理员返回所有社团信息
    @RequestMapping("/selectCommunity")
    public List<Community> selectCommunity(){
        return websiteAdminService.selectCommunity();
    }

    //删除社团
    @RequestMapping("/deleteCommunity")
    public List<Community> deleteCommunity(Integer cid){
        return websiteAdminService.deleteCommunity(cid);
    }

}
