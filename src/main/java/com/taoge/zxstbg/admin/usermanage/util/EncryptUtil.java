package com.taoge.zxstbg.admin.usermanage.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

    public static void main(String[] args) {

        //原始 密码
        String source = "admin123";
        //盐
        String salt = "111111";
        //散列次数
        int hashIterations = 2;
        //上边散列1次：f3694f162729b7d0254c6e40260bf15c
        //上边散列2次：36f2dfa24d0a9fa97276abbe13e596fc


        //构造方法中：
        //第一个参数：明文，原始密码
        //第二个参数：盐，通过使用随机数
        //第三个参数：散列的次数，比如散列两次，相当 于md5(md5(''))
        Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);

        String password_md5 =  md5Hash.toString();
        //System.out.println(password_md5);
        //第一个参数：散列算法
        SimpleHash simpleHash = new SimpleHash("md5", source, salt, hashIterations);
        System.out.println(simpleHash.toString());


    }


    public static String encryptWithMd5(String password){
        SimpleHash simpleHash = new SimpleHash("md5", password, null, 2);
        return simpleHash.toString();
    }

    public static String encryptWithMd5(String password,String salt){
        SimpleHash simpleHash = new SimpleHash("md5", password, salt, 2);
        return simpleHash.toString();
    }

    public static String EncodeByMd5ForWebtls(String str) {

        //确定计算方法
        MessageDigest md5= null;
        String newstr="";
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return newstr;
    }

}
