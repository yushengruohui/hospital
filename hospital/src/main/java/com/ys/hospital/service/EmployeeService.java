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
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteEmployeeById(Integer employeeId);


    Employee verifyLogin(Employee employee);

    /**
     * 根据主键查询员工信息（包括员工详情）
     *
     * @param employeeId
     * @return employee(员工及其详情信息)
     */
    Employee getEmployeeByEmployeeId(Integer employeeId);

    /**
     * 查询医院中所有在职的职位为医师信息
     *
     * @return 医师列表
     */
    List<Employee> getDoctorEmployees();

    int updateEmployeeInfo(Employee employeeDTO);

    List<Employee> queryEmployeeByStatus(Integer employeeDetailStatus);
}