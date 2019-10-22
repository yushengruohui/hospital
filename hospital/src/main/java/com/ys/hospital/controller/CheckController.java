package com.ys.hospital.controller;

import com.ys.hospital.pojo.Check;
import com.ys.hospital.service.CheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Check)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Controller
@RequestMapping("/check")
public class CheckController {
    private static final Logger logger = LoggerFactory.getLogger(CheckController.class);

    @Resource
    private CheckService checkService;

    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }


}