package com.ys.hospital.controller;

import com.ys.hospital.pojo.OperationNotify;
import com.ys.hospital.service.OperationNotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OperationNotify)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Controller
@RequestMapping("/operationNotify")
public class OperationNotifyController {
    private static final Logger logger = LoggerFactory.getLogger(OperationNotifyController.class);

    @Resource
    private OperationNotifyService operationNotifyService;

    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }


}