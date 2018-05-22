package com.firs.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AppController {

    @GetMapping("/app")
    public String index(HttpServletRequest request) {
        return "index.html";
    }
}
