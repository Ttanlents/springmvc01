package com.yjf.entity;

import java.util.Arrays;
import java.util.Date;

/**
 * @author admin
 * @date 2020/10/13
 * @Description
 */
public class User {

    private String name;
    private String password;
    private Integer age;
    private Date date;
    private Integer[] hobbys;

    public Integer[] getHobbys() {
        return hobbys;
    }

    public void setHobbys(Integer[] hobbys) {
        this.hobbys = hobbys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", hobbys=" + Arrays.toString(hobbys) +
                '}';
    }
}
