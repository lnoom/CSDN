package com.yu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-02-03 15:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int age;
    private String name;
    private Phone phone;
    private List<String> list;
    private List<Phone> phones;
    private Set<String> set;
    private Map<String, Phone> map;
    private int[] arr;
    private Properties properties;
}
