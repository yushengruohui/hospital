package com.ys.hospital.service;

import com.ys.hospital.pojo.Queue;

import java.util.List;

/**
 * (Queue)表服务接口
 *
 * @author yusheng
 * @since 2019-10-13 23:31:11
 */
public interface QueueService {

    /**
     * 查询所有Queue信息
     *
     * @return 实例对象
     */
    List<Queue> queryAllQueue();

    /**
     * 新增数据
     *
     * @param queue 实例对象
     * @return 实例对象
     */
    int insertQueue(Queue queue);

    /**
     * 修改数据
     *
     * @param queue 实例对象
     * @return 实例对象
     */
    int updateQueue(Queue queue);

    /**
     * 通过主键删除数据
     *
     * @param queue_Id 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteQueueById(Integer queue_Id);

    int findMaxNumber(Queue queue);

}