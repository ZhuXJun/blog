package com.zxj.blog.util;

import java.util.Random;

public class StringUtil {

    public static Boolean isEmptyString(String strValue){
        return strValue == null && strValue.trim().equals("");
    }

    //可以指定字符串的某个位置是什么范围的值
    public static String getRandomString2(int length){
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(3);
            long result=0;
            switch(number){
                case 0:
                    result=Math.round(Math.random()*25+65);
                    sb.append((char) result);
                    break;
                case 1:
                    result=Math.round(Math.random()*25+97);
                    sb.append((char) result);
                    break;
                case 2:
                    sb.append(new Random().nextInt(10));
                    break;
            }
        }
        return sb.toString();
    }
}
