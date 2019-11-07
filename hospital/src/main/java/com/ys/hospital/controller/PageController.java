package com.ys.hospital.controller;

import com.ys.hospital.pojo.*;
import com.ys.hospital.pojo.dto.AdminEmployeeUpdateDTO;
import com.ys.hospital.service.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

    @Resource
    private CheckDetailService checkDetailService;

    @Resource
    private CheckService checkService;

    @Resource
    private RoleService roleService;

    @Resource
    private TitleService titleService;

    @Resource
    private BranchService branchService;

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

    @RequestMapping("/inpatient/employee/index")
    public String toInpatientEmployeeIndex(HttpSession session, Model model) {
        Employee employee = (Employee) session.getAttribute("employee");
        EmployeeDetail employeeDetail = employeeDetailService.queryEmployeeInfoByEmployeeId(employee.getEmployeeId());
        model.addAttribute("employeeDetail", employeeDetail);
        return "inpatient/employee/index";
    }

    @RequestMapping("/inpatient/employee/update")
    public String toInpatientEmployeeUpdate(Model model) {
        String employeeId = SecurityContextHolder.getContext().getAuthentication().getName();
        Employee employee = new Employee();
        employee.setEmployeeId(Integer.valueOf(employeeId));
        EmployeeDetail employeeDetail = employeeDetailService.queryEmployeeInfoByEmployeeId(employee.getEmployeeId());
        model.addAttribute("employeeDetail", employeeDetail);
        return "inpatient/employee/update";
    }

    @RequestMapping("/admin/employee/report")
    public String toAdminEmployeeReport() {
        return "admin/employee_report";
    }

    @RequestMapping("/admin/employee/index")
    public String toAdminEmployeeIndex() {
        return "admin/employee_index";
    }

    @RequestMapping("/admin/doctor/appointment")
    public String toAdminDoctorAppointment() {
        return "admin/doctor/appointment";
    }
    @RequestMapping("/admin/doctor/diagnosis")
    public String toAdminDoctorDiagnosis() {
        return "admin/doctor/diagnosis";
    }
    @RequestMapping("/admin/doctor/operation")
    public String toAdminDoctorOperation() {
        return "admin/doctor/operation";
    }
    @RequestMapping("/admin/doctor/work")
    public String toAdminDoctorWork() {
        return "admin/doctor/work";
    }
    @RequestMapping("/admin/doctor/dispensing")
    public String toAdminDoctorAispensing() {
        return "admin/doctor/dispensing";
    }
    @RequestMapping("/admin/nurse/inpatient")
    public String toAdminNurseInpatient() {
        return "admin/nurse/inpatient";
    }
    @RequestMapping("/admin/nurse/check")
    public String toAdminNurseCheck() {
        return "admin/nurse/check";
    }
    @RequestMapping("/admin/nurse/checkDetail")
    public String toAdminNurseCheckDetail(){
        return "admin/nurse/checkDetail";
    }
    @RequestMapping("/admin/room/check_room")
    public String toAdminRoomCheckRoom() {
        return "admin/room/check_room";
    }

    @RequestMapping("/admin/room/consult_room")
    public String toAdminRoomConsultRoom() {
        return "admin/room/consult_room";
    }

    @RequestMapping("/admin/room/inpatient_room")
    public String toAdminRoomInpatientRoom() {
        return "admin/room/inpatient_room";
    }

    @RequestMapping("/admin/room/ward_room")
    public String toAdminRoomWardRoom() {
        return "admin/room/ward_room";
    }

    @RequestMapping("/admin/medicine/index")
    public String toAdminMedicineIndex() {
        return "admin/medicine/index";
    }

    @RequestMapping("/admin/employee/add")
    public String toAdminEmployeeAdd(Model model) {
        // 前端显示角色名列表
        List<Role> roles = roleService.queryAllRole();
        List<String> roleNames = new ArrayList<>();
        for (int i = 0; i < roles.size(); i++) {
            String name = roles.get(i).getRoleName();
            roleNames.add(name);
        }
        model.addAttribute("roleNames", roleNames);

        // 前端显示职称列表
        List<Title> titles = titleService.queryAllTitle();
        List<String> titleNames = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            String name = titles.get(i).getTitleName();
            titleNames.add(name);
        }
        model.addAttribute("titleNames", titleNames);

        // 前端显示科室列表
        List<Branch> branches = branchService.queryAllBranch();
        List<String> branchNames = new ArrayList<>();
        for (int i = 0; i < branches.size(); i++) {
            String name = branches.get(i).getBranchName();
            branchNames.add(name);
        }
        model.addAttribute("branchNames", branchNames);

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

    @RequestMapping("/check/employee/index")
    public String toCheckEmployeeIndex(HttpSession session, Model model) {
        Employee employee = (Employee) session.getAttribute("employee");
        EmployeeDetail employeeDetail = employeeDetailService.queryEmployeeInfoByEmployeeId(employee.getEmployeeId());
        model.addAttribute("employeeDetail", employeeDetail);
        return "check/employee/index";
    }

    @RequestMapping("/check/employee/update")
    public String toCheckEmployeeUpdate(Model model) {
        String employeeId = SecurityContextHolder.getContext().getAuthentication().getName();
        Employee employee = new Employee();
        employee.setEmployeeId(Integer.valueOf(employeeId));
        EmployeeDetail employeeDetail = employeeDetailService.queryEmployeeInfoByEmployeeId(employee.getEmployeeId());
        model.addAttribute("employeeDetail", employeeDetail);
        return "check/employee/update";
    }

}
