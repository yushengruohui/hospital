package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Work;
import com.ys.hospital.dao.WorkMapper;
import com.ys.hospital.service.WorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Work)表服务实现类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:46
 */
@Service("workService")
public class WorkServiceImpl implements WorkService {
    private static final Logger logger = LoggerFactory.getLogger(WorkServiceImpl.class);
    
    @Resource
    private WorkMapper workMapper;

    /**
     * 查询所有Work信息
     *
     * @return 对象Work列表
     */
    @Override
    public List<Work> queryAllWork() {
        return this.workMapper.queryAllWork();
    }

    /**
     * 新增Work数据
     *
     * @param work 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertWork(Work work) {
        return this.workMapper.insertWork(work);
    }

    /**
     * 修改Work数据
     *
     * @param work 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateWork(Work work) {
        return this.workMapper.updateWork(work);
    }

    /**
     * 通过主键删除Work数据
     *
     * @param workId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteWorkById(Integer workId) {
        return this.workMapper.deleteWorkById(workId);
    }
}