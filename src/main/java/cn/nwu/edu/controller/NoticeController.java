package cn.nwu.edu.controller;

import cn.nwu.edu.entity.Notice;
import cn.nwu.edu.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    @Qualifier("noticeService")
    private INoticeService noticeService;


    @RequestMapping("/add")
    public HashMap<String, Object> addNotice(Notice notice){
        System.out.println(notice.toString());
        HashMap<String, Object> message = new HashMap<>();
        if(noticeService.addNotice(notice)){
            message.put("message","success");
        }else{
            message.put("message","fail");
        }

        return message;
    }

    @RequestMapping("/get")
    public List<Notice> showNotice(Integer cid){
        return noticeService.showNotice(cid);
    }
}
