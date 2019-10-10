package com.ys.hospital.dao;

import com.ys.hospital.pojo.DiagnosisMedicineDetail;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DiagnosisMedicineDetail)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface DiagnosisMedicineDetailMapper {

    /**
     * 查询所有DiagnosisMedicineDetail信息
     *
     * @return 对象DiagnosisMedicineDetail列表
     */
    List<DiagnosisMedicineDetail> queryAllDiagnosisMedicineDetail();


    /**
     * 根据实体类DiagnosisMedicineDetail的相关属性查询实体类DiagnosisMedicineDetail
     *
     * @param diagnosisMedicineDetail 实例对象
     * @return 对象DiagnosisMedicineDetail列表
     */
    List<DiagnosisMedicineDetail> queryDiagnosisMedicineDetailByParam(DiagnosisMedicineDetail diagnosisMedicineDetail);

    /**
     * 新增DiagnosisMedicineDetail数据
     *
     * @param diagnosisMedicineDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertDiagnosisMedicineDetail(DiagnosisMedicineDetail diagnosisMedicineDetail);

    /**
     * 修改DiagnosisMedicineDetail数据
     *
     * @param diagnosisMedicineDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int updateDiagnosisMedicineDetail(DiagnosisMedicineDetail diagnosisMedicineDetail);

    /**
     * 通过主键删除数据
     *
     * @param diagnosisMedicineDetailId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteDiagnosisMedicineDetailById(Integer diagnosisMedicineDetailId);

}