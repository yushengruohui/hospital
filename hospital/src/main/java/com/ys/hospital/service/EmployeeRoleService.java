package com.ys.hospital.service;

import com.ys.hospital.pojo.EmployeeRole;
import java.util.List;

/**
 * (EmployeeRole)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface EmployeeRoleService {

    /**
     * 查询所有EmployeeRole信息
     *
     * @return 实例对象
     */
    List<EmployeeRole> queryAllEmployeeRole();

    /**
     * 新增数据
     *
     * @param employeeRole 实例对象
     * @return 实例对象
     */
    int insertEmployeeRole(EmployeeRole employeeRole);

    /**
     * 修改数据
     *
     * @param employeeRole 实例对象
     * @return 实例对象
     */
    int updateEmployeeRole(EmployeeRole employeeRole);

    /**
     * 通过主键删除数据
     *
     * @param employeeRoleId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteEmployeeRoleById(Integer employeeRoleId);

}