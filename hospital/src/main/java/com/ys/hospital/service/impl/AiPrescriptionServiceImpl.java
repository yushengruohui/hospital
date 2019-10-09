package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.AiPrescription;
import com.ys.hospital.dao.AiPrescriptionMapper;
import com.ys.hospital.service.AiPrescriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AiPrescription)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Service("aiPrescriptionService")
public class AiPrescriptionServiceImpl implements AiPrescriptionService {
    private static final Logger logger = LoggerFactory.getLogger(AiPrescriptionServiceImpl.class);
    
    @Resource
    private AiPrescriptionMapper aiPrescriptionMapper;

    /**
     * 查询所有AiPrescription信息
     *
     * @return 对象AiPrescription列表
     */
    @Override
    public List<AiPrescription> queryAllAiPrescription() {
        return this.aiPrescriptionMapper.queryAllAiPrescription();
    }

    /**
     * 新增AiPrescription数据
     *
     * @param aiPrescription 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertAiPrescription(AiPrescription aiPrescription) {
        return this.aiPrescriptionMapper.insertAiPrescription(aiPrescription);
    }

    /**
     * 修改AiPrescription数据
     *
     * @param aiPrescription 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateAiPrescription(AiPrescription aiPrescription) {
        return this.aiPrescriptionMapper.updateAiPrescription(aiPrescription);
    }

    /**
     * 通过主键删除AiPrescription数据
     *
     * @param aiPrescriptionId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteAiPrescriptionById(Integer aiPrescriptionId) {
        return this.aiPrescriptionMapper.deleteAiPrescriptionById(aiPrescriptionId);
    }
}