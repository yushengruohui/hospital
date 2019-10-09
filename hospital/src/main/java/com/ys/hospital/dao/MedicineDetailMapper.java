package com.ys.hospital.dao;

import com.ys.hospital.pojo.MedicineDetail;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (MedicineDetail)表数据库访问层
 *
 * @author yusheng
 * @since 2019-09-26 16:16:21
 */
public interface MedicineDetailMapper {

    /**
     * 查询所有MedicineDetail信息
     *
     * @return 对象MedicineDetail列表
     */
    List<MedicineDetail> queryAllMedicineDetail();


    /**
     * 根据实体类MedicineDetail的相关属性查询实体类MedicineDetail
     *
     * @param medicineDetail 实例对象
     * @return 对象MedicineDetail列表
     */
    List<MedicineDetail> queryMedicineDetailByParam(MedicineDetail medicineDetail);

    /**
     * 新增MedicineDetail数据
     *
     * @param medicineDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertMedicineDetail(MedicineDetail medicineDetail);

    /**
     * 修改MedicineDetail数据
     *
     * @param medicineDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
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