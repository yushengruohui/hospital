package com.ys.hospital.controller;

import com.ys.hospital.pojo.PowerDetail;
import com.ys.hospital.service.PowerDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PowerDetail)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Controller
@RequestMapping("/powerDetail")
public class PowerDetailController {
    private static final Logger logger = LoggerFactory.getLogger(PowerDetailController.class);

    @Resource
    private PowerDetailService powerDetailService;

    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }


}