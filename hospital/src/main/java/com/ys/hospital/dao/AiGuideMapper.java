package com.ys.hospital.dao;

import com.ys.hospital.pojo.AiGuide;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (AiGuide)表数据库访问层
 *
 * @author makejava
 * @since 2019-10-06 13:31:46
 */
public interface AiGuideMapper {

    /**
     * 根据传入的关键字，查找回复的内容
     *
     * @param key
     * @return
     */
    public AiGuide guide(String key);

}