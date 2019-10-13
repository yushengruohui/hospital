package com.ys.hospital.dao;

import com.ys.hospital.pojo.Queue;

import java.util.List;

/**
 * (Queue)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-13 23:31:11
 */
public interface QueueMapper {

    /**
     * 查询所有Queue信息
     *
     * @return 对象Queue列表
     */
    List<Queue> queryAllQueue();


    /**
     * 根据实体类Queue的相关属性查询实体类Queue
     *
     * @param queue 实例对象
     * @return 对象Queue列表
     */
    List<Queue> queryQueueByParam(Queue queue);

    /**
     * 新增Queue数据
     *
     * @param queue 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertQueue(Queue queue);

    /**
     * 修改Queue数据
     *
     * @param queue 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int updateQueue(Queue queue);

    /**
     * 通过主键删除数据
     *
     * @param queue_Id 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteQueueById(Integer queue_Id);

    /**
     * 查询当天最大号码
     *
     * @param queue 当天日期和医师id
     * @return
     */
    int findMaxNumberByParam(Queue queue);

}