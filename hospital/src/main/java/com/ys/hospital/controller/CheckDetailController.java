package com.ys.hospital.controller;

import com.ys.hospital.pojo.CheckDetail;
import com.ys.hospital.service.CheckDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (CheckDetail)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Controller
@RequestMapping("/checkDetail")
public class CheckDetailController {
    private static final Logger logger = LoggerFactory.getLogger(CheckDetailController.class);

    @Resource
    private CheckDetailService checkDetailService;

    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }


}