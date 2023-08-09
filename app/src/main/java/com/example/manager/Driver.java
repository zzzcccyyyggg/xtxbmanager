package com.example.manager;

// 更新 Driver 类，删除审核状态相关内容
public class Driver {
    private String name;
    private String phoneNumber;

    public Driver(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

