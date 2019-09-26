package com.ys.hospital.controller;

import com.ys.hospital.pojo.MedicineDetail;
import com.ys.hospital.service.MedicineDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MedicineDetail)表控制层
 *
 * @author yusheng
 * @since 2019-09-26 10:44:53
 */
@Controller
@RequestMapping("/medicineDetail")
public class MedicineDetailController {
    private static final Logger logger = LoggerFactory.getLogger(MedicineDetailController.class);
    
    @Resource
    private MedicineDetailService medicineDetailService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}