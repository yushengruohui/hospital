package com.ys.hospital.service;

import com.ys.hospital.pojo.EmployeeDetail;
import java.util.List;

/**
 * (EmployeeDetail)表服务接口
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
public interface EmployeeDetailService {

    /**
     * 查询所有EmployeeDetail信息
     *
     * @return 实例对象
     */
    List<EmployeeDetail> queryAllEmployeeDetail();

    /**
     * 新增数据
     *
     * @param employeeDetail 实例对象
     * @return 实例对象
     */
    int insertEmployeeDetail(EmployeeDetail employeeDetail);

    /**
     * 修改数据
     *
     * @param employeeDetail 实例对象
     * @return 实例对象
     */
    int updateEmployeeDetail(EmployeeDetail employeeDetail);

    /**
     * 通过主键删除数据
     *
     * @param employeeDetailId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteEmployeeDetailById(Integer employeeDetailId);

}