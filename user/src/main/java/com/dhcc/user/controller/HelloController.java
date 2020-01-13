package com.dhcc.user.controller;

/**
 * @author yzf
 * @create 2019-11-29 17:33
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.soap.SAAJResult;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String sayLogin(){

        return "login";
    }
}
