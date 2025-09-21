package com.example.springbootsecuritydemo.service;

import com.example.springbootsecuritydemo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthenticationService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 验证 JWT Token 并返回用户详情
     * @param token JWT Token
     * @return 用户详情，如果验证失败返回 null
     */
    public UserDetails validateTokenAndGetUserDetails(String token) {
        try {
            String username = jwtUtil.extractUsername(token);
            if (username != null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (jwtUtil.validateToken(token, userDetails.getUsername())) {
                    return userDetails;
                }
            }
        } catch (Exception e) {
            // Token 验证失败，记录日志但不抛出异常
            System.err.println("JWT token 验证失败: " + e.getMessage());
        }
        return null;
    }
}
