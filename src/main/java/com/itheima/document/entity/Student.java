package com.itheima.document.entity;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2020-01-01 14:00:55
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 839353368493025688L;
    
    private Integer id;
    
    private String sno;
    
    private String name;
    
    private String major;
    
    private String grade;
    
    private String college;
    
    private String gander;
    
    private String idcard;

    public Student(){

    }

    public Student(Object [] values){
        this.sno=values[0].toString();
        this.name=values[1].toString();
        this.major=values[2].toString();
        this.grade=values[3].toString();
        this.college=values[4].toString();
        this.gander=values[5].toString();
        this.idcard=values[6].toString();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", college='" + college + '\'' +
                ", gander='" + gander + '\'' +
                ", idcard='" + idcard + '\'' +
                '}';
    }
}