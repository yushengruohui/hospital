package com.ys.hospital.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ys.hospital.pojo.Appointment;
import com.ys.hospital.pojo.Branch;
import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.Patient;
import com.ys.hospital.service.AppointmentService;
import com.ys.hospital.service.BranchService;
import com.ys.hospital.service.PatientService;
import com.ys.hospital.tools.MyPageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    //private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);

    @Resource
    private AppointmentService appointmentService;

    @Resource
    private PatientService patientService;

    @Resource
    private BranchService branchService;


    @GetMapping("/appointment/untreatedAppointments")
    public MyPageInfo<Appointment> appointments(MyPageInfo<Appointment> myPageInfo, HttpSession session) {
        //获取医师信息
        Employee employee = (Employee) session.getAttribute("employee");
        //根据员工id查询未处理预约记录
        List<Appointment> appointments = appointmentService.findUntreatedAppointment(employee.getEmployeeId());

        //没有预约记录，返回空
        if (appointments.isEmpty()) {
            PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());
            //处理分页信息
            myPageInfo.setData(appointments);
            //将用户数据封装到PageInfo 中
            PageInfo page = new PageInfo(myPageInfo.getData());
            //设置成功代码
            myPageInfo.setCode("0");
            //设置数据数量
            myPageInfo.setCount(0);
            return myPageInfo;
        }
        //开启分页
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());

        //获取科室信息
        Branch branch = new Branch();
        branch.setBranchId(appointments.get(0).getBranchId());
        branch = branchService.queryBranchByParam(branch).get(0);

        //获取预约记录所有相关属性
        for (int i = 0; i < appointments.size(); i++) {
            //遍历每一个未处理的预约记录
            Appointment appointment = appointments.get(i);

            //所有未处理预约归当前医师管理
            appointment.setEmployee(employee);

            //获取患者信息
            Patient patient = new Patient();
            patient.setPatientId(appointment.getPatientId());
            patient = patientService.queryPatientByParam(patient).get(0);
            appointment.setPatient(patient);

            //获取科室信息
            appointment.setBranch(branch);
        }

        //System.out.println("=====" + appointments + "=====");

        //处理分页信息
        myPageInfo.setData(appointments);
        //将用户数据封装到PageInfo 中
        PageInfo page = new PageInfo(myPageInfo.getData());
        //设置数据数量
        myPageInfo.setCount(page.getPageSize());
        //设置成功代码
        myPageInfo.setCode("0");

        //System.out.println("=====" + myPageInfo + "=====");


        return myPageInfo;
    }

    @GetMapping("/appointment/treatedAppointments")
    public MyPageInfo<Appointment> untreatedAppointments(MyPageInfo<Appointment> myPageInfo, HttpSession session) {
        //获取医师信息
        Employee employee = (Employee) session.getAttribute("employee");
        //根据员工id查询未处理预约记录
        List<Appointment> appointments = appointmentService.findTreatedAppointment(employee.getEmployeeId());

        //没有预约记录，返回空
        if (appointments.isEmpty()) {
            PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());
            //处理分页信息
            myPageInfo.setData(appointments);
            //将用户数据封装到PageInfo 中
            PageInfo page = new PageInfo(myPageInfo.getData());
            //设置成功代码
            myPageInfo.setCode("0");
            //设置数据数量
            myPageInfo.setCount(0);
            return myPageInfo;
        }
        //开启分页
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());

        //获取科室信息
        Branch branch = new Branch();
        branch.setBranchId(appointments.get(0).getBranchId());
        branch = branchService.queryBranchByParam(branch).get(0);

        //获取预约记录所有相关属性
        for (int i = 0; i < appointments.size(); i++) {
            //遍历每一个未处理的预约记录
            Appointment appointment = appointments.get(i);

            //所有未处理预约归当前医师管理
            appointment.setEmployee(employee);

            //获取患者信息
            Patient patient = new Patient();
            patient.setPatientId(appointment.getPatientId());
            patient = patientService.queryPatientByParam(patient).get(0);
            appointment.setPatient(patient);

            //获取科室信息
            appointment.setBranch(branch);
        }

        //System.out.println("=====" + appointments + "=====");

        //处理分页信息
        myPageInfo.setData(appointments);
        //将用户数据封装到PageInfo 中
        PageInfo page = new PageInfo(myPageInfo.getData());
        //设置成功代码
        myPageInfo.setCode("0");
        //设置数据数量
        myPageInfo.setCount(page.getPageSize());

        //System.out.println("=====" + myPageInfo + "=====");


        return myPageInfo;
    }

    @PutMapping("/appointment")
    public String updateAppointment(Appointment appointment) {
        if (appointment != null && appointment.getAppointmentId() != null) {
            appointment.setAppointmentStatus(1);
            appointmentService.updateAppointment(appointment);
            return "success";
        }
        return "error";
    }
}