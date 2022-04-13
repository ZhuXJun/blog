package com.zxj.blog.config;

import com.zxj.blog.util.EncryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BlogPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return EncryptUtil.MD5Salt(rawPassword.toString(),"");
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword == null || encodedPassword.length() == 0) {
            log.warn("Empty encoded password");
            return false;
        }
        return encode(rawPassword).equals(encodedPassword);
    }

    public static void main(String[] args) {
        System.out.println(EncryptUtil.MD5Salt("admin", ""));
    }
}
