package com.ys.hospital.service.impl;

import com.ys.hospital.dao.DiagnosisMapper;
import com.ys.hospital.pojo.Diagnosis;
import com.ys.hospital.service.DiagnosisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Diagnosis)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Service("diagnosisService")
public class DiagnosisServiceImpl implements DiagnosisService {
    private static final Logger logger = LoggerFactory.getLogger(DiagnosisServiceImpl.class);

    @Resource
    private DiagnosisMapper diagnosisMapper;

    /**
     * 查询所有Diagnosis信息
     *
     * @return 对象Diagnosis列表
     */
    @Override
    public List<Diagnosis> queryAllDiagnosis() {
        return this.diagnosisMapper.queryAllDiagnosis();
    }

    /**
     * 新增Diagnosis数据
     *
     * @param diagnosis 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int insertDiagnosis(Diagnosis diagnosis) {
        if (diagnosis == null) {
            return 0;
        }
        return this.diagnosisMapper.insertDiagnosis(diagnosis);
    }

    /**
     * 修改Diagnosis数据
     *
     * @param diagnosis 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int updateDiagnosis(Diagnosis diagnosis) {
        return this.diagnosisMapper.updateDiagnosis(diagnosis);
    }

    /**
     * 通过主键删除Diagnosis数据
     *
     * @param diagnosisId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int deleteDiagnosisById(Integer diagnosisId) {
        return this.diagnosisMapper.deleteDiagnosisById(diagnosisId);
    }

    @Override
    public List<Diagnosis> queryDiagnosisListByParam(Diagnosis diagnosis) {
        return this.diagnosisMapper.queryDiagnosisByParam(diagnosis);
    }

    @Override
    public List<Diagnosis> queryDealingDiagnosis(Integer employeeId) {
        return this.diagnosisMapper.queryDealingDiagnosis(employeeId);
    }
}