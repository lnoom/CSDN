package com.yu.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yu.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;
@Mapper
@Transactional(rollbackFor = Exception.class)
public interface UserMapper extends BaseMapper<User>{
}
