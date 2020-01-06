package com.itheima.document.controller;

import com.itheima.document.config.MyHttpSessionListener;
import com.itheima.document.entity.User;
import com.itheima.document.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2019-12-21 13:07:09
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


    @RequestMapping("/login")
    public Map<String, Object> selectOne(@RequestBody User user) {
        map.clear();
        User user1=userService.findByName(user);
        if (!user1.getPassword().trim().equals(user.getPassword().trim())){
            map.put("msg",0);
        }
        session.setAttribute("user",user1);
        session.setAttribute("online", new MyHttpSessionListener());
        return map;
    }

    @RequestMapping("/check")
    public Map<String, Object> check(@RequestBody User user) {
        map.clear();
        User user1=userService.findByName(user);
        if (null==user1){
            map.put("msg",1);
        }else if ( user1.getState()==0){
            map.put("msg", 0);
        }
        return map;
    }


}