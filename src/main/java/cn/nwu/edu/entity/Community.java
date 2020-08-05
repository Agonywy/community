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
public class Community {
    private Integer cid;    //社团id
    private String cname;   //社团名称
    private Integer ctype;  //社团类型
    private String cdesc;   //社团简介
    private String cfeature;//社团特色
    private String ctid;   //社团类型id,外键
    private Date createtime;    //社团创建时间
    private String principal;   //社团部长
}
