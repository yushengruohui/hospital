package com.ys.hospital.controller;

import com.ys.hospital.pojo.Patient;
import com.ys.hospital.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Patient)表控制层
 *
 * @author yusheng
 * @since 2019-09-26 10:44:53
 */
@Controller
@RequestMapping("/patient")
public class PatientController {
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
    
    @Resource
    private PatientService patientService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}