package com.ys.hospital.service.impl;

import com.ys.hospital.dao.PatientMapper;
import com.ys.hospital.pojo.Patient;
import com.ys.hospital.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Patient)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-12 17:58:02
 */
@Service("patientService")
public class PatientServiceImpl implements PatientService {
    private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Resource
    private PatientMapper patientMapper;

    /**
     * 查询所有Patient信息
     *
     * @return 对象Patient列表
     */
    @Override
    public List<Patient> queryAllPatient() {
        return this.patientMapper.queryAllPatient();
    }

    /**
     * 新增Patient数据
     *
     * @param patient 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int insertPatient(Patient patient) {
        return this.patientMapper.insertPatient(patient);
    }

    /**
     * 修改Patient数据
     *
     * @param patient 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int updatePatient(Patient patient) {
        return this.patientMapper.updatePatient(patient);
    }

    /**
     * 通过主键删除Patient数据
     *
     * @param patientId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int deletePatientById(Integer patientId) {
        return this.patientMapper.deletePatientById(patientId);
    }

    @Override
    public List<Patient> getPatientListByClientId(int clientId) {
        return patientMapper.getPatientListByClientId(clientId);
    }

    @Override
    public Patient getPatientDetailByPatientId(int patientId) {
        return patientMapper.getPatientDetailByPatientId(patientId);
    }

    @Override
    public Patient getPatientBypatientIdentity(String patientIdentity) {
        return patientMapper.getPatientBypatientIdentity(patientIdentity);
    }

    @Override
    public int addPatient(Patient patient) {
        return patientMapper.addPatient(patient);
    }

    @Override
    public int updatePatientClientId(Patient patient) {
        return patientMapper.updatePatientClientId(patient);
    }

    @Override
    public List<Patient> queryPatientByParam(Patient patient) {
        if (patient == null) {
            return null;
        }
        return patientMapper.queryPatientByParam(patient);
    }
}