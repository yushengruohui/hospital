package com.ys.hospital.controller;

import com.ys.hospital.pojo.Appointment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/diagnosis/add")
    public String diagnosisAdd(Model session, Appointment appointment) {
        System.out.println("=====" + appointment + "=====");
        session.addAttribute("appointment", appointment);

        return "diagnosis/add";
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
