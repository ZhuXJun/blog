package com.zxj.blog.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 系统随机数生成辅助类
 *
 * @author liqi
 */
public class RandomUtil {

    public static String getUuid(String prefix){
        String uuid = prefix;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        uuid += sdf.format(new Date());
        uuid += GetRandomString(6);
        return uuid;
    }
    public static String GetRandomString(Integer length)
    {
        return GetRandomString(length, Integer.valueOf(2));
    }
    public static String GetRandomString(Integer length, Integer type)
    {
        StringBuffer randomCode = new StringBuffer();

        for (int i = 0; i < length.intValue(); i++) {
            switch (type.intValue()) {
                case 1:
                    randomCode.append(getRandomInteger());
                    break;
                case 2:
                    randomCode.append(getRandomUpperCase());
                    break;
                case 3:
                    randomCode.append(getRandomLowerCase());
                    break;
                default:
                    randomCode.append(getRandomChar());
            }

        }

        return randomCode.toString();
    }
    /**
     * 获取指定范围的随机数
     *
     * @param max
     * @return
     */
    public static String getRandomDecimalString(Integer max) {
        Random rand = new Random();
        double d = rand.nextDouble() * max + 0.01;
        return new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 生成指定长度的数字型随机数
     *
     * @param length
     * @return
     */
    public static String getNumericRandomString(Integer length) {
        return getRandomString(length, 1);
    }

    /**
     * 生成指定长度的随机数,包含大写字母、小写字母、数字
     *
     * @param length
     * @return
     */
    public static String getRandomString(Integer length) {
        return getRandomString(length, 2);
    }

    /**
     * 获取指定位数的随机字符
     *
     * @param length 需要的随机字符位数
     * @param type   随机字符类型。1、数字；2、大写字符；3、小写字符；其他：包含以上三种类型
     * @return
     */
    public static String getRandomString(Integer length, Integer type) {
        StringBuffer randomCode = new StringBuffer();

        for (int i = 0; i < length; i++) {
            switch (type) {
                case 1: // 数字
                    randomCode.append(getRandomInteger());
                    break;
                case 2: // 大写字符
                    randomCode.append(getRandomUpperCase());
                    break;
                case 3: // 小写字符
                    randomCode.append(getRandomLowerCase());
                    break;
                default:
                    randomCode.append(getRandomChar());
                    break;
            }
        }

        return randomCode.toString();
    }

    /**
     * 获取一位随机字符，包含大写字母、小写字母、数字
     *
     * @return
     */
    public static String getRandomChar() {
        int index = (int) Math.round(Math.random() * 2);
        switch (index) {
            case 0:// 大写字符
                return getRandomUpperCase();
            case 1:// 小写字符
                return getRandomLowerCase();
            default:// 数字
                return getRandomInteger();
        }
    }

    /**
     * 获取一位随机大写字母
     *
     * @return
     */
    public static String getRandomUpperCase() {
        return String.valueOf((char) Math.round(Math.random() * 25 + 65));
    }

    /**
     * 获取一位随机小写字母
     *
     * @return
     */
    public static String getRandomLowerCase() {
        return String.valueOf((char) Math.round(Math.random() * 25 + 97));
    }

    /**
     * 获取一位随机数字
     *
     * @return
     */
    public static String getRandomInteger() {
        return String.valueOf(Math.round(Math.random() * 100000));
    }

}
