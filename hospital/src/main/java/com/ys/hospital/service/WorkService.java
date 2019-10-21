package com.ys.hospital.service;

import com.ys.hospital.pojo.Work;

import java.util.List;

/**
 * (Work)表服务接口
 *
 * @author yusheng
 * @since 2019-10-13 12:13:44
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
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteWorkById(Integer workId);

    /**
     * 根据科室id以及工作时间查询值班情况(room与work双表联查)
     *
     * @param branchId（科室表中的科室id）
     * @param time(工作时间)
     * @return works(工作列表)
     */
    List<Work> findWorksByBranchIdAndTime(int branchId, String time);

    /**
     * 根据医师Id与值班时间查找值班表
     *
     * @param employeeId
     * @param workDate
     * @return work(值班安排表信息)
     */
    Work findWorkByEmployeeIdAndWorkDate(Integer employeeId, String workDate);

    /**
     * 根据实体类Work的相关属性查询实体类Work
     *
     * @param work 实例对象
     * @return 对象Work列表
     */
    List<Work> queryWorkByParam(Work work);

    /**
     * 根据员工Id查询（一周）值班安排表
     *
     * @param employeeId
     * @return
     */
    List<Work> findWorkListByEmployeeId(Integer employeeId);
}