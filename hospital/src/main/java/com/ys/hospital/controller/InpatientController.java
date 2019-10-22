package com.ys.hospital.controller;

import com.ys.hospital.pojo.Inpatient;
import com.ys.hospital.pojo.InpatientNotify;
import com.ys.hospital.service.InpatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Inpatient)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Controller
@RequestMapping("/inpatient")
public class InpatientController {
    private static final Logger logger = LoggerFactory.getLogger(InpatientController.class);
    
    @Resource
    private InpatientService inpatientService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }

    @RequestMapping("/queryAllInpatient")
    public String queryAllInpatient(Model model){
        List<Inpatient> inpatients=inpatientService.queryAllInpatient();
        model.addAttribute("inpatients",inpatients);
        logger.info("queryAllInpatient success");
        return "/nurse/inpatient_list";
    }

    @RequestMapping("/queryInpatientByParam")
    public String queryInpatientByParam(Inpatient inpatient,Model model){
        List<Inpatient> inpatients=inpatientService.queryInpatientByParam(inpatient);
        model.addAttribute("inpatients",inpatients);
        logger.info("queryInpatientByParam success");
        return "/nurse/inpatient_list";
    }

    @RequestMapping("/toInsertInpatient")
    public String toInsertInpatient(){
        return "/nurse/inpatient_insert";
    }

    @RequestMapping("/insertInpatient")
    public String insertInpatient(Inpatient inpatient){
        int count=inpatientService.insertInpatient(inpatient);
        System.out.println(inpatient);
        if(count>0){
            //更新住院通知的处理状态为1
            InpatientNotify inpatientNotify=new InpatientNotify();
            inpatientNotify.setInpatientNotifyId(inpatient.getInpatientNotifyId());
            inpatientNotify.setInpatientNotifyStatus(1);
            return "/nurse/inpatient_list";
        }
        logger.info("insertInpatient success");
        return "/nurse/inpatient_insert";
    }

    @RequestMapping("/toUpdateInpatient")
    public String toUpdateInpatient(Integer inpatientId,Model model){
        List<Inpatient> inpatients=inpatientService.queryInpatientByInpatientId(inpatientId);
        System.out.println(inpatientId);
        model.addAttribute("inpatients",inpatients);
        logger.info("queryInpatientByInpatientID success");
        return "/nurse/inpatient_update";
    }

    @RequestMapping("/updateInpatient")
    public String updateInpatient(Inpatient inpatient){
        int count=inpatientService.updateInpatient(inpatient);
        logger.info("updateInpatient success");
        if(count>0){
            return "redirect:/inpatient/queryAllInpatient";
        }
        return "/nurse/inpatient_update";
    }
}