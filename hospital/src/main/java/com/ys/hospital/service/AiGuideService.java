package com.ys.hospital.service;


import com.ys.hospital.pojo.AiGuide;

import java.util.List;

/**
 * (AiGuide)表服务接口
 *
 * @author makejava
 * @since 2019-10-06 13:31:46
 */
public interface AiGuideService {

    /**
     * 根据传入的关键字，查找回复的内容
     *
     * @param key
     * @return
     */
    public AiGuide guide(String key);

}