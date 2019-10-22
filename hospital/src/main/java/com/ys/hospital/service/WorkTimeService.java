package com.ys.hospital.service;

import com.ys.hospital.pojo.WorkTime;

import java.util.List;

/**
 * (WorkTime)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface WorkTimeService {

    /**
     * 查询所有WorkTime信息
     *
     * @return 实例对象
     */
    List<WorkTime> queryAllWorkTime();

    /**
     * 新增数据
     *
     * @param workTime 实例对象
     * @return 实例对象
     */
    int insertWorkTime(WorkTime workTime);

    /**
     * 修改数据
     *
     * @param workTime 实例对象
     * @return 实例对象
     */
    int updateWorkTime(WorkTime workTime);

    /**
     * 通过主键删除数据
     *
     * @param workTimeId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteWorkTimeById(Integer workTimeId);

    /**
     * 根据实体类WorkTime的相关属性查询实体类WorkTime
     *
     * @param workTime 实例对象
     * @return 对象WorkTime列表
     */
    List<WorkTime> queryWorkTimeByParam(WorkTime workTime);

}