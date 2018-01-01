package com.ariescc.webservice.client;


import com.ariescc.webservice.server.IMatterMethod;
import com.ariescc.webservice.server.MatterMethodService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class client {

    static BufferedReader keyboard = new BufferedReader(new InputStreamReader(
            System.in));

    public static void main(String[] args) throws IOException, ParseException {

        while (true) {

            System.out.println("");

            System.out.println("登录请输入：login");
            System.out.println("注册请输入：register");
            System.out.print(">>");

            String command = keyboard.readLine();

            if (command.equals("login")) {

                System.out.println("--------登录---------");

                // 登录：输入用户名和密码
                System.out.print("请输入用户名：");
                String username = keyboard.readLine();

                System.out.print("请输入密码：");
                String password = keyboard.readLine();

                handleLogin(username, password);

            } else if (command.equals("register")) {

                System.out.println("--------注册---------");

                // 注册：输入用户名，密码，重复输入密码
                System.out.print("请输入新用户名：");
                String username = keyboard.readLine();

                // 直到输入一个可用的用户名为止
                while (!JudgeUserNameAvailable(username)) {

                    System.out.println("<Warning> 用户名已存在!请重新输入用户名！");
                    System.out.print("请输入新用户名：");

                    username = keyboard.readLine();

                }


                System.out.print("请输入密码：");
                String password = keyboard.readLine();

                System.out.print("请再次输入密码：");
                String reTypePassword = keyboard.readLine();

                // 判断两次密码是否输入的一致
                if (password.equals(reTypePassword)) {

                    handleRegister(username, password);

                } else {
                    System.out.println("两次密码输入的不一致！");
                    continue;
                }

            }

        }

    }

    /**
     * 判断用户名是否已存在
     * @param username
     * @return
     */
    private static boolean JudgeUserNameAvailable(String username) {

        MatterMethodService matterMethodService = new MatterMethodService();
        IMatterMethod soap = matterMethodService.getMatterMethodPort();

        return soap.JudgeUserNameAvailable(username);

    }

    /**
     * 注册新用户
     * @param username
     * @param password
     */
    private static void handleRegister(String username, String password) throws IOException, ParseException {

        MatterMethodService matterMethodService = new MatterMethodService();
        IMatterMethod soap = matterMethodService.getMatterMethodPort();

        String str = soap.register(username, password);

        System.out.println(str);

        // 打开菜单：添加事项、删除事项、查询事项、清空事项、退出登录
        OpenMenu(username);

    }

    /**
     * 展开菜单：添加事项、删除事项、查询事项、清空事项、退出登录
     *
     * 登录注册后已经保证此用户合法，只需传参 username 用于信息检索便可
     *
     * @param username 用户名
     */
    private static void OpenMenu(String username) throws IOException, ParseException {

        while (true) {
            System.out.println("-------欢迎使用--------");
            System.out.println("添加事项 -> add");
            System.out.println("查询事项 -> query");
            System.out.println("删除事项 -> delete");
            System.out.println("清空事项 -> clear");
            System.out.println("退出登录 -> quit");

            System.out.print(">>");

            String choose = keyboard.readLine();

            if (choose.equals("add")) {
                handleAdd(username);
            } else if (choose.equals("query")) {
                handleQuery(username);
            } else if (choose.equals("delete")) {
                handleDelete(username);
            } else if (choose.equals("clear")) {
                handleClear(username);
            } else if (choose.equals("quit")) {
                System.exit(1);
            } else {
                System.out.println("提示 ：请输入正确的命令！");
            }

        }
    }

    /**
     * 查询事项 -> 查找 给定时间间隔内的所有事项 -> 事项列表（开始时间、结束时间、描述）
     *
     * @param username 用户名
     */
    private static void handleQuery(String username) throws IOException {

        System.out.println("<查询事项>");
        System.out.println("提示：时间格式 2018-01-01");
        System.out.println("");

        System.out.print("[search]开始时间 >>");
        String searchStartTime = keyboard.readLine();
        // 判断输入时间格式是否符合要求
        while (!JudgeTimeFormatAvailable(searchStartTime)) {
            System.out.println("日期格式不正确，重新输入！");
            System.out.println("");
            System.out.print("[search]开始时间 >>");
            searchStartTime = keyboard.readLine();
        }

        System.out.print("[search]结束时间 >>");
        String searchEndTime = keyboard.readLine();
        // 判断输入时间格式是否符合要求
        while (!JudgeTimeFormatAvailable(searchEndTime)) {
            System.out.println("日期格式不正确，重新输入！");
            System.out.println("");
            System.out.print("[search]结束时间 >>");
            searchEndTime = keyboard.readLine();
        }

        MatterMethodService matterMethodService = new MatterMethodService();
        IMatterMethod soap = matterMethodService.getMatterMethodPort();

        System.out.println(soap.QueryItem(searchStartTime, searchEndTime, username));

    }

    /**
     * 清空所有事项
     * @param username 用户名
     */
    private static void handleClear(String username) {

        System.out.println("<清空事项>");
        System.out.println("");

        MatterMethodService matterMethodService = new MatterMethodService();
        IMatterMethod soap = matterMethodService.getMatterMethodPort();

        System.out.println(soap.ClearItem(username));

    }

    /**
     * 删除事项：根据 ID 删除
     * @param username
     */
    private static void handleDelete(String username) throws IOException {

        System.out.println("<删除事项>");
        System.out.println("");

        System.out.print("删除事项编号 >>");
        String itemId = keyboard.readLine();

        MatterMethodService matterMethodService = new MatterMethodService();
        IMatterMethod soap = matterMethodService.getMatterMethodPort();

        System.out.println(soap.DeleteItem(itemId, username));

    }

    /**
     * 新建事项
     * @param username 用户名
     */
    private static void handleAdd(String username) throws IOException, ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1, dt2;
        String startTime, endTime;

        // 直到输入的 结束日期 晚于 开始日期
        do {

            System.out.println("<添加事项>");
            System.out.println("提示：\n时间格式 2018-01-01\n开始时间 早于 结束时间");
            System.out.println("");
            System.out.print("开始时间 >>");
            startTime = keyboard.readLine();
            // 判断时间输入的格式是否正确：2018-01-01
            while (!JudgeTimeFormatAvailable(startTime)) {
                System.out.println("日期格式不正确，重新输入！");
                System.out.println("");
                System.out.print("开始时间 >>");
                startTime = keyboard.readLine();
            }

            System.out.print("结束时间 >>");
            endTime = keyboard.readLine();
            // 判断时间输入的格式是否正确：2018-01-01
            while (!JudgeTimeFormatAvailable(endTime)) {
                System.out.println("日期格式不正确，重新输入！");
                System.out.println("");
                System.out.print("结束时间 >>");
                endTime = keyboard.readLine();
            }

            dt1 = df.parse(startTime);
            dt2 = df.parse(endTime);

        } while (!dt1.before(dt2));

        System.out.print("事项内容 >>");
        String description = keyboard.readLine();

        MatterMethodService matterMethodService = new MatterMethodService();
        IMatterMethod soap = matterMethodService.getMatterMethodPort();

        System.out.println(soap.AddItem(startTime, endTime, description, username));

    }

    /**
     * 判断输入的日期字符串格式是否正确
     * @param date 时间
     * @return
     */
    private static boolean JudgeTimeFormatAvailable(String date) {

        String[] split = date.split("-");

        if (split.length != 3) {
            return false;
        }

        String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?" +
                "((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(" +
                "3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|" +
                "(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468]" +
                "[1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))" +
                "[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))" +
                "[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])" +
                "|(1[0-9])|(2[0-8]))))))";

        Pattern pat = Pattern.compile(rexp);

        Matcher mat = pat.matcher(date);

        boolean isDate = mat.matches();

        return isDate;

    }

    /**
     * 用户登录
     * @param username
     * @param password
     */
    private static void handleLogin(String username, String password) throws IOException, ParseException {

        MatterMethodService matterMethodService = new MatterMethodService();
        IMatterMethod soap = matterMethodService.getMatterMethodPort();

        if (soap.login(username, password)) {
            System.out.println(username + "登录成功！");

            // 打开菜单：添加事项、删除事项、查询事项、清空事项、退出登录
            OpenMenu(username);

        } else {
            System.out.println("登录失败！请检查用户名和密码是否正确！");
        }

    }

}
