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
public class Student {
    private String sid; //学号id,账号
    private String sname;    //学生姓名
    private String password; //学生密码
    private String tele;    //学生电话
    private String email;   //学生邮箱
}
