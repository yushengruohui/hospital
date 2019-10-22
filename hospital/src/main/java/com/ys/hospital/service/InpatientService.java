package com.ys.hospital.service;

import com.ys.hospital.pojo.Inpatient;
import java.util.List;

/**
 * (Inpatient)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface InpatientService {

    /**
     * 查询所有Inpatient信息
     *
     * @return 实例对象
     */
    List<Inpatient> queryAllInpatient();

    /**
     * 新增数据
     *
     * @param inpatient 实例对象
     * @return 实例对象
     */
    int insertInpatient(Inpatient inpatient);

    /**
     * 根据住院表ID查询住院信息
     * @param inpatientId
     * @return
     */
    List<Inpatient> queryInpatientByInpatientId(Integer inpatientId);

    /**
     * 修改数据
     *
     * @param inpatient 实例对象
     * @return 实例对象
     */
    int updateInpatient(Inpatient inpatient);

    /**
     * 通过主键删除数据
     *
     * @param inpatientId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteInpatientById(Integer inpatientId);

    /**
     * 通过inpatient相关属性查询住院信息
     * @param inpatient
     * @return
     */
    List<Inpatient> queryInpatientByParam(Inpatient inpatient);
}