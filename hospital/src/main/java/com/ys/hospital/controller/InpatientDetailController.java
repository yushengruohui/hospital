package com.ys.hospital.controller;

import com.ys.hospital.pojo.InpatientDetail;
import com.ys.hospital.service.InpatientDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (InpatientDetail)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Controller
@RequestMapping("/inpatientDetail")
public class InpatientDetailController {
    private static final Logger logger = LoggerFactory.getLogger(InpatientDetailController.class);
    
    @Resource
    private InpatientDetailService inpatientDetailService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }

    @RequestMapping("/queryInpatientDetailByInpatientId")
    public String queryInpatientDetailByInpatientId(Integer InpatientId, Model model){
        List<InpatientDetail> inpatientDetails=inpatientDetailService.queryInpatientDetailByInpatientId(InpatientId);
        model.addAttribute("inpatientDetails",inpatientDetails);
        logger.info("queryInpatientDetailByInpatientId success");
        return "/nurse/inpatientDetail_list";
    }

    @RequestMapping("/toUpdateInpatientDetail")
    public String toUpdateInpatientDetail(Integer InpatientId, Model model){
        List<InpatientDetail> inpatientDetails=inpatientDetailService.queryInpatientDetailByInpatientId(InpatientId);
        model.addAttribute("inpatientDetails",inpatientDetails);
        logger.info("queryInpatientDetailByInpatientId success");
        return "/nurse/inpatientDetail_update";
    }

    @RequestMapping("/updateInpatientDetail")
    public String updateInpatientDetail(InpatientDetail inpatientDetail){
        int count=inpatientDetailService.updateInpatientDetail(inpatientDetail);
        if(count>0){
            return "redirect:/inpatientDetail/queryInpatientDetailByInpatientId";
        }
        return "redirect:/inpatientDetail/toUpdateInpatientDetail";
    }
}