package com.ys.hospital.controller;

import com.ys.hospital.pojo.Appointment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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

    @PostMapping("/diagnosis/addReady")
    @ResponseBody
    public String diagnosisAddReady(@RequestBody Appointment appointment, HttpSession session) {
        System.out.println("=====" + appointment + "=====");

        session.setAttribute("appointment", appointment);

        return "/page/diagnosis/add";
    }

    @RequestMapping("/diagnosis/add")
    public String diagnosisAdd() {
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
