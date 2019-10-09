package com.ys.hospital.dao;

import com.ys.hospital.pojo.AiGuide;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (AiGuide)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
public interface AiGuideMapper {

    /**
     * 查询所有AiGuide信息
     *
     * @return 对象AiGuide列表
     */
    List<AiGuide> queryAllAiGuide();


    /**
     * 根据实体类AiGuide的相关属性查询实体类AiGuide
     *
     * @param aiGuide 实例对象
     * @return 对象AiGuide列表
     */
    List<AiGuide> queryAiGuideByParam(AiGuide aiGuide);

    /**
     * 新增AiGuide数据
     *
     * @param aiGuide 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertAiGuide(AiGuide aiGuide);

    /**
     * 修改AiGuide数据
     *
     * @param aiGuide 实例对象
     * @return 是否成功(1：成功|0：失败)
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