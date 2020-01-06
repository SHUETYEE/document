package com.itheima.document.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 李靖宇
 * @Project document
 * @date 2019/12/20 20:10
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@Controller
public class RoutleController extends  BaseController{

    @RequestMapping
    public String login(){
        return "login";
    }

    @RequestMapping("student")
    public String user(){
        return "student";
    }

    @RequestMapping("file")
    public String file(){
        return "file";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("me")
    public String me(){
        return "me";
    }

    @RequestMapping("logout")
    public String logout() {
        session.setAttribute("user",null);
        return "redirect:";
    }

    @RequestMapping("change")
    public String change(){
        return "login";
    }

    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }


    @RequestMapping("system")
    public String system(){
        return "system";
    }

    @RequestMapping("log")
    public String log(){
        return "log";
    }

}
