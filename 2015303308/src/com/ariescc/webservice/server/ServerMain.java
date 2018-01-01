package com.ariescc.webservice.server;

import javax.xml.ws.Endpoint;

public class ServerMain {

    public static void main(String[] args) {
        IMatterMethod matterMethod = new MatterMethod();
        // 调用 EndPoint 的 publish 方法发布 webservice
        Endpoint.publish("http://localhost:8080/service", matterMethod);

        System.out.println("Webservice 暴露数据信息成功！");
    }

}
