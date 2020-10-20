package com.controller;

import java.util.HashMap;

/**
 * @author zhangyi
 * @date 2020/9/23 - 10:40
 **/
public class DebugTest {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(i);

        }

        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Tome");
        map.put("age", "12");
        map.put("school", "Tsinghua");
        map.put("major", "computer");

        String age = map.get("age");
        System.out.println("age" + age);

        map.remove("major");
        System.out.println(map);

    }
}
