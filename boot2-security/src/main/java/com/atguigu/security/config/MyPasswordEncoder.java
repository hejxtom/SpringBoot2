package com.atguigu.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Classname MyPasswordEncoder
 * @Description TODO
 * @Date 16:47 2022/5/7
 * @Created by hejx
 */

public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
