package com.ys.hospital.dao;

import com.ys.hospital.pojo.Patient;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Patient)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface PatientMapper {

    /**
     * 查询所有Patient信息
     *
     * @return 对象Patient列表
     */
    List<Patient> queryAllPatient();


    /**
     * 根据实体类Patient的相关属性查询实体类Patient
     *
     * @param patient 实例对象
     * @return 对象Patient列表
     */
    List<Patient> queryPatientByParam(Patient patient);

    /**
     * 新增Patient数据
     *
     * @param patient 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertPatient(Patient patient);

    /**
     * 修改Patient数据
     *
     * @param patient 实例对象
     * @return 是否成功(1：成功|0：失败)
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