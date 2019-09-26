package com.ys.hospital.controller;

import com.ys.hospital.pojo.DiagnosisMedicineDetail;
import com.ys.hospital.service.DiagnosisMedicineDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DiagnosisMedicineDetail)表控制层
 *
 * @author yusheng
 * @since 2019-09-26 10:44:53
 */
@Controller
@RequestMapping("/diagnosisMedicineDetail")
public class DiagnosisMedicineDetailController {
    private static final Logger logger = LoggerFactory.getLogger(DiagnosisMedicineDetailController.class);
    
    @Resource
    private DiagnosisMedicineDetailService diagnosisMedicineDetailService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}