package com.ys.hospital.controller;

import com.ys.hospital.pojo.Bed;
import com.ys.hospital.service.BedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Bed)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Controller
@RequestMapping("/bed")
public class BedController {
    private static final Logger logger = LoggerFactory.getLogger(BedController.class);

    @Resource
    private BedService bedService;

    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }


}