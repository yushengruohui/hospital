package com.ys.hospital.dao;

import com.ys.hospital.pojo.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Work)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-13 12:13:44
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
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertWork(Work work);

    /**
     * 修改Work数据
     *
     * @param work 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
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
     * @return
     */
    Work findWorkByEmployeeIdAndWorkDate(Integer employeeId, String workDate);

    /**
     * 根据员工Id查询（一周）值班安排表
     *
     * @param employeeId
     * @return
     */
    List<Work> findWorkListByEmployeeId(Integer employeeId);
}