package com.yjf.entity;

import java.util.List;
import java.util.Map;

/**
 * @author 余俊锋
 * @date 2020/10/13 16:46
 * @Description
 */
public class Pojo {
    User user;
    List<User> userList;

    Map<String,String> map;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
