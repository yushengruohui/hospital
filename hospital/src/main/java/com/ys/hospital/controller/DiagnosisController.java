package com.ys.hospital.controller;

import com.ys.hospital.pojo.*;
import com.ys.hospital.service.*;
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
    @Resource
    private MedicineService medicineService;
    @Resource
    private DiagnosisMedicineService diagnosisMedicineService;
    @Resource
    private DiagnosisMedicineDetailService diagnosisMedicineDetailService;

    @PostMapping("/diagnosis")
    public String insertDiagnosis(Diagnosis diagnosis, HttpSession session) {

        //根据医师选择，修改诊断单状态
        if (diagnosis.getDiagnosisIsCheck() == 1 || diagnosis.getDiagnosisIsOperation() == 1) {
            //需要检查或者住院
            diagnosis.setDiagnosisStatus("正在处理");
        } else {
            diagnosis.setDiagnosisStatus("已处理");
        }
        //添加处方，未支付
        DiagnosisMedicine diagnosisMedicine = new DiagnosisMedicine();
        diagnosisMedicine.setDiagnosisMedicineStatus(0);
        diagnosisMedicine.setDiagnosisMedicinePayStatus(0);
        diagnosisMedicine.setDiagnosisId(diagnosis.getDiagnosisId());
        diagnosisMedicineService.insertDiagnosisMedicine(diagnosisMedicine);


        //处理处方笺，获取真正的药名和药品数量diagnosis_prescription
        String temp = diagnosis.getDiagnosisPrescription();
        double totalPrice = 0;
        //遇到回车，划分出一种药和药的数量的子字符串
        String[] nameAndNumbers = temp.split("\n");
        for (int i = 0; i < nameAndNumbers.length; i++) {
            //准备插入处方药品详情的数据
            Integer medicineId = null;
            Integer nums = null;
            DiagnosisMedicineDetail diagnosisMedicineDetail = new DiagnosisMedicineDetail();

            //遇到空格，再把药品名和药品分开
            String[] nameAndNumber = nameAndNumbers[i].split(" ");
            for (int j = 0; j < nameAndNumber.length; j++) {
                if (j % 2 == 0) {
                    //药名
                    String name = nameAndNumber[j];
                    if (name.isEmpty() || name.equals(" ")) {
                        continue;
                    }
                    medicineId = medicineService.queryMedicineId(name);
                } else {
                    //药品数量
                    String number = nameAndNumber[j];
                    double price = medicineService.queryMedicinePrice(medicineId);
                    nums = Integer.valueOf(number);
                    totalPrice += (price * nums);
                }
            }

            diagnosisMedicineDetail.setMedicineId(medicineId);
            diagnosisMedicineDetail.setMedicineNumber(nums);
            diagnosisMedicineDetail.setDiagnosisMedicineId(diagnosisMedicine.getDiagnosisMedicineId());

            diagnosisMedicineDetailService.insertDiagnosisMedicineDetail(diagnosisMedicineDetail);
            diagnosisMedicine.setDiagnosisMedicinePrice(totalPrice);
            diagnosisMedicineService.updateDiagnosisMedicine(diagnosisMedicine);

        }

        //插入诊断记录
        int flag = diagnosisService.insertDiagnosis(diagnosis);

        //填写完成
        if (flag == 1) {
            //更新该患者的预约记录状态未已处理
            Appointment appointment = new Appointment();
            appointment.setAppointmentId(diagnosis.getAppointmentId());
            appointment.setAppointmentStatus(1);
            appointmentService.updateAppointment(appointment);
            //移除会话中的一些属性
            session.removeAttribute("diagnosis");
            session.removeAttribute("appointment");
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