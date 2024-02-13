package com.example.mapper;


import com.example.pojo.Source;
import com.example.pojo.Target;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//定义MapStruct映射接口
@Mapper
public interface MapStructMapper {
    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);
    @BeanMapping(ignoreByDefault=true)
    @Mappings({
            @Mapping(source = "sourceId", target = "targetId"),
            @Mapping(source = "sourceName", target = "targetName"),
            @Mapping(source = "sourceDate", target = "targetDate",qualifiedByName = "stringToLocalDate"),
            @Mapping(source = "sourcePrice", target = "targetPrice",numberFormat="#.00"),
            @Mapping(source = "sourceIgnore", target = "targetIgnore", ignore = true)
    })
    Target sourceToTarget(Source source);
    // 自定义转换器的实现
    @Named("stringToLocalDate")
    default LocalDate stringToLocalDate(String sourceDate) {
        // 实现转换逻辑，这里假设日期格式为 "yyyy-MM-dd"
        return LocalDate.parse(sourceDate,
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
