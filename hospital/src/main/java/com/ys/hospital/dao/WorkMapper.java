package com.ys.hospital.dao;

import com.ys.hospital.pojo.Work;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Work)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-12 11:38:03
 */
public interface WorkMapper {

    /**
     * 查询所有Work信息
     *
     * @return 对象Work列表
     */
    List<Work> queryAllWork();


    /**
     * 根据实体类Work的相关属性查询实体类Work
     *
     * @param work 实例对象
     * @return 对象Work列表
     */
    List<Work> queryWorkByParam(Work work);

    /**
     * 新增Work数据
     *
     * @param work 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertWork(Work work);

    /**
     * 修改Work数据
     *
     * @param work 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int updateWork(Work work);

    /**
     * 通过主键删除数据
     *
     * @param workId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteWorkById(Integer workId);

}