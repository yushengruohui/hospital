package com.ys.hospital.controller;

import com.ys.hospital.pojo.EmployeeRole;
import com.ys.hospital.service.EmployeeRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (EmployeeRole)表控制层
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Controller
@RequestMapping("/employeeRole")
public class EmployeeRoleController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeRoleController.class);
    
    @Resource
    private EmployeeRoleService employeeRoleService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}