package com.junithttpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class TestJHC {
    private String path;
    private String postUserNameKey;
    private String postUserNameValue;
    private String postPasswordKey;
    private String postPasswordValue;
    CloseableHttpClient httpClient;

    HttpPost httpPost;
    UrlEncodedFormEntity urlEncodedFormEntity;
    List<NameValuePair> params;
    CloseableHttpResponse response;


    public TestJHC(String path, String postUserNameKey, String postUserNameValue, String postPasswordKey, String postPasswordValue) {
        this.path = path;
        this.postUserNameKey = postUserNameKey;
        this.postUserNameValue = postUserNameValue;
        this.postPasswordKey = postPasswordKey;
        this.postPasswordValue = postPasswordValue;
    }

    @Parameterized.Parameters
    public static List<Object[]> paramters(){
        String path = "http://localhost:8080/book/allBook";
        String usernameKey = "lname";
        String usernameValue = "alen";
        String userPasswordKey = "lpwd";
        String userpasswordValue = "123456";
        return Arrays.asList(new Object[][] {{path, usernameKey, usernameValue, userPasswordKey, userpasswordValue}});

    }
    @Before
    public void setUp(){
        httpClient = HttpClients.createDefault();
        httpPost = new HttpPost(path);
        params = new ArrayList<NameValuePair>();
        System.out.println(path);
        System.out.println(postUserNameKey);
        System.out.println(postUserNameValue);
        System.out.println(postPasswordKey);
        System.out.println(postPasswordValue);
    }

    @Test
    public void testRegister(){
        params.add(new BasicNameValuePair(postUserNameKey, postUserNameValue));
        params.add(new BasicNameValuePair(postPasswordKey, postPasswordValue));

        try {
            urlEncodedFormEntity = new UrlEncodedFormEntity(params, "utf-8");
            httpPost.setEntity(urlEncodedFormEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if(entity != null){
                String str = EntityUtils.toString(entity, "utf-8");
                System.out.println(str);
            }

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated}catch blocke.printStackTrace();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch blocke.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch blocke.printStackTrace();
        }
    }
    @After
    public void setDown(){
        try {
            response.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
