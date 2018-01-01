package com.ariescc.webservice.server;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ServiceHandler {

    // MatterTable 里存有 UserId

    // 存储所有用户信息
    ArrayList<User> UserTable = new ArrayList<>();

    // 存储所有的事项信息
    ArrayList<Matter> MatterTable = new ArrayList<>();


    /**
     * 判断用户是否登录成功
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public boolean JudgeUserAvailable(String username, String password) {

        // 查询 UserTable
        for (User user : UserTable) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 创建新用户
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public String CreateNewAccount(String username, String password) {

        User user = new User(username, password);

        UserTable.add(user);

        return "【注册成功！\n" + username + "已登录！】";

    }

    /**
     * 判断该用户名是否可以创建
     * @param username
     * @return
     */
    public boolean JudgeUserNameAvailable(String username) {

        for (User user : UserTable) {
            if (user.username.equals(username)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用户 username 创建新的事项
     *
     * 一定存在 username
     * @param startTime 事项开始时间
     * @param endTime 事项结束时间
     * @param description 事项描述
     * @param username 用户名
     * @return
     */
    public String AddItem(String startTime, String endTime, String description, String username) {

        // 查询用户
        int userId = QueryUserIdByName(username);

        // 创建事项
        Matter matter = new Matter(startTime, endTime, description, String.valueOf(userId));

        MatterTable.add(matter);

        return "【事项创建成功】";

    }

    /**
     * 通过用户名查询 userId
     * @param username 用户名
     * @return
     */
    private int QueryUserIdByName(String username) {

        for (int i = 0; i < UserTable.size(); i++) {
            if (UserTable.get(i).username.equals(username)) {
                return i;
            }
        }

        // 未查询该用户
        return -1;

    }

    /**
     * 查询搜索时间区间内该用户的所有事项
     * @param searchStartTime 搜索开始时间
     * @param searchEndTime 搜索结束时间
     * @param username 用户名
     * @return
     */
    public String QueryItemFromStartToEnd(String searchStartTime, String searchEndTime,
                                          String username) throws ParseException {

        String output = "-----------------------------------------\n";

        // 查询用户
        int userId = QueryUserIdByName(username);

        boolean flag = false;

        int cnt = 0;

        // 查询事项列表：通过 userId
        for (Matter matter : MatterTable) {

            if (Integer.parseInt(matter.userId) != userId) {
                continue;
            }

            if (JudgeMatterInBoundary(matter.startTime, matter.endTime, searchStartTime, searchEndTime)) {
                output += "事项编号：" + cnt + " " + "开始时间：" + matter.startTime + " " + "结束时间：" + matter.endTime +
                        " " + "事项内容：" + matter.description + "\n";
                flag = true;
            }
            cnt++;
        }

        if (flag) {
            return "***查询结果：***\n" + output;
        } else {
            return "***查询结果：***\n【该用户事项列表为空】";
        }

    }

    /**
     * 判断该事项是否在搜索时间的范围内
     * @param startTime 事项开始时间
     * @param endTime 事项结束时间
     * @param searchStartTime 事项搜索开始时间
     * @param searchEndTime 事项搜索结束时间
     * @return
     */
    private boolean JudgeMatterInBoundary(String startTime, String endTime,
                                          String searchStartTime, String searchEndTime) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Date dStartTime = df.parse(startTime);
        Date dEndTime = df.parse(endTime);
        Date dSearchStartTime = df.parse(searchStartTime);
        Date dSearchEndTime = df.parse(searchEndTime);

        if ((dSearchStartTime.before(dStartTime) && dEndTime.before(dSearchEndTime)) ||
                (startTime.equals(searchStartTime) && dEndTime.before(dSearchEndTime)) ||
                (dSearchStartTime.before(dStartTime) && endTime.equals(searchEndTime)) ||
                (startTime.equals(searchStartTime) && endTime.equals(searchEndTime))) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 根据事项编号删除事项
     * @param itemId 事项编号
     * @param username 用户名
     * @return
     */
    public String DeleteItem(String itemId, String username) {

        // 查询用户
        int userId = QueryUserIdByName(username);

        // 事项编号数组越界
        if (MatterTable.size() <= Integer.parseInt(itemId)) {
            return "【未找到该编号的事项】";
        }

        // 该事项不由该用户创建
        if (Integer.parseInt(MatterTable.get(Integer.parseInt(itemId)).userId) != userId) {
            return "【未找到该编号的事项】";
        } else {
           if (MatterTable.remove(MatterTable.get(Integer.parseInt(itemId)))) {
               return "【事项删除成功】";
           } else {
               return "【事项删除失败】";
           }
        }

    }

    /**
     * 清空该用户所有的事项
     * @param username 用户名
     * @return
     */
    public String ClearItem(String username) {

        // 查询用户
        int userId = QueryUserIdByName(username);

        MatterTable.removeIf(matter -> Integer.parseInt(matter.userId) == userId);

        return "【事项清空成功】";

    }
}
