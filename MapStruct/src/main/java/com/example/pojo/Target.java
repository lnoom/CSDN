package com.example.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-31 11:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Target {
    private String targetId;
    private String targetName;
    private String targetIgnore;
    private String targetDate;
    private Double targetPrice;
}
