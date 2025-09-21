package com.example.springbootsecuritydemo.service;

import com.example.springbootsecuritydemo.dto.LoginRequest;
import com.example.springbootsecuritydemo.dto.LoginResponse;
import com.example.springbootsecuritydemo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest loginRequest) {
        // 简单的用户名密码验证
        if ("test".equals(loginRequest.getUsername()) && "123456".equals(loginRequest.getPassword())) {
            String token = jwtUtil.generateToken(loginRequest.getUsername());
            return new LoginResponse(true, "登录成功", loginRequest.getUsername(), token);
        } else {
            return new LoginResponse(false, "用户名或密码错误", null, null);
        }
    }
}
