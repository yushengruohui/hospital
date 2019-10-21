package com.ys.hospital.service;

import com.ys.hospital.pojo.Diagnosis;

import java.util.List;

/**
 * (Diagnosis)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface DiagnosisService {

    /**
     * 查询所有Diagnosis信息
     *
     * @return 实例对象
     */
    List<Diagnosis> queryAllDiagnosis();

    /**
     * 新增数据
     *
     * @param diagnosis 实例对象
     * @return 实例对象
     */
    int insertDiagnosis(Diagnosis diagnosis);

    /**
     * 修改数据
     *
     * @param diagnosis 实例对象
     * @return 实例对象
     */
    int updateDiagnosis(Diagnosis diagnosis);

    /**
     * 通过主键删除数据
     *
     * @param diagnosisId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteDiagnosisById(Integer diagnosisId);

    List<Diagnosis> queryDiagnosisListByParam(Diagnosis diagnosis);

    List<Diagnosis> queryDealingDiagnosis(Integer employeeId);

    List<Diagnosis> queryDealtDiagnosis(Integer employeeId);
}