package com.ys.hospital.dao;

import com.ys.hospital.pojo.Employee;

import java.util.List;

/**
 * (Employee)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface EmployeeMapper {

    /**
     * 查询所有Employee信息
     *
     * @return 对象Employee列表
     */
    List<Employee> queryAllEmployee();


    /**
     * 根据实体类Employee的相关属性查询实体类Employee
     *
     * @param employee 实例对象
     * @return 对象Employee列表
     */
    Employee queryEmployeeByParam(Employee employee);

    /**
     * 新增Employee数据
     *
     * @param employee 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertEmployee(Employee employee);

    /**
     * 修改Employee数据
     *
     * @param employee 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int updateEmployee(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteEmployeeById(Integer employeeId);

}