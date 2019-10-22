package com.ys.hospital.dao;

import com.ys.hospital.pojo.Medicine;

import java.util.List;

/**
 * (Medicine)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface MedicineMapper {

    /**
     * 查询所有Medicine信息
     *
     * @return 对象Medicine列表
     */
    List<Medicine> queryAllMedicine();


    /**
     * 根据实体类Medicine的相关属性查询实体类Medicine
     *
     * @param medicine 实例对象
     * @return 对象Medicine列表
     */
    List<Medicine> queryMedicineByParam(Medicine medicine);

    /**
     * 新增Medicine数据
     *
     * @param medicine 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertMedicine(Medicine medicine);

    /**
     * 修改Medicine数据
     *
     * @param medicine 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int updateMedicine(Medicine medicine);

    /**
     * 通过主键删除数据
     *
     * @param medicineId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteMedicineById(Integer medicineId);

    String queryMedicineNameByParam(String medicineTip);

    Integer queryMedicineId(String medicineName);

    double queryMedicinePrice(Integer medicineId);
}