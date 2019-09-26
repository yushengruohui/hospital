package com.ys.hospital.controller;

import com.ys.hospital.pojo.Work;
import com.ys.hospital.service.WorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Work)表控制层
 *
 * @author yusheng
 * @since 2019-09-26 10:44:53
 */
@Controller
@RequestMapping("/work")
public class WorkController {
    private static final Logger logger = LoggerFactory.getLogger(WorkController.class);
    
    @Resource
    private WorkService workService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}