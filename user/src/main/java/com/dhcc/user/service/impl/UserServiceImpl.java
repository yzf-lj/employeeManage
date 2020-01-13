package com.dhcc.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.dhcc.user.entities.User;
import com.dhcc.user.mapper.UserMapper;
import com.dhcc.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yzf
 * @create 2020-01-09 17:35
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String username) {
        User user = new User();
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.lambda().eq(User::getUsername,username);
        user = userMapper.selectOne(queryWrapper);
        return user;
    }
}
