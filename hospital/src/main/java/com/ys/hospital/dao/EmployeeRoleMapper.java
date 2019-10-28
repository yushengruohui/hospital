package com.ys.hospital.dao;

import com.ys.hospital.pojo.EmployeeRole;

import java.util.List;

/**
 * (EmployeeRole)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface EmployeeRoleMapper {

    /**
     * 查询所有EmployeeRole信息
     *
     * @return 对象EmployeeRole列表
     */
    List<EmployeeRole> queryAllEmployeeRole();


    /**
     * 根据实体类EmployeeRole的相关属性查询实体类EmployeeRole
     *
     * @param employeeRole 实例对象
     * @return 对象EmployeeRole列表
     */
    List<EmployeeRole> queryEmployeeRoleByParam(EmployeeRole employeeRole);

    /**
     * 新增EmployeeRole数据
     *
     * @param employeeRole 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertEmployeeRole(EmployeeRole employeeRole);

    /**
     * 修改EmployeeRole数据
     *
     * @param employeeRole 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int updateEmployeeRole(EmployeeRole employeeRole);

    /**
     * 通过主键删除数据
     *
     * @param employeeRoleId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteEmployeeRoleById(Integer employeeRoleId);


}