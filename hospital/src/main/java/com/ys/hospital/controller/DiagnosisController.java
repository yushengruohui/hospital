package com.ys.hospital.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ys.hospital.pojo.*;
import com.ys.hospital.service.*;
import com.ys.hospital.tools.MyPageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    //private static final Logger logger = LoggerFactory.getLogger(DiagnosisController.class);

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
    @Resource
    private InpatientService inpatientService;
    @Resource
    private InpatientNotifyService inpatientNotifyService;

    @GetMapping("/diagnosis/dealingDiagnosis")
    public MyPageInfo<Diagnosis> showDealingDiagnosis(MyPageInfo<Diagnosis> layuiPage, HttpSession session) {
        //获取当前登录的用户
        Employee employee = (Employee) session.getAttribute("employee");

        //开启分页
        PageHelper.startPage(layuiPage.getPage(), layuiPage.getLimit());
        //获取当前用户的所有正在处理的诊断记录
        List<Diagnosis> diagnoses = diagnosisService.queryDealingDiagnosis(employee.getEmployeeId());

        //把当前用户的所有正在处理的诊断记录存进layuiPage
        layuiPage.setData(diagnoses);

        //将数据封装到 PageInfo 中
        PageInfo page = new PageInfo(layuiPage.getData());
        //设置数据数量
        layuiPage.setCount(page.getPageSize());
        //设置成功代码
        layuiPage.setCode("0");

        return layuiPage;
    }

    @GetMapping("/diagnosis/dealtDiagnosis")
    public MyPageInfo<Diagnosis> showDiagnosis(MyPageInfo<Diagnosis> layuiPage, HttpSession session) {
        //获取当前登录的用户
        Employee employee = (Employee) session.getAttribute("employee");

        //开启分页
        PageHelper.startPage(layuiPage.getPage(), layuiPage.getLimit());
        //获取当前用户的所有正在处理的诊断记录
        List<Diagnosis> diagnoses = diagnosisService.queryDealtDiagnosis(employee.getEmployeeId());

        //把当前用户的所有正在处理的诊断记录存进layuiPage
        layuiPage.setData(diagnoses);

        //将数据封装到 PageInfo 中
        PageInfo page = new PageInfo(layuiPage.getData());
        //设置数据数量
        layuiPage.setCount(page.getPageSize());
        //设置成功代码
        layuiPage.setCode("0");

        return layuiPage;
    }

    @PostMapping("/diagnosis")
    public String insertDiagnosis(Diagnosis diagnosis, HttpSession session) {

        //根据医师选择，修改诊断单状态
        if (diagnosis.getDiagnosisIsCheck() == 1 || diagnosis.getDiagnosisIsOperation() == 1) {
            //需要检查或者住院
            diagnosis.setDiagnosisStatus("正在处理");
        } else {
            diagnosis.setDiagnosisStatus("已处理");
        }
        diagnosisService.insertDiagnosis(diagnosis);
        diagnosis.setDiagnosisTime(new Date());


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

        //更新诊断记录
        int flag = diagnosisService.updateDiagnosis(diagnosis);

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
        } else
            return "error";
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
    public String insertOperation(String operationName, String diagnosisId) {
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

        //同时添加一条住院记录
        InpatientNotify inpatientNotifyDTO = new InpatientNotify();
        inpatientNotifyDTO.setDiagnosisId(Integer.valueOf(diagnosisId));
        inpatientNotifyDTO.setInpatientNotifyStatus(0);

        inpatientNotifyService.insertInpatientNotify(inpatientNotifyDTO);
        return "success";
    }

    @PutMapping("/diagnosis")
    public String updateDiagnosis(Diagnosis diagnosis) {
        if (diagnosis != null && diagnosis.getDiagnosisId() != null) {
            diagnosis.setDiagnosisStatus("已处理");
            diagnosisService.updateDiagnosis(diagnosis);
            return "success";
        }
        return "error";
    }

}