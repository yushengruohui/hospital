package com.ys.hospital.controller;

import com.ys.hospital.pojo.Branch;
import com.ys.hospital.service.BranchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Branch)表控制层
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Controller
@RequestMapping("/branch")
public class BranchController {
    private static final Logger logger = LoggerFactory.getLogger(BranchController.class);
    
    @Resource
    private BranchService branchService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}