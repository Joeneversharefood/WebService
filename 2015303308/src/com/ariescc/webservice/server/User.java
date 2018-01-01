package com.ariescc.webservice.server;

import java.util.ArrayList;

public class User {

    public String username; // 用户名
    public String password; // 密码

    ArrayList<Matter> matterArrayList = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
