package com.ys.hospital.controller;

import com.ys.hospital.service.MedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Medicine)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@RestController

public class MedicineController {
    private static final Logger logger = LoggerFactory.getLogger(MedicineController.class);

    @Resource
    private MedicineService medicineService;

    @GetMapping("/medicine")
    public String getMedicine(String medicineTip) {
        String medicineName = medicineService.queryMedicineName(medicineTip);
        return "redirect:/";
    }


}