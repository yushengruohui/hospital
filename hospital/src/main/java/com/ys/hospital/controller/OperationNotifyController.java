package com.ys.hospital.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ys.hospital.pojo.*;
import com.ys.hospital.service.*;
import com.ys.hospital.tools.MyPageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (OperationNotify)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Controller
@RequestMapping("/operationNotify")
public class OperationNotifyController {
    private static final Logger logger = LoggerFactory.getLogger(OperationNotifyController.class);

    @Resource
    private OperationNotifyService operationNotifyService;
    @Resource
    private DiagnosisService diagnosisService;
    @Resource
    private AppointmentService appointmentService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private PatientService patientService;
    @RequestMapping("/test")
    public String testDome() {
        logger.info("testDome success");
        return "redirect:/";
    }

/**
     * 页面跳转
     * @return ModelAndView
     */
    @RequestMapping("/findoperationNotify")
    public ModelAndView findoperatioNotifyn() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("operation/findOperationNotify");
        return modelAndView;
    }
    /**
     * 查找所有手术通知
     * @return ModelAndView
     */
    @RequestMapping("/queryAllOperationNotify")
    @ResponseBody
    public MyPageInfo<OperationNotify> queryAllOperationNotify(HttpSession session, MyPageInfo<OperationNotify> myPageInfo) {
        PageHelper.startPage(myPageInfo.getPage(), myPageInfo.getLimit());
        List<OperationNotify> operationNotifys = operationNotifyService.queryAllOperationNotify();
        for (OperationNotify operationNotify : operationNotifys) {
            Diagnosis diagnosis=new Diagnosis();
            diagnosis.setDiagnosisId(operationNotify.getDiagnosisId());
            List<Diagnosis> diagnoses = diagnosisService.queryDiagnosisListByParam(diagnosis);
            Diagnosis diagnosis1=diagnoses.get(0);
            operationNotify.setDiagnosis(diagnosis1);

            //预约单设置
            Appointment appointment = appointmentService.getAppointmentByAppointmentId(diagnosis1.getAppointmentId());
            diagnosis1.setAppointment(appointment);

            //诊断医师设置
            Employee employee=employeeService.getEmployeeByEmployeeId(appointment.getEmployeeId());
            appointment.setEmployee(employee);
            //病人信息设置
             Patient patient=patientService.getPatientDetailByPatientId(appointment.getPatientId());
            appointment.setPatient(patient);
        }
        System.out.println(operationNotifys.size());
        myPageInfo.setData(operationNotifys);
        PageInfo page = new PageInfo(myPageInfo.getData());
        myPageInfo.setCode("0");
        myPageInfo.setCount(page.getPageSize());
        return myPageInfo;
    }
}