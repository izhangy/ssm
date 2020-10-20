package com.junithttpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author zhangyi
 * @date 2020/9/23 - 16:07
 **/
public class GetTest {

    public static void main(String[] args) throws IOException {
        //get请求

        //1.请求地址
        String url = "http://localhost:8080/book/allBook";

        //2.请求方式  Get--》创建get请求
        HttpGet get = new HttpGet(url);

        //3.准备一个发包客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //4.通过客户端发送包  -->响应
        CloseableHttpResponse response = httpClient.execute(get); //响应报文

        //5.关注响应内容
        //1) 状态行
        StatusLine statusLine = response.getStatusLine();

        System.out.println(statusLine.getProtocolVersion());
        System.out.println(statusLine.getReasonPhrase());
        System.out.println(statusLine.getStatusCode());

        //2) 响应头
        Header[] headers = response.getAllHeaders();
        for (Header header : headers) {
            System.out.println(header.getName() + ":" + header.getValue());
        }


        //3) 响应体
        HttpEntity entity = response.getEntity();
        //把响应体转换为字符串，打印输出
        System.out.println(EntityUtils.toString(entity));

    }


}
