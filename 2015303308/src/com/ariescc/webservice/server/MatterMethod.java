package com.ariescc.webservice.server;

import javax.jws.WebService;
import java.text.ParseException;
import java.util.Date;

@WebService(endpointInterface = "com.ariescc.webservice.server.IMatterMethod")
public class MatterMethod implements IMatterMethod {

    ServiceHandler serviceHandler = new ServiceHandler();

    @Override
    public String sayHi(String name) {
        return name + "现在时间：" + new Date();
    }

    @Override
    public String register(String username, String password) {
        return serviceHandler.CreateNewAccount(username, password);
    }

    @Override
    public boolean JudgeUserNameAvailable(String username) {
        return serviceHandler.JudgeUserNameAvailable(username);
    }

    @Override
    public boolean login(String username, String password) {
        return serviceHandler.JudgeUserAvailable(username, password);
    }

    @Override
    public String AddItem(String startTime, String endTime, String description, String username) {
        return serviceHandler.AddItem(startTime, endTime, description, username);
    }

    @Override
    public String QueryItem(String searchStartTime, String searchEndTime, String username) {
        try {
            return serviceHandler.QueryItemFromStartToEnd(searchStartTime, searchEndTime, username);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "程序错误！";
    }

    @Override
    public String DeleteItem(String itemId, String username) {
        return serviceHandler.DeleteItem(itemId, username);
    }

    @Override
    public String ClearItem(String username) {
        return serviceHandler.ClearItem(username);
    }


}
