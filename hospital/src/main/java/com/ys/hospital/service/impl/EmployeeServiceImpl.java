package com.ys.hospital.service.impl;

import com.ys.hospital.dao.EmployeeMapper;
import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.vo.EmployeeInfoVO;
import com.ys.hospital.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Employee)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 查询所有Employee信息
     *
     * @return 对象Employee列表
     */
    @Override
    public List<Employee> queryAllEmployee() {
        return this.employeeMapper.queryAllEmployee();
    }

    /**
     * 新增Employee数据
     *
     * @param employee 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int insertEmployee(Employee employee) {
        return this.employeeMapper.insertEmployee(employee);
    }

    /**
     * 修改Employee数据
     *
     * @param employee 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int updateEmployee(Employee employee) {
        if (employee == null) {
            return 0;
        }
        return this.employeeMapper.updateEmployee(employee);
    }

    /**
     * 通过主键删除Employee数据
     *
     * @param employeeId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int deleteEmployeeById(Integer employeeId) {
        return this.employeeMapper.deleteEmployeeById(employeeId);
    }

    @Override
    public Employee verifyLogin(Employee employee) {
        if (employee == null) {
            return null;
        }
        return this.employeeMapper.queryEmployeeByParam(employee);
    }

    /**
     * 根据主键查询员工信息（包括员工详情）
     *
     * @param employeeId
     * @return employee(员工及其详情信息)
     */
    @Override
    public Employee getEmployeeByEmployeeId(Integer employeeId) {
        return this.employeeMapper.getEmployeeByEmployeeId(employeeId);
    }

    @Override
    public List<Employee> getDoctorEmployees() {
        return employeeMapper.getDoctorEmployees();
    }

    @Override
    public int updateEmployeeInfo(Employee employeeDTO) {
        if (employeeDTO != null && employeeDTO.getEmployeeDetail() == null) {
            return employeeMapper.updateEmployee(employeeDTO);
        } else if (employeeDTO != null && employeeDTO.getEmployeeDetail() != null) {
            return employeeMapper.updateEmployeeInfo(employeeDTO);
        }
        return 0;
    }

    @Override
    public int countEmployeeByStatus(Integer employeeDetailStatus) {
        if (employeeDetailStatus == null) {
            return 0;
        }
        return employeeMapper.countEmployeeListByStatus(employeeDetailStatus);
    }

    @Override
    public List<EmployeeInfoVO> findEmployeeByLoginStatus(Integer loginStatus) {
        if (loginStatus == null)
            return null;
        return employeeMapper.findEmployeeByLoginStatus(loginStatus);
    }

    @Override
    public int countOnlineEmployee(Integer loginStatus) {
        if (loginStatus == null)
            return 0;
        return this.employeeMapper.countEmployeeListByOnlineStatus(1);
    }

}