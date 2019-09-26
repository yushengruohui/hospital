package com.ys.hospital.controller;

import com.ys.hospital.pojo.Appointment;
import com.ys.hospital.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Appointment)表控制层
 *
 * @author yusheng
 * @since 2019-09-26 10:44:53
 */
@Controller
@RequestMapping("/appointment")
public class AppointmentController {
    private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);
    
    @Resource
    private AppointmentService appointmentService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}