package com.example.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-02-03 9:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;

    //最后访问时间
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastAccessTime;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;
}
