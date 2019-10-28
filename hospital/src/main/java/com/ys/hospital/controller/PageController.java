package com.ys.hospital.controller;

import com.ys.hospital.pojo.Appointment;
import com.ys.hospital.pojo.Diagnosis;
import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.EmployeeDetail;
import com.ys.hospital.service.DiagnosisService;
import com.ys.hospital.service.EmployeeDetailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private EmployeeDetailService employeeDetailService;

    @RequestMapping("/employee/index")
    public String toEmployeeIndex(HttpSession session, Model model) {
        Employee employee = (Employee) session.getAttribute("employee");
        EmployeeDetail employeeDetail = employeeDetailService.queryEmployeeInfoByEmployeeId(employee.getEmployeeId());
        model.addAttribute("employeeDetail", employeeDetail);
        return "employee/index";
    }

    @RequestMapping("/employee/update")
    public String toEmployeeUpdate(Model model) {
        String employeeId = SecurityContextHolder.getContext().getAuthentication().getName();
        Employee employee = new Employee();
        employee.setEmployeeId(Integer.valueOf(employeeId));
        EmployeeDetail employeeDetail = employeeDetailService.queryEmployeeInfoByEmployeeId(employee.getEmployeeId());
        model.addAttribute("employeeDetail", employeeDetail);
        return "employee/update";
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
}
