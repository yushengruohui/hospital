package com.ys.hospital.controller;

import com.ys.hospital.pojo.Power;
import com.ys.hospital.service.PowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Power)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Controller
@RequestMapping("/power")
public class PowerController {
    private static final Logger logger = LoggerFactory.getLogger(PowerController.class);
    
    @Resource
    private PowerService powerService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}