package com.example.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-31 11:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Source {
    private String sourceId;
    private String sourceName;
    private String sourceIgnore;
    private Date sourceDate;
    private Double sourcePrice;
}
