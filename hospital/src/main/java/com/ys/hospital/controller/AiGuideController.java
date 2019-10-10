package com.ys.hospital.controller;

import com.ys.hospital.pojo.AiGuide;
import com.ys.hospital.service.AiGuideService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AiGuide)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Controller
@RequestMapping("/aiGuide")
public class AiGuideController {
    private static final Logger logger = LoggerFactory.getLogger(AiGuideController.class);
    
    @Resource
    private AiGuideService aiGuideService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}