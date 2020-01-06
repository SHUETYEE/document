package com.itheima.document.config;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author 李靖宇
 * @Project document
 * @date 2020/1/4 12:27
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    public static Integer online=0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        online++;
        System.out.println(online);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        online--;
    }
}
