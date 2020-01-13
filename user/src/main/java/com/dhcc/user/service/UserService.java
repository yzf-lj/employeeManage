package com.dhcc.user.service;

import com.dhcc.user.entities.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yzf
 * @create 2020-01-08 10:54
 */


public interface UserService {

    /**
     * 通过登录名查询用户
     * @param username username
     * @return User
     * */
    User getUserByUserName(String username) ;

}
