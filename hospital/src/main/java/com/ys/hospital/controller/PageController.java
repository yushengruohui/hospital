package com.ys.hospital.controller;

import com.ys.hospital.pojo.Appointment;
import com.ys.hospital.pojo.Diagnosis;
import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.EmployeeDetail;
import com.ys.hospital.pojo.dto.AdminEmployeeUpdateDTO;
import com.ys.hospital.service.DiagnosisService;
import com.ys.hospital.service.EmployeeDetailService;
import com.ys.hospital.service.OperationNotifyService;
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
    private OperationNotifyService operationNotifyService;
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

    @RequestMapping("/dispensing/index")
    public String toDispensingIndex() {
        return "dispensing/index";
    }

    @RequestMapping("/dispensing/record")
    public String toDispensingRecord() {
        return "dispensing/record";
    }

    @RequestMapping("/medicine/index")
    public String toMedicineIndex() {
        return "medicine/index";
    }

    @RequestMapping("/dispensing/employee/index")
    public String toDispensingEmployeeIndex(HttpSession session, Model model) {
        Employee employee = (Employee) session.getAttribute("employee");
        EmployeeDetail employeeDetail = employeeDetailService.queryEmployeeInfoByEmployeeId(employee.getEmployeeId());
        model.addAttribute("employeeDetail", employeeDetail);
        return "dispensing/employee/index";
    }

    @RequestMapping("/dispensing/employee/update")
    public String toDispensingEmployeeUpdate(Model model) {
        String employeeId = SecurityContextHolder.getContext().getAuthentication().getName();
        Employee employee = new Employee();
        employee.setEmployeeId(Integer.valueOf(employeeId));
        EmployeeDetail employeeDetail = employeeDetailService.queryEmployeeInfoByEmployeeId(employee.getEmployeeId());
        model.addAttribute("employeeDetail", employeeDetail);
        return "dispensing/employee/update";
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

    @RequestMapping("/operation/index")
    public String toOperation() {
        return "operation/find";
    }

    @RequestMapping("/operation/findopertion")
    public String tofindopertion() {
        return "operation/findoperation";
    }

    @RequestMapping("/inpatient/index")
    public String toInpatientIndex() {
        return "/inpatient/index";
    }

    @RequestMapping("/inpatientNotify/queryAllInpatientNotify")
    public String queryAllInpatientNotify() {
        return "/inpatient/inpatientNotify_list";
    }

    @RequestMapping("/inpatientNotify/queryInpatientNotifyByStatus")
    public String queryInpatientNotifyByStatus() {
        return "/inpatient/index";
    }

    @RequestMapping("/inpatient/insertReady")
    public String inpatientInsertReady() {
        return "/page/inpatient/insert";
    }

    @RequestMapping("/inpatient/insert")
    public String toInsertInpatient() {
        return "/inpatient/inpatient_insert";
    }

    @RequestMapping("/inpatient/queryAllInpatient")
    public String queryAllInpatient() {
        return "/inpatient/inpatient_list";
    }

    @RequestMapping("/inpatient/queryInpatientByStatus")
    public String queryInpatientByStatus() {
        return "/inpatient/inpatient_status";
    }

    @RequestMapping("/bed/queryAllBed")
    public String queryAllBed() {
        return "/inpatient/bed_list";
    }

    @RequestMapping("/bed/queryBedByStatus")
    public String queryBedByStatus() {
        return "/inpatient/bed_status";
    }

    @RequestMapping("/admin/employee/report")
    public String toAdminEmployeeReport() {
        return "admin/employee_report";
    }

    @RequestMapping("/admin/employee/index")
    public String toAdminEmployeeIndex() {
        return "admin/employee_index";
    }

    @RequestMapping("/admin/employee/add")
    public String toAdminEmployeeAdd() {
        return "admin/employee_add";
    }

    @RequestMapping("/admin/employee/update")
    public String toAdminEmployeeUpdate(AdminEmployeeUpdateDTO employee, Model model) {
        model.addAttribute("employee", employee);
        // System.out.println("employee = " + employee);
        return "admin/employee_update";
    }

    @RequestMapping("/admin/permission/index")
    public String toAdminPermissionIndex() {
        return "admin/permission_index";
    }

    @RequestMapping("/admin/permission/add")
    public String toAdminPermissionAdd() {
        return "admin/permission_add";
    }
}
