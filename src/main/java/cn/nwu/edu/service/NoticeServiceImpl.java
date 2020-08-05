package cn.nwu.edu.service;

import cn.nwu.edu.entity.Notice;
import cn.nwu.edu.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements INoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public boolean addNotice(Notice notice) {
        return noticeMapper.addNotice(notice);
    }

    @Override
    public List<Notice> showNotice(Integer cid) {
        return noticeMapper.showNotice(cid);
    }
}
