package com.ys.hospital.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ys.hospital.dao.BranchMapper;
import com.ys.hospital.dao.EmployeeMapper;
import com.ys.hospital.dao.PatientMapper;
import com.ys.hospital.pojo.Appointment;
import com.ys.hospital.pojo.Branch;
import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.Patient;
import com.ys.hospital.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (Appointment)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@RestController
public class AppointmentController {
    private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);

    @Resource
    private AppointmentService appointmentService;

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private PatientMapper patientMapper;

    @Resource
    private BranchMapper branchMapper;


    @GetMapping("/appointments")
    public PageInfo appointments(Integer currentPage, HttpSession session) {
        //获取医师信息
        Employee employee = (Employee) session.getAttribute("employee");
        //根据员工id查询未处理预约记录
        List<Appointment> appointments = appointmentService.findUntreatedAppointment(employee.getEmployeeId());

        if (appointments == null) {
            return null;
        }

        //获取科室信息
        Branch branch = new Branch();
        branch.setBranchId(appointments.get(0).getBranchId());
        branch = branchMapper.queryBranchByParam(branch).get(0);

        //获取预约记录所有相关属性
        for (int i = 0; i < appointments.size(); i++) {
            //遍历每一个未处理的预约记录
            Appointment appointment = appointments.get(i);

            //所有未处理预约归当前医师管理
            appointment.setEmployee(employee);

            //获取患者信息
            Patient patient = new Patient();
            patient.setPatientId(appointment.getPatientId());
            patient = patientMapper.queryPatientByParam(patient).get(0);
            appointment.setPatient(patient);

            //获取科室信息
            appointment.setBranch(branch);
        }

        PageHelper.startPage(currentPage, 8);
        PageInfo pageInfo = new PageInfo(appointments);
        return pageInfo;
    }


}