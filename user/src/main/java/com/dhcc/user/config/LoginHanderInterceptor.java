package com.dhcc.user.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * @author yzf
 * @create 2020-01-13 14:53
 */
public class LoginHanderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //登录成功之后，应该有用户的session；
        //从session中取出
        Object loginUser = request.getSession().getAttribute("loginUser");

        if (loginUser == null){
            //没有登录
            request.setAttribute("msg","没有权限，请先登录");
            //未登录，则返回登录界面
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else {
            //已登录，放行请求
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
