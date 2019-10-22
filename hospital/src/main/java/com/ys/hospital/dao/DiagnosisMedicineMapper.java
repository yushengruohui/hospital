package com.ys.hospital.dao;

import com.ys.hospital.pojo.DiagnosisMedicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (DiagnosisMedicine)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface DiagnosisMedicineMapper {

    /**
     * 查询所有DiagnosisMedicine信息
     *
     * @return 对象DiagnosisMedicine列表
     */
    List<DiagnosisMedicine> queryAllDiagnosisMedicine();


    /**
     * 根据实体类DiagnosisMedicine的相关属性查询实体类DiagnosisMedicine
     *
     * @param diagnosisMedicine 实例对象
     * @return 对象DiagnosisMedicine列表
     */
    List<DiagnosisMedicine> queryDiagnosisMedicineByParam(DiagnosisMedicine diagnosisMedicine);

    /**
     * 新增DiagnosisMedicine数据
     *
     * @param diagnosisMedicine 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertDiagnosisMedicine(DiagnosisMedicine diagnosisMedicine);

    /**
     * 修改DiagnosisMedicine数据
     *
     * @param diagnosisMedicine 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int updateDiagnosisMedicine(DiagnosisMedicine diagnosisMedicine);

    /**
     * 通过主键删除数据
     *
     * @param diagnosisMedicineId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteDiagnosisMedicineById(Integer diagnosisMedicineId);

}