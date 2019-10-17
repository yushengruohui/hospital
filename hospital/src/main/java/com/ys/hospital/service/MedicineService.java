package com.ys.hospital.service;

import com.ys.hospital.pojo.Medicine;

import java.util.List;

/**
 * (Medicine)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface MedicineService {

    /**
     * 查询所有Medicine信息
     *
     * @return 实例对象
     */
    List<Medicine> queryAllMedicine();

    /**
     * 新增数据
     *
     * @param medicine 实例对象
     * @return 实例对象
     */
    int insertMedicine(Medicine medicine);

    /**
     * 修改数据
     *
     * @param medicine 实例对象
     * @return 实例对象
     */
    int updateMedicine(Medicine medicine);

    /**
     * 通过主键删除数据
     *
     * @param medicineId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteMedicineById(Integer medicineId);

    String queryMedicineName(String medicineTip);

    Integer queryMedicineId(String medicineName);

    double queryMedicinePrice(Integer medicineId);
}