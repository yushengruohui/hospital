package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.AiGuide;
import com.ys.hospital.dao.AiGuideMapper;
import com.ys.hospital.service.AiGuideService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AiGuide)表服务实现类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Service("aiGuideService")
public class AiGuideServiceImpl implements AiGuideService {
    private static final Logger logger = LoggerFactory.getLogger(AiGuideServiceImpl.class);
    
    @Resource
    private AiGuideMapper aiGuideMapper;

    /**
     * 查询所有AiGuide信息
     *
     * @return 对象AiGuide列表
     */
    @Override
    public List<AiGuide> queryAllAiGuide() {
        return this.aiGuideMapper.queryAllAiGuide();
    }

    /**
     * 新增AiGuide数据
     *
     * @param aiGuide 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertAiGuide(AiGuide aiGuide) {
        return this.aiGuideMapper.insertAiGuide(aiGuide);
    }

    /**
     * 修改AiGuide数据
     *
     * @param aiGuide 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateAiGuide(AiGuide aiGuide) {
        return this.aiGuideMapper.updateAiGuide(aiGuide);
    }

    /**
     * 通过主键删除AiGuide数据
     *
     * @param aiguideId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteAiGuideById(Integer aiguideId) {
        return this.aiGuideMapper.deleteAiGuideById(aiguideId);
    }
}