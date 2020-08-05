package cn.nwu.edu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ToString
public class CommunityAdmin {
    private String caid;    //社管id,账号
    private String caname;   //社管姓名
    private String capassword;  //社管密码
    private Integer cid;    //社团id,外键
}
