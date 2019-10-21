package com.ys.hospital.service;

import com.ys.hospital.pojo.Patient;

import java.util.List;

/**
 * (Patient)表服务接口
 *
 * @author yusheng
 * @since 2019-10-12 17:58:02
 */
public interface PatientService {

    /**
     * 查询所有Patient信息
     *
     * @return 实例对象
     */
    List<Patient> queryAllPatient();

    /**
     * 新增数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    int insertPatient(Patient patient);

    /**
     * 修改数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    int updatePatient(Patient patient);

    /**
     * 通过主键删除数据
     *
     * @param patientId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deletePatientById(Integer patientId);

    /**
     * 根据用户的手机号获取绑定的就诊人信息
     *
     * @param clientId
     * @return
     */
    List<Patient> getPatientListByClientId(int clientId);

    /**
     * 根据就诊人id查询就诊人信息
     *
     * @param patientId
     * @return
     */
    Patient getPatientDetailByPatientId(int patientId);

    /**
     * 根据身份证号查询就诊人信息
     *
     * @param patientIdentity
     * @return
     */
    Patient getPatientBypatientIdentity(String patientIdentity);

    /**
     * 添加就诊人信息
     *
     * @param patient
     * @return
     */
    int addPatient(Patient patient);

    /**
     * 根据就诊人id修改就诊人信息
     *
     * @param patient
     * @return
     */
    int updatePatientClientId(Patient patient);

    List<Patient> queryPatientByParam(Patient patient);
}