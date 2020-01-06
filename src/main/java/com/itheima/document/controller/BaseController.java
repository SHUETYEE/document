package com.itheima.document.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李靖宇
 * @Project document
 * @date 2019/12/21 13:39
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
public class BaseController {
    
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected Model model;
    protected Map<String,Object> map;

    @ModelAttribute
    public void model(HttpServletRequest request, HttpServletResponse response,HttpSession session,Model model) {
        this.request = request;
        this.response = response;
        this.session=session;
        this.model=model;
        this.map=new HashMap<>();
    }

}
