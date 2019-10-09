package com.ys.hospital.controller;

import com.ys.hospital.pojo.DiagnosisMedicine;
import com.ys.hospital.service.DiagnosisMedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DiagnosisMedicine)表控制层
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Controller
@RequestMapping("/diagnosisMedicine")
public class DiagnosisMedicineController {
    private static final Logger logger = LoggerFactory.getLogger(DiagnosisMedicineController.class);
    
    @Resource
    private DiagnosisMedicineService diagnosisMedicineService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}