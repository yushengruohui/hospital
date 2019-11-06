package com.ys.hospital.dao;

import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.vo.EmployeeInfoVO;

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

    int countEmployeeListByStatus(Integer employeeDetailStatus);

    int countEmployeeListByOnlineStatus(Integer loginStatus);

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


    Employee getPermissionInfo(String employeeId);

    /**
     * 根据员工详情更新员工基本信息和详情
     *
     * @param employeeDTO 员工基本信息和详情
     * @return 更新结果
     */
    int updateEmployeeInfo(Employee employeeDTO);

    List<EmployeeInfoVO> findEmployeeByLoginStatus(Integer loginStatus);
}