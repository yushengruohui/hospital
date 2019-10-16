package com.ys.hospital.controller;

import com.ys.hospital.pojo.Appointment;
import com.ys.hospital.pojo.Diagnosis;
import com.ys.hospital.service.AppointmentService;
import com.ys.hospital.service.DiagnosisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Diagnosis)表控制层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@RestController
public class DiagnosisController {
    private static final Logger logger = LoggerFactory.getLogger(DiagnosisController.class);

    @Resource
    private DiagnosisService diagnosisService;
    @Resource
    private AppointmentService appointmentService;

    @PostMapping("/diagnosis")
    public String insertDiagnosis(Diagnosis diagnosis) {

        //根据医师选择，修改诊断单状态
        if (diagnosis.getDiagnosisIsCheck() == 1 || diagnosis.getDiagnosisIsOperation() == 1) {
            //需要检查或者住院
            diagnosis.setDiagnosisStatus("正在处理");
        } else {
            diagnosis.setDiagnosisStatus("已处理");
        }

        //填写处方笺
        int flag = diagnosisService.insertDiagnosis(diagnosis);

        //填写完成
        if (flag == 1) {
            //更新该患者的预约记录状态未已处理
            Appointment appointment = new Appointment();
            appointment.setAppointmentId(diagnosis.getAppointmentId());
            appointment.setAppointmentStatus(1);
            appointmentService.updateAppointment(appointment);
            return "success";
        } else return "error";
    }


}