package com.ys.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-10 14:52
 **/
@Controller
public class LoginController {
    @RequestMapping("")
    public String initLogin() {
        return "login";
    }
}
