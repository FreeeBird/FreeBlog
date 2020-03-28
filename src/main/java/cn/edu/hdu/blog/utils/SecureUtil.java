package cn.edu.hdu.blog.utils;

public class SecureUtil {

    public static String hideEmail(String email){
        int index = email.indexOf('@');
        if(index<0) return "";
        String before = email.substring(1,index-1);
        return email.replaceAll(before,"****");
    }


}
