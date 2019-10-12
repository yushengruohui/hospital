package com.ys.hospital.controller;

import com.ys.hospital.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Appointment)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@RestController
public class AppointmentController {
    private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);

    @Resource
    private AppointmentService appointmentService;

    @GetMapping("/appointment/appointmentId")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }


}