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
    @RequestMapping("/diagnosis/index")
    public String diagnosisIndex() {
        return "diagnosis/index";
    }

    @RequestMapping("/appointment/index")
    public String appointmentIndex() {
        return "appointment/index";
    }

    @RequestMapping("/employee/index")
    public String employeeIndex() {
        return "employee/index";
    }
}
