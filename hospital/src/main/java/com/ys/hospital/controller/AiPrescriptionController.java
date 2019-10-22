package com.ys.hospital.controller;

import com.ys.hospital.pojo.AiPrescription;
import com.ys.hospital.service.AiPrescriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AiPrescription)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Controller
@RequestMapping("/aiPrescription")
public class AiPrescriptionController {
    private static final Logger logger = LoggerFactory.getLogger(AiPrescriptionController.class);

    @Resource
    private AiPrescriptionService aiPrescriptionService;

    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }


}