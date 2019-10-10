package com.ys.hospital.controller;

import com.ys.hospital.pojo.RolePower;
import com.ys.hospital.service.RolePowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RolePower)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Controller
@RequestMapping("/rolePower")
public class RolePowerController {
    private static final Logger logger = LoggerFactory.getLogger(RolePowerController.class);
    
    @Resource
    private RolePowerService rolePowerService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}