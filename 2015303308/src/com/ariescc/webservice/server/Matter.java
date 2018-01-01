package com.ariescc.webservice.server;

public class Matter {

    public String description; // 事项描述
    public String startTime; // 开始时间
    public String endTime; // 结束时间
    public String userId; // 用户

    public Matter(String startTime, String endTime, String description, String userId) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.userId = userId;
    }

}
