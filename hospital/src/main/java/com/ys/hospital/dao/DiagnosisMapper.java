package com.ys.hospital.dao;

import com.ys.hospital.pojo.Diagnosis;

import java.util.List;

/**
 * (Diagnosis)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface DiagnosisMapper {

    /**
     * 查询所有Diagnosis信息
     *
     * @return 对象Diagnosis列表
     */
    List<Diagnosis> queryAllDiagnosis();


    /**
     * 根据实体类Diagnosis的相关属性查询实体类Diagnosis
     *
     * @param diagnosis 实例对象
     * @return 对象Diagnosis列表
     */
    List<Diagnosis> queryDiagnosisByParam(Diagnosis diagnosis);

    /**
     * 新增Diagnosis数据
     *
     * @param diagnosis 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertDiagnosis(Diagnosis diagnosis);

    /**
     * 修改Diagnosis数据
     *
     * @param diagnosis 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int updateDiagnosis(Diagnosis diagnosis);

    /**
     * 通过主键删除数据
     *
     * @param diagnosisId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteDiagnosisById(Integer diagnosisId);

    List<Diagnosis> queryDealingDiagnosis(Integer employeeId);
}