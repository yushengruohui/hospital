package com.ys.hospital.controller;

import com.ys.hospital.pojo.WorkTime;
import com.ys.hospital.service.WorkTimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (WorkTime)表控制层
 *
 * @author yusheng
 * @since 2019-09-26 10:44:53
 */
@Controller
@RequestMapping("/workTime")
public class WorkTimeController {
    private static final Logger logger = LoggerFactory.getLogger(WorkTimeController.class);
    
    @Resource
    private WorkTimeService workTimeService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}