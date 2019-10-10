package com.ys.hospital.controller;

import com.ys.hospital.pojo.InpatientNotify;
import com.ys.hospital.service.InpatientNotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (InpatientNotify)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Controller
@RequestMapping("/inpatientNotify")
public class InpatientNotifyController {
    private static final Logger logger = LoggerFactory.getLogger(InpatientNotifyController.class);
    
    @Resource
    private InpatientNotifyService inpatientNotifyService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}