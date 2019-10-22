package com.ys.hospital.dao;

import com.ys.hospital.pojo.WorkTime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (WorkTime)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface WorkTimeMapper {

    /**
     * 查询所有WorkTime信息
     *
     * @return 对象WorkTime列表
     */
    List<WorkTime> queryAllWorkTime();


    /**
     * 根据实体类WorkTime的相关属性查询实体类WorkTime
     *
     * @param workTime 实例对象
     * @return 对象WorkTime列表
     */
    List<WorkTime> queryWorkTimeByParam(WorkTime workTime);

    /**
     * 新增WorkTime数据
     *
     * @param workTime 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertWorkTime(WorkTime workTime);

    /**
     * 修改WorkTime数据
     *
     * @param workTime 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int updateWorkTime(WorkTime workTime);

    /**
     * 通过主键删除数据
     *
     * @param workTimeId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteWorkTimeById(Integer workTimeId);

}