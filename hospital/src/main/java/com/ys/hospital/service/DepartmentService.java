package com.ys.hospital.service;

import com.ys.hospital.pojo.Department;

import java.util.List;

/**
 * (Department)表服务接口
 *
 * @author yusheng
 * @since 2019-10-12 17:58:01
 */
public interface DepartmentService {

    /**
     * 查询所有Department信息
     *
     * @return 实例对象
     */
    List<Department> queryAllDepartment();

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    int insertDepartment(Department department);

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    int updateDepartment(Department department);

    /**
     * 通过主键删除数据
     *
     * @param departmentId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteDepartmentById(Integer departmentId);

    /**
     * 查询医院所有的科室信息
     *
     * @return departmentList
     */
    public List<Department> getDepartmentList();

}