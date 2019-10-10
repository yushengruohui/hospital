package com.ys.hospital.controller;

import com.ys.hospital.pojo.Operation;
import com.ys.hospital.service.OperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Operation)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Controller
@RequestMapping("/operation")
public class OperationController {
    private static final Logger logger = LoggerFactory.getLogger(OperationController.class);
    
    @Resource
    private OperationService operationService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}