package com.junithttpclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyi
 * @date 2020/9/23 - 16:14
 **/
public class PostTest {

    //Post请求
    public static void main(String[] args) throws IOException {
        //1. 准备URL
        String url = "https://www.jianshu.com/";

        //2. 准备参数
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("username","xxxxx");
        paramsMap.put("password","xxxxx");

        //3.使用自己的postman发包
        String result = HttpTool.post(url, (HashMap<String, String>) paramsMap);
        System.out.println(result);


    }
}
