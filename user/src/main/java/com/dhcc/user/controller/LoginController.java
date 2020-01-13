package com.dhcc.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dhcc.user.mapper.UserMapper;
import com.dhcc.user.entities.User;
import com.dhcc.user.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author yzf
 * @create 2019-12-02 9:31
 */


@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Model model,
                        Map<String, Object> map, HttpSession session) {
        //1.从数据库中取出存入的用户名和密码

        User user = userService.getUserByUserName(username);
        if (user != null) {
            String userName = user.getUsername();
            String pwd = user.getPassword();
            if (userName.equals(username) && pwd.equals(password)) {
                session.setAttribute("loginUser", username);
                return "dashboard";
            }
            else {
                //未登录成功，没登录成功,返回登录页面，在前台显示错误信息
                map.put("msg", "用户名或密码错误");
                return "login";
            }
        } else {
            //未登录成功，没登录成功,返回登录页面，在前台显示错误信息
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }
}



