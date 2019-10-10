package com.ys.hospital.service;

import com.ys.hospital.pojo.Work;
import java.util.List;

/**
 * (Work)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface WorkService {

    /**
     * 查询所有Work信息
     *
     * @return 实例对象
     */
    List<Work> queryAllWork();

    /**
     * 新增数据
     *
     * @param work 实例对象
     * @return 实例对象
     */
    int insertWork(Work work);

    /**
     * 修改数据
     *
     * @param work 实例对象
     * @return 实例对象
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