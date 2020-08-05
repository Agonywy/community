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
@ToString
@Component
public class Application {
    private String sid;         //学生id
    private String sname;   //学生姓名
    private Integer cid;    //社团id
    private String reason;  //申请原因
    private String email;  //学生邮箱
    private String tele;    //学生电话
    private Integer status; //申请状态默认为0,表示申请没有处理
    private Date time;      //申请时间
    private Integer type;   //申请类型
}
