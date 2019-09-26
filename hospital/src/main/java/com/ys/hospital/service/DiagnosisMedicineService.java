package com.ys.hospital.service;

import com.ys.hospital.pojo.DiagnosisMedicine;
import java.util.List;

/**
 * (DiagnosisMedicine)表服务接口
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
public interface DiagnosisMedicineService {

    /**
     * 查询所有DiagnosisMedicine信息
     *
     * @return 实例对象
     */
    List<DiagnosisMedicine> queryAllDiagnosisMedicine();

    /**
     * 新增数据
     *
     * @param diagnosisMedicine 实例对象
     * @return 实例对象
     */
    int insertDiagnosisMedicine(DiagnosisMedicine diagnosisMedicine);

    /**
     * 修改数据
     *
     * @param diagnosisMedicine 实例对象
     * @return 实例对象
     */
    int updateDiagnosisMedicine(DiagnosisMedicine diagnosisMedicine);

    /**
     * 通过主键删除数据
     *
     * @param diagnosisMedicineId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteDiagnosisMedicineById(Integer diagnosisMedicineId);

}