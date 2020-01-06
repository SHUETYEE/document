package com.itheima.document.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (File)实体类
 *
 * @author makejava
 * @since 2020-01-02 13:04:32
 */
public class File implements Serializable {
    private static final long serialVersionUID = -67944988587702178L;
    
    private Integer id;
    
    private String name;
    
    private String path;
    
    private String operator;
    
    private String type;

    private String size;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date uploadtime;


    public Integer getId() {
        return id;
    }

    public File setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public File setName(String name) {
        this.name = name;
        return this;
    }

    public String getPath() {
        return path;
    }

    public File setPath(String path) {
        this.path = path;
        return this;
    }

    public String getOperator() {
        return operator;
    }

    public File setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public String getSize() {
        return size;
    }

    public File setSize(String size) {
        this.size = size;
        return this;
    }

    public String getType() {
        return type;
    }

    public File setType(String type) {
        this.type = type;
        return this;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public File setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
        return this;
    }

}