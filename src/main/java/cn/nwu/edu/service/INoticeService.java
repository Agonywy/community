package cn.nwu.edu.service;

import cn.nwu.edu.entity.Notice;

import java.util.List;

public interface INoticeService {
    public boolean addNotice(Notice notice);
    public List<Notice> showNotice(Integer cid);
}
