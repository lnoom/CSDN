package com.example.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-31 9:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String password;
    @JSONField(format="yyyy-MM-dd")
    private Date date;
}
