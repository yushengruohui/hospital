package com.ys.hospital.service.impl;

import com.ys.hospital.dao.EmployeeRoleMapper;
import com.ys.hospital.pojo.EmployeeRole;
import com.ys.hospital.service.EmployeeRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EmployeeRole)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Service("employeeRoleService")
public class EmployeeRoleServiceImpl implements EmployeeRoleService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeRoleServiceImpl.class);

    @Resource
    private EmployeeRoleMapper employeeRoleMapper;

    /**
     * 查询所有EmployeeRole信息
     *
     * @return 对象EmployeeRole列表
     */
    @Override
    public List<EmployeeRole> queryAllEmployeeRole() {
        return this.employeeRoleMapper.queryAllEmployeeRole();
    }

    /**
     * 新增EmployeeRole数据
     *
     * @param employeeRole 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int insertEmployeeRole(EmployeeRole employeeRole) {
        return this.employeeRoleMapper.insertEmployeeRole(employeeRole);
    }

    /**
     * 修改EmployeeRole数据
     *
     * @param employeeRole 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int updateEmployeeRole(EmployeeRole employeeRole) {
        return this.employeeRoleMapper.updateEmployeeRole(employeeRole);
    }

    /**
     * 通过主键删除EmployeeRole数据
     *
     * @param employeeRoleId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int deleteEmployeeRoleById(Integer employeeRoleId) {
        return this.employeeRoleMapper.deleteEmployeeRoleById(employeeRoleId);
    }

    @Override
    public EmployeeRole queryEmployeeRoleByParam(EmployeeRole employeeRole) {
        if (employeeRole == null) {
            return null;
        }
        return this.employeeRoleMapper.queryEmployeeRoleByParam(employeeRole).get(0);
    }
}