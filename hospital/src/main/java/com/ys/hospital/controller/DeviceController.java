package com.ys.hospital.controller;

import com.ys.hospital.pojo.Device;
import com.ys.hospital.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Device)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Controller
@RequestMapping("/device")
public class DeviceController {
    private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);

    @Resource
    private DeviceService deviceService;

    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }


}