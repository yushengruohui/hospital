package com.ys.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-10 09:36
 **/
@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/test")
    public String test() {
        System.out.println("跳转了");
        return "admin/index";
    }
}
