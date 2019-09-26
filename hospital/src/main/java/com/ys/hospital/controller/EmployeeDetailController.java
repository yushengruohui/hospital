package com.ys.hospital.controller;

import com.ys.hospital.pojo.EmployeeDetail;
import com.ys.hospital.service.EmployeeDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (EmployeeDetail)表控制层
 *
 * @author yusheng
 * @since 2019-09-26 10:44:53
 */
@Controller
@RequestMapping("/employeeDetail")
public class EmployeeDetailController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDetailController.class);
    
    @Resource
    private EmployeeDetailService employeeDetailService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}