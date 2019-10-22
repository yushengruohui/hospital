package com.ys.hospital.controller;

import com.ys.hospital.pojo.InpatientNotify;
import com.ys.hospital.service.InpatientNotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (InpatientNotify)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Controller
@RequestMapping("/inpatientNotify")
public class InpatientNotifyController {
    private static final Logger logger = LoggerFactory.getLogger(InpatientNotifyController.class);
    
    @Resource
    private InpatientNotifyService inpatientNotifyService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }

    @RequestMapping("/queryAllInpatientNotify")
    public String queryAllInpatientNotify(Model model){
        List<InpatientNotify> inpatientNotifies=inpatientNotifyService.queryAllInpatientNotify();
        model.addAttribute("inpatientNotifies",inpatientNotifies);
        logger.info("queryAllInpatientNotify success");
        return "/nurse/inpatientNotify_list";
    }

    @RequestMapping("/queryInpatientNotifyByEmployeeId")
    public String queryInpatientNotifyByEmployeeId(Integer employeeId,Integer inpatientNotifyStatus,Model model){
        List<InpatientNotify> inpatientNotifies=inpatientNotifyService.queryInpatientNotifyByEmployeeId(employeeId,inpatientNotifyStatus);
        model.addAttribute("inpatientNotifies",inpatientNotifies);
        logger.info("queryInpatientNotifyByEmployeeId success");
        return "/nurse/inpatientNotify_list";
    }

    /*@RequestMapping("/toInsertInpatientNotify")
    public String toInsertInpatientNotify(){
        logger.info("toInsertInpatientNotify success");
        return "/nurse/inpatientNotify_insert";
    }*/
    /*@RequestMapping("/insertInpatientNotify")
    public String insertInpatientNotify(InpatientNotify inpatientNotify){
        int count=inpatientNotifyService.insertInpatientNotify(inpatientNotify);
        logger.info("insertInpatientNotify success");
        if(count>0){
            return "redirect:/inpatientNotify/queryAllInpatientNotify";
        }
        return "redirect:/inpatientNotify/insertInpatientNotify";
    }*/
}