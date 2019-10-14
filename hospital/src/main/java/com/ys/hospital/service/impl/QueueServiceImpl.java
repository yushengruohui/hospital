package com.ys.hospital.service.impl;

import com.ys.hospital.dao.QueueMapper;
import com.ys.hospital.pojo.Queue;
import com.ys.hospital.service.QueueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Queue)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-13 23:31:11
 */
@Service("queueService")
public class QueueServiceImpl implements QueueService {
    private static final Logger logger = LoggerFactory.getLogger(QueueServiceImpl.class);

    @Resource
    private QueueMapper queueMapper;

    /**
     * 查询所有Queue信息
     *
     * @return 对象Queue列表
     */
    @Override
    public List<Queue> queryAllQueue() {
        return this.queueMapper.queryAllQueue();
    }

    /**
     * 新增Queue数据
     *
     * @param queue 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int insertQueue(Queue queue) {
        return this.queueMapper.insertQueue(queue);
    }

    /**
     * 修改Queue数据
     *
     * @param queue 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int updateQueue(Queue queue) {
        return this.queueMapper.updateQueue(queue);
    }

    /**
     * 通过主键删除Queue数据
     *
     * @param queue_Id 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int deleteQueueById(Integer queue_Id) {
        return this.queueMapper.deleteQueueById(queue_Id);
    }

    @Override
    public int findMaxNumber(Queue queue) {
        Integer max = queueMapper.findMaxNumberByParam(queue);
        if (max == null) {
            return 0;
        }
        return max;
    }
}