package com.ys.hospital.service.impl;

import com.ys.hospital.dao.AiGuideMapper;
import com.ys.hospital.pojo.AiGuide;
import com.ys.hospital.service.AiGuideService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AiGuide)表服务实现类
 *
 * @author makejava
 * @since 2019-10-06 13:31:46
 */
@Service("aiGuideService")
public class AiGuideServiceImpl implements AiGuideService {
    private static final Logger logger = LoggerFactory.getLogger(AiGuideServiceImpl.class);

    @Autowired
    private AiGuideMapper aiGuideMapper;

    @Override
    public AiGuide guide(String key) {
        AiGuide aiGuide = new AiGuide();
        //如果查得到数据即将其对象返回
        if (aiGuideMapper.guide(key) != null) {
            return aiGuideMapper.guide(key);
        } else {//如果没有数据，将查不到的信息返回
            aiGuide.setAiguideContent("不好意思，这个问题小强还没学会呢");
            return aiGuide;
        }
    }
}