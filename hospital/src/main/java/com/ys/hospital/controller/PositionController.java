package com.ys.hospital.controller;

import com.ys.hospital.pojo.Position;
import com.ys.hospital.service.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Position)表控制层
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Controller
@RequestMapping("/position")
public class PositionController {
    private static final Logger logger = LoggerFactory.getLogger(PositionController.class);
    
    @Resource
    private PositionService positionService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}