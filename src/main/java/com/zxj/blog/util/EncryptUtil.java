package com.zxj.blog.util;

import com.zxj.blog.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.MessageDigest;

@Slf4j
public class EncryptUtil {

    public static final String md5_Salt = CommonConstant.salt;

    public static String toHex(byte input[]) {
        if (input == null)
            return null;
        StringBuffer output = new StringBuffer(input.length * 2);
        for (int i = 0; i < input.length; i++) {
            int current = input[i] & 0xff;
            if (current < 16)
                output.append("0");
            output.append(Integer.toString(current, 16));
        }

        return output.toString();
    }

    public static byte[] toByteArray(String hex) {
        if (StringUtils.isEmpty(hex) || hex.length()%2==1)
            return null;
        byte[] output = new byte[hex.length() / 2];
        for (int i = 0; i < output.length; i++) {
            String data = hex.substring(i*2, i*2+2);
            Integer value =Integer.valueOf(data, 16);
            output[i] = (byte)(value & 0xff);
        }

        return output;
    }

    private static String HMAC_SHA256 = "HmacSHA256";
    private static String HMAC_SHA1 = "HmacSHA1";
    private static String SHA256 = "SHA-256";
    private static String MD5 = "MD5";
    private static String UTF8 = "UTF-8";

    public static String hmacSha256(String message, String key){
        try{
            Mac mac = Mac.getInstance(HMAC_SHA256);
            log.debug("原始seed："+key);
            byte[] keyBytes = toByteArray(key);
            log.debug("实际key："+toHex(keyBytes));
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, HMAC_SHA256);
            mac.init(secretKeySpec);
            log.debug("原始待签名数据："+message);
            byte[] messageBytes = message.getBytes(Charset.forName(UTF8));
            log.debug("待签名数据："+toHex(messageBytes));
            byte[] bytes = mac.doFinal(messageBytes);
            log.debug("签名结果："+toHex(bytes));
            return toHex(bytes);
        }catch (Exception e){
            log.error(HMAC_SHA256+"加密失败：", e);
        }
        return "";
    }

    public static String hmacSha256(String message, byte[] key){
        try{
            Mac mac = Mac.getInstance(HMAC_SHA256);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, HMAC_SHA256);
            mac.init(secretKeySpec);
            log.debug("原始待签名数据："+message);
            byte[] messageBytes = message.getBytes(Charset.forName(UTF8));
            log.debug("待签名数据："+toHex(messageBytes));
            byte[] bytes = mac.doFinal(messageBytes);
            log.debug("签名结果："+toHex(bytes));
            return toHex(bytes);
        }catch (Exception e){
            log.error(HMAC_SHA256+"加密失败：", e);
        }
        return "";
    }

    public static String hmacSha256ForWallet(String message, String key){
        try{
            Mac mac = Mac.getInstance(HMAC_SHA256);
            byte[] keyBytes = toByteArray(key);
            log.info("签名KEY："+toHex(keyBytes));
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, HMAC_SHA256);
            mac.init(secretKeySpec);
            byte[] messageBytes = message.getBytes(Charset.forName(UTF8));
            log.info("待签名数据："+message);
            byte[] bytes = mac.doFinal(messageBytes);
            return toHex(bytes).toUpperCase();
        }catch (Exception e){
            log.error(HMAC_SHA256+"加密失败：", e);
        }
        return "";
    }

    public static String hmacSha1(String message, String key){
        try{
            Mac mac = Mac.getInstance(HMAC_SHA1);
            log.debug("原始seed："+key);
            byte[] keyBytes = toByteArray(key);
            log.debug("实际key："+toHex(keyBytes));
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, HMAC_SHA1);
            mac.init(secretKeySpec);
            log.debug("原始待签名数据："+message);
            byte[] messageBytes = message.getBytes(Charset.forName(UTF8));
            log.debug("待签名数据："+toHex(messageBytes));
            byte[] bytes = mac.doFinal(messageBytes);
            log.debug("签名结果："+toHex(bytes));
            return toHex(bytes).toUpperCase();
        }catch (Exception e){
            log.error(HMAC_SHA1+"加密失败：", e);
        }
        return "";
    }

    public static String sha256ToHex(String message){
        try {
            MessageDigest sha256 = MessageDigest.getInstance(SHA256);
            sha256.update(message.getBytes(UTF8));
            return toHex(sha256.digest()).toUpperCase();
        } catch (Exception e) {
            log.error(SHA256+"计算失败：", e);
            return "";
        }
    }

    public static String MD5Salt(String password,String salt) {
        if (StringUtil.isEmptyString(salt)){
            salt = md5_Salt;
        }
        String psalt = md5Hex(password) + salt;
        return md5Hex(psalt);
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance(MD5);
            byte[] bs = md5.digest(src.getBytes());
            return toHex(bs);
        } catch (Exception e) {
            return null;
        }
    }
}
