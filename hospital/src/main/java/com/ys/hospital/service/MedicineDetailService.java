package com.ys.hospital.service;

import com.ys.hospital.pojo.MedicineDetail;
import java.util.List;

/**
 * (MedicineDetail)表服务接口
 *
 * @author yusheng
 * @since 2019-09-26 16:16:21
 */
public interface MedicineDetailService {

    /**
     * 查询所有MedicineDetail信息
     *
     * @return 实例对象
     */
    List<MedicineDetail> queryAllMedicineDetail();

    /**
     * 新增数据
     *
     * @param medicineDetail 实例对象
     * @return 实例对象
     */
    int insertMedicineDetail(MedicineDetail medicineDetail);

    /**
     * 修改数据
     *
     * @param medicineDetail 实例对象
     * @return 实例对象
     */
    int updateMedicineDetail(MedicineDetail medicineDetail);

    /**
     * 通过主键删除数据
     *
     * @param medicineDetailId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteMedicineDetailById(Integer medicineDetailId);

}