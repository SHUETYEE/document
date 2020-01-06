package com.itheima.document.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2019-12-21 13:07:09
 */
public class User implements Serializable {
    private static final long serialVersionUID = -27993949923876768L;
    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private String phone;
    
    private String name;
    
    private Integer state;
    
    private Object sculpture;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Object getSculpture() {
        return sculpture;
    }

    public void setSculpture(Object sculpture) {
        this.sculpture = sculpture;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", sculpture=" + sculpture +
                '}';
    }
}