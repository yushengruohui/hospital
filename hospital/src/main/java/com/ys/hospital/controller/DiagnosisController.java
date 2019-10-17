package com.ys.hospital.controller;

import com.ys.hospital.pojo.Appointment;
import com.ys.hospital.pojo.Check;
import com.ys.hospital.pojo.CheckDetail;
import com.ys.hospital.pojo.Diagnosis;
import com.ys.hospital.service.AppointmentService;
import com.ys.hospital.service.CheckDetailService;
import com.ys.hospital.service.CheckService;
import com.ys.hospital.service.DiagnosisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

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
    @Resource
    private CheckService checkService;
    @Resource
    private CheckDetailService checkDetailService;

    @PostMapping("/diagnosis")
    public String insertDiagnosis(Diagnosis diagnosis, HttpSession session) {

        //根据医师选择，修改诊断单状态
        if (diagnosis.getDiagnosisIsCheck() == 1 || diagnosis.getDiagnosisIsOperation() == 1) {
            //需要检查或者住院
            diagnosis.setDiagnosisStatus("正在处理");
        } else {
            diagnosis.setDiagnosisStatus("已处理");
        }

        //处理处方笺，获取真正的药名和药品数量diagnosis_prescription
        String temp = diagnosis.getDiagnosisPrescription();
        //遇到回车，划分出一种药和药的数量的子字符串
        String[] nameAndNumbers = temp.split("\n");
        for (int i = 0; i < nameAndNumbers.length; i++) {
            //遇到空格，再把药品名和药品分开
            String[] nameAndNumber = nameAndNumbers[i].split(" ");
            for (int j = 0; j < nameAndNumber.length; j++) {
                if (j % 2 == 0) {
                    //药名
                    String name = nameAndNumber[j];

                } else {
                    //药品数量
                    String number = nameAndNumber[j];
                }
            }
        }

        //插入诊断记录
        int flag = diagnosisService.insertDiagnosis(diagnosis);
        //移除会话中的一些属性
        session.removeAttribute("diagnosis");
        session.removeAttribute("appointment");
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

    @PostMapping("/diagnosis/checkItem")
    public String insertCheckItem(List<Integer> checkItemIdList, Integer diagnosisId) {
        Integer checkItemId = null;
        //准备插入的检查数据
        Check check = new Check();
        check.setCheckStatus(0);
        check.setCheckTime(new Date());
        check.setDiagnosisId(diagnosisId);
        checkService.insertCheck(check);

        //准备插入的检查详细数据
        for (int i = 0; i < checkItemIdList.size(); i++) {
            checkItemId = checkItemIdList.get(i);
            CheckDetail checkDetail = new CheckDetail();
            checkDetail.setCheckId(check.getCheckId());
            checkDetail.setCheckItemId(checkItemId);
            checkDetailService.insertCheckDetail(checkDetail);
        }
        return "success";
    }
}