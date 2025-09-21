package com.example.springbootsecuritydemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {
        Map<String, Object> response = new HashMap<>();
        
        // 简单的用户名密码验证
        if ("test".equals(loginRequest.getUsername()) && "123456".equals(loginRequest.getPassword())) {
            response.put("success", true);
            response.put("message", "登录成功");
            response.put("username", loginRequest.getUsername());
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "用户名或密码错误");
            return ResponseEntity.badRequest().body(response);
        }
    }

    // 内部类用于接收登录请求
    public static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
