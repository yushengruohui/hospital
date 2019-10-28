package com.ys.hospital.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ys.hospital.pojo.DiagnosisMedicine;
import com.ys.hospital.pojo.DiagnosisMedicineDetail;
import com.ys.hospital.service.DiagnosisMedicineDetailService;
import com.ys.hospital.tools.MyPageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DiagnosisMedicineDetail)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Controller
@RequestMapping("/diagnosisMedicineDetail")
public class DiagnosisMedicineDetailController {
    private static final Logger logger = LoggerFactory.getLogger(DiagnosisMedicineDetailController.class);

    @Resource
    private DiagnosisMedicineDetailService diagnosisMedicineDetailService;

    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }

    //根据处方id查询处方详情
    @ResponseBody
    @GetMapping("/diagnosisMedicineDetails")
    public MyPageInfo<DiagnosisMedicineDetail> getDiagnosisMedicineDetails(Integer diagnosisMedicineId, MyPageInfo<DiagnosisMedicineDetail> myPageInfo) {

        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());
        //根据处方Id查询处方详情
        List<DiagnosisMedicineDetail> diagnosisMedicineDetails = diagnosisMedicineDetailService.getDiagnosisMedicineDetailsByDiagnosisMedicineId(diagnosisMedicineId);
        myPageInfo.setData(diagnosisMedicineDetails);
        PageInfo page = new PageInfo(myPageInfo.getData());
        myPageInfo.setCode("0");
        myPageInfo.setCount(page.getPageSize());
        return myPageInfo;
    }


}