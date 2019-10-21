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

    @RequestMapping("/employee/index")
    public String toEmployeeIndex() {
        return "employee/index";
    }

    @RequestMapping("/appointment/index")
    public String toAppointmentIndex() {
        return "appointment/index";
    }

    @RequestMapping("/appointment/deal")
    public String toAppointmentDeal() {
        return "appointment/deal";
    }


    @RequestMapping("/diagnosis/dealing")
    public String toDiagnosisDealing() {
        return "diagnosis/dealing";
    }

    @RequestMapping("/diagnosis/record")
    public String toDiagnosisRecord() {
        return "diagnosis/record";
    }

    @RequestMapping("/diagnosis/index")
    public String toDiagnosisIndex() {
        return "diagnosis/index";
    }

    @RequestMapping("/work/index")
    public String toWorkIndex() {
        return "work/index";
    }

    @PostMapping("/diagnosis/addReady")
    @ResponseBody
    public String diagnosisAddReady(@RequestBody Appointment appointment, HttpSession session) {
        System.out.println("=====" + appointment + "=====");

        session.setAttribute("appointment", appointment);

        return "/page/diagnosis/add";
    }

    @RequestMapping("/diagnosis/add")
    public String toDiagnosisAdd() {
        return "diagnosis/add";
    }
}
