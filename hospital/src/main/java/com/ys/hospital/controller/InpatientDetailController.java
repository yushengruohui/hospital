package com.ys.hospital.controller;

import com.ys.hospital.pojo.InpatientDetail;
import com.ys.hospital.service.InpatientDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (InpatientDetail)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Controller
@RequestMapping("/inpatientDetail")
public class InpatientDetailController {
    private static final Logger logger = LoggerFactory.getLogger(InpatientDetailController.class);
    
    @Resource
    private InpatientDetailService inpatientDetailService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}