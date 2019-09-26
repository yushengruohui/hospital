package com.ys.hospital.service;

import com.ys.hospital.pojo.DiagnosisMedicineDetail;
import java.util.List;

/**
 * (DiagnosisMedicineDetail)表服务接口
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
public interface DiagnosisMedicineDetailService {

    /**
     * 查询所有DiagnosisMedicineDetail信息
     *
     * @return 实例对象
     */
    List<DiagnosisMedicineDetail> queryAllDiagnosisMedicineDetail();

    /**
     * 新增数据
     *
     * @param diagnosisMedicineDetail 实例对象
     * @return 实例对象
     */
    int insertDiagnosisMedicineDetail(DiagnosisMedicineDetail diagnosisMedicineDetail);

    /**
     * 修改数据
     *
     * @param diagnosisMedicineDetail 实例对象
     * @return 实例对象
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