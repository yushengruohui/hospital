package com.ys.hospital.controller;

import com.ys.hospital.pojo.Medicine;
import com.ys.hospital.service.MedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Medicine)表控制层
 *
 * @author yusheng
 * @since 2019-09-26 10:44:53
 */
@Controller
@RequestMapping("/medicine")
public class MedicineController {
    private static final Logger logger = LoggerFactory.getLogger(MedicineController.class);
    
    @Resource
    private MedicineService medicineService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}