package com.xu.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5 {

    public static void main(String[] args) {
        String password = "123456";

        //散列两次 加盐
        String p4 = new Md5Hash(password, "zhangsan北京", 2).toString();
        System.out.println("p4 = " + p4);

        String p5 = new Md5Hash(password, "lisi武汉", 2).toString();
        System.out.println("p5 = " + p5);

    }
}
