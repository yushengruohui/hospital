package com.ys.hospital.controller;

import com.ys.hospital.pojo.CheckItem;
import com.ys.hospital.service.CheckItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (CheckItem)表控制层
 *
 * @author yusheng
 * @since 2019-09-26 10:44:53
 */
@Controller
@RequestMapping("/checkItem")
public class CheckItemController {
    private static final Logger logger = LoggerFactory.getLogger(CheckItemController.class);
    
    @Resource
    private CheckItemService checkItemService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }
    
    
}