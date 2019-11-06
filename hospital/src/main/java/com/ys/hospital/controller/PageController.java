package com.ys.hospital.controller;

import com.ys.hospital.pojo.Appointment;
import com.ys.hospital.pojo.Check;
import com.ys.hospital.pojo.CheckDetail;
import com.ys.hospital.pojo.Diagnosis;
import com.ys.hospital.service.CheckDetailService;
import com.ys.hospital.service.CheckService;
import com.ys.hospital.service.DiagnosisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-10 09:36
 **/
@Controller
@RequestMapping("/page")
public class PageController {
    @Resource
    private DiagnosisService diagnosisService;
    
    @Resource
    private CheckDetailService checkDetailService;
    
    @Resource
    private CheckService checkService;

    @RequestMapping("/employee/index")
    public String toEmployeeIndex() {
        return "employee/index";
    }

    @RequestMapping("/appointment/index")
    public String toAppointmentIndex() {
        return "appointment/index";
    }

    @RequestMapping("/appointment/deal")
    public String toAppointmentDeal() {
        return "appointment/deal";
    }


    @RequestMapping("/diagnosis/dealing")
    public String toDiagnosisDealing() {
        return "diagnosis/dealing";
    }

    @RequestMapping("/diagnosis/record")
    public String toDiagnosisRecord() {
        return "diagnosis/record";
    }

    @RequestMapping("/diagnosis/index")
    public String toDiagnosisIndex() {
        return "diagnosis/index";
    }

    @RequestMapping("/work/index")
    public String toWorkIndex() {
        return "work/index";
    }

    @PostMapping("/diagnosis/addReady")
    @ResponseBody
    public String diagnosisAddReady(@RequestBody Appointment appointment, HttpSession session) {
        session.setAttribute("appointment", appointment);
        //预先创建一个只有主键的诊断记录
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setAppointmentId(appointment.getAppointmentId());

        diagnosisService.insertDiagnosis(diagnosis);

        session.setAttribute("diagnosis", diagnosis);
        return "/page/diagnosis/add";
    }


    @RequestMapping("/diagnosis/add")
    public String toDiagnosisAdd() {
        return "diagnosis/add";
    }

    @PostMapping("/diagnosis/readyUpdate")
    @ResponseBody
    public String diagnosisReadyUpdate(@RequestBody Diagnosis diagnosis, HttpSession session) {
        session.setAttribute("diagnosis", diagnosis);
        return "success";
    }

    @RequestMapping("/diagnosis/continue_dealing")
    public String toDiagnosisContinueDealing() {
        return "diagnosis/continue_dealing";
    }
    
    @RequestMapping("/check/index")
    public String toCheckIndex() {
        return "check/index";
    }
    
    @RequestMapping("/check/done")
    public String toCheckDone() {
        return "check/done";
    }
    
    @RequestMapping("/check/information")
    public String toCheckInformation() {
        return "check/information";
    }
    
    @RequestMapping("/checkDetail/index")
    public String toCheckDetailIndex() {
        return "checkDetail/index";
    }
    
    @PostMapping("/checkDetail/writeReady")
    @ResponseBody
    public String checkDetailWriteReady(@RequestBody CheckDetail checkDetail, HttpSession session) {
        session.setAttribute("checkDetail", checkDetail);
        session.setAttribute("patient", checkDetail.getPatient());
        session.setAttribute("checkItem", checkDetail.getCheckItem());
        return "/page/checkDetail/write";
    }
    
    @RequestMapping("/checkDetail/write")
    public String toCheckDetailWrite() {
        return "checkDetail/write";
    }
    
    
}
