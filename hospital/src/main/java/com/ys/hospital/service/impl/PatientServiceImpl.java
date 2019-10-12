package com.ys.hospital.service.impl;

import com.ys.hospital.dao.PatientMapper;
import com.ys.hospital.pojo.Patient;
import com.ys.hospital.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Patient)表服务实现类
 *
 * @author makejava
 * @since 2019-10-07 15:14:52
 */
@Service("patientService")
public class PatientServiceImpl implements PatientService {
    private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Autowired
    private PatientMapper patientMapper;

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
    public int updatePatient(Patient patient) {
        return patientMapper.updatePatient(patient);
    }
}