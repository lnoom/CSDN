package com.yu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-02-03 15:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    private double price;
    private String name;
    private String password;
    private String path;
}