package com.junithttpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author When all else is lost the future still remains.
 * @date 2020/9/23 - 17:37
 **/
public class HttpTool {

    public static String post(String url, HashMap<String, String> paramsMap) throws IOException {
        HttpPost post = new HttpPost(url);

        //参数
        List<NameValuePair> parameters = new ArrayList<>();
        Set<String> keyset = paramsMap.keySet();
        for (String key : keyset) {
            //每个键值对包装成名值对
            parameters.add(new BasicNameValuePair(key, paramsMap.get(key)));
        }

        post.setEntity(new UrlEncodedFormEntity(parameters));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(post);

        HttpEntity entity = response.getEntity();
        String entityString = EntityUtils.toString(entity);
        return entityString;

    }
}
