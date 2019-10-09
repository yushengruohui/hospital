package com.ys.hospital.service;

import com.ys.hospital.pojo.AiPrescription;
import java.util.List;

/**
 * (AiPrescription)表服务接口
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
public interface AiPrescriptionService {

    /**
     * 查询所有AiPrescription信息
     *
     * @return 实例对象
     */
    List<AiPrescription> queryAllAiPrescription();

    /**
     * 新增数据
     *
     * @param aiPrescription 实例对象
     * @return 实例对象
     */
    int insertAiPrescription(AiPrescription aiPrescription);

    /**
     * 修改数据
     *
     * @param aiPrescription 实例对象
     * @return 实例对象
     */
    int updateAiPrescription(AiPrescription aiPrescription);

    /**
     * 通过主键删除数据
     *
     * @param aiPrescriptionId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteAiPrescriptionById(Integer aiPrescriptionId);

}