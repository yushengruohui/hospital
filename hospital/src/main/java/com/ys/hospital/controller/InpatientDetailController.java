package com.ys.hospital.controller;

import com.ys.hospital.pojo.Inpatient;
import com.ys.hospital.pojo.InpatientDetail;
import com.ys.hospital.service.InpatientDetailService;
import com.ys.hospital.service.InpatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
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
    private InpatientService inpatientService;
    @Resource
    private InpatientDetailService inpatientDetailService;
    
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }

    /**
     * 查看住院明细
     * @param inpatientId
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryInpatientDetailByInpatientId")
    public List<InpatientDetail> queryInpatientDetailByInpatientId(Integer inpatientId){
        Inpatient inpatient=new Inpatient();
        inpatient.setInpatientId(inpatientId);
        List<InpatientDetail> inpatientDetails=inpatientDetailService.queryInpatientDetailByInpatientId(inpatientId);
        return inpatientDetails;
    }

    @RequestMapping("/toUpdateInpatientDetail")
    public String toUpdateInpatientDetail(Integer InpatientId, Model model){
        List<InpatientDetail> inpatientDetails=inpatientDetailService.queryInpatientDetailByInpatientId(InpatientId);
        model.addAttribute("inpatientDetails",inpatientDetails);
        logger.info("queryInpatientDetailByInpatientId success");
        return "/inpatient/inpatientDetail_update";
    }

    @RequestMapping("/updateInpatientDetail")
    public String updateInpatientDetail(InpatientDetail inpatientDetail){
        int count=inpatientDetailService.updateInpatientDetail(inpatientDetail);
        if(count>0){
            return "redirect:/inpatientDetail/queryInpatientDetailByInpatientId";
        }
        return "redirect:/inpatientDetail/toUpdateInpatientDetail";
    }

    /**
     * 添加住院明细
     * @return
     */
    @PostMapping("/insertInpatientDetail")
    @ResponseBody
    public String insertInpatientDetail(InpatientDetail inpatientDetail,Model model){
        int count=inpatientDetailService.insertInpatientDetail(inpatientDetail);
        if(count>0)
        {
            InpatientDetail inpatientDetails=new InpatientDetail();
            inpatientDetails.setInpatientDetailId(inpatientDetail.getInpatientDetailId());
            inpatientDetails.setInpatientDetailDate(new Date());
            inpatientDetailService.updateInpatientDetail(inpatientDetails);

            Inpatient inpatient=new Inpatient();
            inpatient.setInpatientId(inpatientDetail.getInpatientId());
            List<Inpatient> inpatients=inpatientService.queryInpatientByInpatientId(inpatientDetail.getInpatientId());
            if(inpatients.get(0).getInpatientPrice()!=null){
                double price=inpatients.get(0).getInpatientPrice();
                price=price+inpatientDetail.getInpatientDetailPrice();
                inpatient.setInpatientPrice(price);
                inpatientService.updateInpatient(inpatient);
            } else{
                inpatient.setInpatientPrice(inpatientDetail.getInpatientDetailPrice());
                inpatientService.updateInpatient(inpatient);
            }
            return "success";
        }else
             return "error";
    }
}