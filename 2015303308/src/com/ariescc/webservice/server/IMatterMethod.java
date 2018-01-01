package com.ariescc.webservice.server;

import javax.jws.WebService;

@WebService
public interface IMatterMethod {

    String sayHi(String name);

    // 用户注册、添加项目、查询项目、删除项目、清空项目

    // 用户注册
    String register(String username, String password);

    // 判断用户名是否可以创建：数据表内是否已存在该用户名
    boolean JudgeUserNameAvailable(String username);

    // 用户登录
    boolean login(String username, String password);

    // 添加事项
    String AddItem(String startTime, String endTime, String description, String username);

    // 查询事项
    String QueryItem(String searchStartTime, String searchEndTime, String username);

    // 删除事项：根据事项编号
    String DeleteItem(String itemId, String username);

    // 清空事项
    String ClearItem(String username);

}
