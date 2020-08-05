package cn.nwu.edu.mapper;

import cn.nwu.edu.entity.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {

    public boolean addNotice(Notice notice);

    public List<Notice> showNotice(Integer cid);
}