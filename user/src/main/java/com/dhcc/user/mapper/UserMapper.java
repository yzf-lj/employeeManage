package com.dhcc.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dhcc.user.entities.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author yzf
 * @create 2019-12-05 15:13
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
