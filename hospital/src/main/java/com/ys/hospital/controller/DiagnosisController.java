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
    @Resource
    private OperationNotifyService operationNotifyService;
    @Resource
    private OperationService operationService;

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
    public String insertCheckItem(String checkItemIdList, String diagnosisId) {

        Integer checkItemId = null;
        //准备插入的检查数据
        Check check = new Check();
        //设计一条检查记录的数据
        check.setCheckStatus(0);
        check.setCheckTime(new Date());
        check.setDiagnosisId(Integer.valueOf(diagnosisId));

        //插入检查记录，check会获得一个checkId
        checkService.insertCheck(check);
        //检查费用
        double checkPrice = 0;

        //准备插入的检查详细数据
        String[] checkItemIds = checkItemIdList.split(",");
        for (int i = 0; i < checkItemIds.length; i++) {
            //把前台传过来的checkItemId转成Integer类型
            checkItemId = Integer.valueOf(checkItemIds[i]);

            //统计检查费
            double price = checkService.queryPrice(checkItemId);
            checkPrice += price;

            //准备checkDetail记录的插入数据
            CheckDetail checkDetail = new CheckDetail();

            //设计一条checkDetail记录的数据
            checkDetail.setCheckId(check.getCheckId());
            checkDetail.setCheckItemId(checkItemId);
            checkDetail.setCheckDetailPayPrice(price);
            checkDetail.setCheckDetailPayStatus(0);

            //添加一条checkDetail记录
            checkDetailService.insertCheckDetail(checkDetail);

        }

        //更新check记录
        check.setCheckPrice(checkPrice);
        checkService.updateCheck(check);

        return "success";
    }

    @PostMapping("/diagnosis/operation")
    public String inOperation(String operationName, String diagnosisId) {
        //设计准备添加的手术通知的数据
        OperationNotify operationNotify = new OperationNotify();
        operationNotify.setOperationNotifyStatus(0);
        operationNotify.setDiagnosisId(Integer.valueOf(diagnosisId));
        //添加一条手术通知记录
        operationNotifyService.insertOperationNotify(operationNotify);

        //设计准备添加的手术的数据
        Operation operation = new Operation();
        operation.setOperationName(operationName);
        operation.setOperationStatus(0);
        operation.setOperationNotifyId(operationNotify.getOperationNotifyId());
        operation.setOperationPayStatus(0);
        //添加一条未处理的手术的记录
        operationService.insertOperation(operation);

        return "success";
    }
}