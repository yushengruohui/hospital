package com.ys.hospital.dao;

import com.ys.hospital.pojo.AiPrescription;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (AiPrescription)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface AiPrescriptionMapper {

    /**
     * 查询所有AiPrescription信息
     *
     * @return 对象AiPrescription列表
     */
    List<AiPrescription> queryAllAiPrescription();


    /**
     * 根据实体类AiPrescription的相关属性查询实体类AiPrescription
     *
     * @param aiPrescription 实例对象
     * @return 对象AiPrescription列表
     */
    List<AiPrescription> queryAiPrescriptionByParam(AiPrescription aiPrescription);

    /**
     * 新增AiPrescription数据
     *
     * @param aiPrescription 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertAiPrescription(AiPrescription aiPrescription);

    /**
     * 修改AiPrescription数据
     *
     * @param aiPrescription 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int updateAiPrescription(AiPrescription aiPrescription);

    /**
     * 通过主键删除数据
     *
     * @param aiPrescriptionId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteAiPrescriptionById(Integer aiPrescriptionId);

}