package com.ys.hospital.controller;


import com.ys.hospital.pojo.*;
import com.ys.hospital.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 微信小程序controller
 */
@RequestMapping("/wx")
@RestController
public class WxController {

    @Resource
    private ClientService clientService;
    @Resource
    private AiGuideService aiGuideService;
    @Resource
    private PatientService patientService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private BranchService branchService;

    /**
     * 登录(返回登陆后的信息)
     *
     * @param client
     * @return Client对象:登录后的用户对象
     */
    @RequestMapping("/login")
    public Client login(Client client) {
        //检查手机号是否已经存在;存在：获取相应的信息；不存在：将手机号存入，并获取相应的用户信息
        //获取返回的client信息
        Client client1 = clientService.findClientByClient(client);
        //存在，获取信息发送到前台
        if (client1 != null) {
            return client1;
        } else {
            //将用户信息存储数据库
            return clientService.insertClient(client);
        }
    }

    /**
     * 获取账号绑定的就诊人信息
     *
     * @param clientId
     * @return list:用户绑定的就诊人列表
     */
    @RequestMapping("/getPatientListByClientId")
    public List<Patient> getPatientListByClientId(int clientId) {

        List<Patient> list = new ArrayList<>();
        list = patientService.getPatientListByClientId(clientId);
        return list;
    }

    /**
     * 智能导诊(返回回复信息)
     *
     * @param key
     * @return aiGuide:智能导诊的回复对象
     */
    @RequestMapping("/guide")
    public AiGuide guide(String key) {
        //查询智能回复信息，如果存在：返回智能表中的信息，如果不存在返回自定义信息
        AiGuide aiGuide = aiGuideService.guide(key);
        return aiGuide;
    }

    /**
     * 获取就诊人详细信息
     *
     * @param patientId
     * @return patient:就诊人对象
     */
    @RequestMapping("/getPatientDetail")
    public Patient getPatientDetailByPatientId(int patientId) {
        Patient patient = patientService.getPatientDetailByPatientId(patientId);
        return patient;
    }

    /**
     * 添加就诊人信息（返回信息为患者列表）
     *
     * @param patient
     * @return 1.null:就诊人已经被绑定无法继续绑定(返回null);2.list:绑定成功,返回用户绑定的就诊人列表
     */
    @RequestMapping("/addPatient")
    public List<Patient> addPatient(Patient patient) {
        System.out.println("=====" + patient.getClientId() + "=====");

        List<Patient> list = new ArrayList<>();
        //根据身份证号查询就诊人信息
        Patient patient1 = patientService.getPatientBypatientIdentity(patient.getPatientIdentity());
        //如果身份证对应的就诊人不存在，新增
        if (patient1 == null) {
            //新增
            patientService.addPatient(patient);

            //根据就身份证存在且clientId与传过来的clientId相同，修改
        } else if (patient1.getClientId() == patient.getClientId()) {
            //将查询到的就诊人的编号赋值给修改的就诊人
            patient.setPatientId(patient1.getPatientId());
            //根据就诊人Id修改就诊人信息
            patientService.updatePatient(patient);
        } else if (patient1.getClientId() == null) {
            //如果身份证存在且身份证没绑定账号,对其进行绑定
            patient.setPatientId(patient1.getPatientId());
            patientService.updatePatient(patient);
        } else {
            //如果身份证号存在但clientId与传过来的clientId不相同，提示已绑定其他账号，先解绑
            return list;
        }
        //返回用户绑定就诊人列表
        list = patientService.getPatientListByClientId(patient.getClientId());
        return list;
    }

    /**
     * 解绑就诊人,并返回用户就诊人列表
     *
     * @param patient
     * @return list:解绑成功,返回用户绑定的就诊人列表
     */
    @RequestMapping("/unbinding")
    public List<Patient> unbinding(Patient patient) {
        //根据就诊编号查询就诊人信息
        Patient patient1 = patientService.getPatientDetailByPatientId(patient.getPatientId());
        //将其绑定的账号设为null
        patient1.setClientId(null);
        //修改就诊人信息
        patientService.updatePatientClientId(patient1);
        //查询用户绑定的就诊人列表
        List<Patient> list = patientService.getPatientListByClientId(patient.getClientId());
        return list;
    }

    /**
     * 查询所有科信息(如内科,外科等科)
     *
     * @return list
     */
    @RequestMapping("/getDepartmentList")
    public List<Department> getDepartmentList() {
        List<Department> departmentList = departmentService.getDepartmentList();
        return departmentList;
    }

    /**
     * 根据父科的id查询其对应的子科目的列表
     *
     * @param departmentId
     * @return branchList(子科目列表)
     */
    @RequestMapping("/getBranchListByDepartmentId")
    public List<Branch> getBranchListByDepartmentId(int departmentId) {

        List<Branch> branchList = branchService.getBranchListByDepartmentId(departmentId);
        return branchList;
    }

}
