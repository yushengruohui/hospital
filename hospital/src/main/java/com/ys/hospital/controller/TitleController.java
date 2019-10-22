package com.ys.hospital.controller;

import com.ys.hospital.pojo.Title;
import com.ys.hospital.service.TitleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Title)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Controller
@RequestMapping("/title")
public class TitleController {
    private static final Logger logger = LoggerFactory.getLogger(TitleController.class);

    @Resource
    private TitleService titleService;

    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }


}