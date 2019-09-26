package com.ys.hospital.service;

import com.ys.hospital.pojo.Patient;
import java.util.List;

/**
 * (Patient)表服务接口
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
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
     * @return 是否成功(1：成功|0：失败)
     */
    int deletePatientById(Integer patientId);

}