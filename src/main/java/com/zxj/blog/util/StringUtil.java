package com.zxj.blog.util;

public class StringUtil {

    public static Boolean isEmptyString(String strValue){
        return strValue == null && strValue.trim().equals("");
    }
}
