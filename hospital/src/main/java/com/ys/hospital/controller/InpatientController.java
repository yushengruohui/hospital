package com.ys.hospital.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ys.hospital.pojo.*;
import com.ys.hospital.service.BedService;
import com.ys.hospital.service.InpatientNotifyService;
import com.ys.hospital.service.InpatientService;
import com.ys.hospital.tools.MyPageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
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
   @Resource
    private BedService bedService;
   @Resource
    private InpatientNotifyService inpatientNotifyService;

    @GetMapping("/queryAllInpatient")
    @ResponseBody
    public MyPageInfo<Inpatient> inpatients(MyPageInfo<Inpatient> myPageInfo){
        List<Inpatient> inpatients=inpatientService.queryAllInpatient();

        //开启分页
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());

        //处理分页信息
        myPageInfo.setData(inpatients);
        //将用户数据封装到PageInfo 中
        PageInfo page = new PageInfo(myPageInfo.getData());
        //设置数据数量
        myPageInfo.setCount(page.getPageSize());
        //设置成功代码
        myPageInfo.setCode("0");

        return myPageInfo;
    }

    @GetMapping("/queryInpatientByStatus")
    @ResponseBody
    public MyPageInfo<Inpatient> inpatients(MyPageInfo<Inpatient> myPageInfo,Integer inpatientStatus){
        List<Inpatient> inpatients=inpatientService.queryInpatientByStatus(inpatientStatus);
        //开启分页
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());

        //处理分页信息
        myPageInfo.setData(inpatients);
        //将用户数据封装到PageInfo 中
        PageInfo page = new PageInfo(myPageInfo.getData());
        //设置数据数量
        myPageInfo.setCount(page.getPageSize());
        //设置成功代码
        myPageInfo.setCode("0");

        return myPageInfo;
    }
    @RequestMapping("/queryInpatientByParam")
    public String queryInpatientByParam(Inpatient inpatient,Model model){
        List<Inpatient> inpatients=inpatientService.queryInpatientByParam(inpatient);
        model.addAttribute("inpatients",inpatients);
        logger.info("queryInpatientByParam success");
        return "/inpatient/inpatient_list";
    }

    @RequestMapping("/toInsertInpatient")
    public String toInsertInpatient(Integer bedStatus,Model model){
        List<Bed> beds=bedService.queryBedByStatus(bedStatus);
        model.addAttribute("beds",beds);
        return "/inpatient/inpatient_insert";
    }

    /**
     * 添加住院信息
     * @param inpatient
     * @param session
     * @param inpatientId
     * @return
     */
    @RequestMapping("/insertInpatient")
    @ResponseBody
    public String insertInpatient(Inpatient inpatient, HttpSession session, Integer inpatientId){
        Employee employee = (Employee) session.getAttribute("employee");
        int count=inpatientService.insertInpatient(inpatient);
        //System.out.println(inpatient);
        if(count>0){
            //更新住院通知信息
            InpatientNotify inpatientNotify=new InpatientNotify();
            inpatientNotify.setInpatientNotifyId(inpatient.getInpatientNotifyId());
//            System.out.println(inpatient.getInpatientNotifyId());
            inpatientNotify.setInpatientNotifyStatus(1);
            inpatientNotify.setEmployeeId(employee.getEmployeeId());
            inpatientNotify.setInpatientDealTime(new Date());
            inpatientNotifyService.updateInpatientNotify(inpatientNotify);
            //更新病床信息
            Bed bed=new Bed();
            bed.setBedId(inpatient.getBedId());
            bed.setBedStatus(1);
            bed.setBedEntryTime(new Date());
            List<Appointment> appointment=inpatientService.queryInpatientById(inpatient.getInpatientId());
            System.out.println("appointment = " + appointment);
            bed.setPatientId(appointment.get(0).getPatientId());
            bed.setEmployeeId(employee.getEmployeeId());
            bedService.updateBed(bed);
            return "success";
        }else{
            return "error";
        }

    }

    /**
     * 出院
     * @return
     */
    @PostMapping("/leaveInpatient")
    @ResponseBody
    public String leaveInpatient(Inpatient inpatient){
        //更新住院信息
        Inpatient inpatients=new Inpatient();
        inpatients.setInpatientId(inpatient.getInpatientId());
        inpatients.setInpatientLeaveTime(new Date());
        inpatients.setInpatientStatus(1);
        inpatients.setInpatientPayStatus(1);
        inpatients.setInpatientPrepaidPrice(inpatient.getInpatientPrice());
        inpatientService.updateInpatient(inpatients);
        //更新病床信息
        Bed bed=new Bed();
        bed.setBedId(inpatient.getBedId());
        bed.setBedStatus(0);
        bed.setBedLeaveTime(new Date());
        bedService.updateBed(bed);

        return "success";
    }
    /*@RequestMapping("/toUpdateInpatient")
    public String toUpdateInpatient(Integer inpatientId,Model model){
        List<Inpatient> inpatients=inpatientService.queryInpatientByInpatientId(inpatientId);
        System.out.println(inpatientId);
        model.addAttribute("inpatients",inpatients);
        logger.info("queryInpatientByInpatientID success");
        return "/inpatient/inpatient_update";
    }

    @RequestMapping("/updateInpatient")
    public String updateInpatient(Inpatient inpatient){
        int count=inpatientService.updateInpatient(inpatient);
        logger.info("updateInpatient success");
        if(count>0){
            return "redirect:/inpatient/queryAllInpatient";
        }
        return "/inpatient/inpatient_update";
    }*/

    @RequestMapping("/query")
    public String app(){
        return "";
    }
}