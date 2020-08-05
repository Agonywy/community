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
public class WebsiteAdmin {
    private String wid; //网管id,账号
    private String wpassword;   //网管密码
}
