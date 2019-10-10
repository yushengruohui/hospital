package com.ys.hospital.service;

import com.ys.hospital.pojo.Employee;
import java.util.List;

/**
 * (Employee)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface EmployeeService {

    /**
     * 查询所有Employee信息
     *
     * @return 实例对象
     */
    List<Employee> queryAllEmployee();

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    int insertEmployee(Employee employee);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    int updateEmployee(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteEmployeeById(Integer employeeId);

}