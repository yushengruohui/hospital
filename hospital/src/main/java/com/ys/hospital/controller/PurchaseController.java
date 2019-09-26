package com.ys.hospital.controller;

import com.ys.hospital.pojo.Purchase;
import com.ys.hospital.service.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Purchase)表控制层
 *
 * @author yusheng
 * @since 2019-09-26 10:44:53
 */
@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);
    
    @Resource
    private PurchaseService purchaseService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}