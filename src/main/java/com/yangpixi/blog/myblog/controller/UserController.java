package com.yangpixi.blog.myblog.controller;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.yangpixi.blog.myblog.entity.RestBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/currentUser")
    public RestBean<?> getCurrentUser(Authentication authentication) {
            if (authentication != null && authentication.isAuthenticated()) {
                return RestBean.success(authentication.getPrincipal());
            }else {
                return RestBean.failure(401, "未登录");
            }
    }

}
