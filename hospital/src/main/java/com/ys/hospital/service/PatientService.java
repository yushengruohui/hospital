package com.ys.hospital.service;


import com.ys.hospital.pojo.Patient;

import java.util.List;

/**
 * (Patient)表服务接口
 *
 * @author makejava
 * @since 2019-10-07 15:14:52
 */
public interface PatientService {
    /**
     * 根据用户的手机号获取绑定的就诊人信息
     *
     * @param clientId
     * @return
     */
    public List<Patient> getPatientListByClientId(int clientId);

    /**
     * 根据就诊人id查询就诊人信息
     *
     * @param patientId
     * @return
     */
    public Patient getPatientDetailByPatientId(int patientId);

    /**
     * 根据身份证号查询就诊人信息
     *
     * @param patientIdentity
     * @return
     */
    public Patient getPatientBypatientIdentity(String patientIdentity);

    /**
     * 添加就诊人信息
     *
     * @param patient
     * @return
     */
    public int addPatient(Patient patient);

    /**
     * 根据就诊人id修改就诊人信息
     *
     * @param patient
     * @return
     */
    public int updatePatient(Patient patient);
}