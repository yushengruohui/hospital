package com.ys.hospital.service;

import com.ys.hospital.pojo.AiGuide;
import java.util.List;

/**
 * (AiGuide)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface AiGuideService {

    /**
     * 查询所有AiGuide信息
     *
     * @return 实例对象
     */
    List<AiGuide> queryAllAiGuide();

    /**
     * 新增数据
     *
     * @param aiGuide 实例对象
     * @return 实例对象
     */
    int insertAiGuide(AiGuide aiGuide);

    /**
     * 修改数据
     *
     * @param aiGuide 实例对象
     * @return 实例对象
     */
    int updateAiGuide(AiGuide aiGuide);

    /**
     * 通过主键删除数据
     *
     * @param aiguideId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteAiGuideById(Integer aiguideId);

}