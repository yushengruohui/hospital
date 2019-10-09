package com.ys.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-09 09:50
 **/
@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/login")
    public String login() {
        return "pages/login";
    }
}
