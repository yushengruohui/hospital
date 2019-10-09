package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.WorkTime;
import com.ys.hospital.dao.WorkTimeMapper;
import com.ys.hospital.service.WorkTimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (WorkTime)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-09 09:00:07
 */
@Service("workTimeService")
public class WorkTimeServiceImpl implements WorkTimeService {
    private static final Logger logger = LoggerFactory.getLogger(WorkTimeServiceImpl.class);
    
    @Resource
    private WorkTimeMapper workTimeMapper;

    /**
     * 查询所有WorkTime信息
     *
     * @return 对象WorkTime列表
     */
    @Override
    public List<WorkTime> queryAllWorkTime() {
        return this.workTimeMapper.queryAllWorkTime();
    }

    /**
     * 新增WorkTime数据
     *
     * @param workTime 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertWorkTime(WorkTime workTime) {
        return this.workTimeMapper.insertWorkTime(workTime);
    }

    /**
     * 修改WorkTime数据
     *
     * @param workTime 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateWorkTime(WorkTime workTime) {
        return this.workTimeMapper.updateWorkTime(workTime);
    }

    /**
     * 通过主键删除WorkTime数据
     *
     * @param workTimeId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteWorkTimeById(Integer workTimeId) {
        return this.workTimeMapper.deleteWorkTimeById(workTimeId);
    }
}