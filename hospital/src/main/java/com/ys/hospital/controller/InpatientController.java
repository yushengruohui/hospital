package com.ys.hospital.controller;

import com.ys.hospital.pojo.Inpatient;
import com.ys.hospital.service.InpatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Inpatient)表控制层
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Controller
@RequestMapping("/inpatient")
public class InpatientController {
    private static final Logger logger = LoggerFactory.getLogger(InpatientController.class);
    
    @Resource
    private InpatientService inpatientService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}