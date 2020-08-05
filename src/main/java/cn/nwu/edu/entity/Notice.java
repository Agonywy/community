package cn.nwu.edu.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ToString
public class Notice {
    private Integer id; //公告id
    private Date time;  //发布公告时间
    private Integer cid;    //社团id
    private String text;    //公告内容
    private String title;   //公告标题
}
