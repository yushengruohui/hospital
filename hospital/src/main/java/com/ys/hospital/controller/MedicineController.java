package com.ys.hospital.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ys.hospital.pojo.Medicine;
import com.ys.hospital.service.MedicineService;
import com.ys.hospital.tools.MyPageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
        if (medicineTip == null || medicineTip == "" || medicineTip.isEmpty()) {
            return "";
        }
        String medicineName = medicineService.queryMedicineName(medicineTip);
        return medicineName;
    }

    @GetMapping("/employee/medicines")
    //查询所有药品信息
    public MyPageInfo<Medicine> getMedicines(MyPageInfo<Medicine> myPageInfo) {
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());
        //查询所有药品信息
        List<Medicine> medicines = medicineService.queryAllMedicine();
        myPageInfo.setData(medicines);
        PageInfo page = new PageInfo(myPageInfo.getData());
        myPageInfo.setCode("0");
        myPageInfo.setCount(page.getPageSize());
        return myPageInfo;
    }

}