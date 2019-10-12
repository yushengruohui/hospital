package com.ys.hospital.service;


import com.ys.hospital.pojo.Department;

import java.util.List;

/**
 * (Department)表服务接口
 *
 * @author makejava
 * @since 2019-10-10 17:36:23
 */
public interface DepartmentService {
    /**
     * 查询医院所有的科室信息
     *
     * @return departmentList
     */
    public List<Department> getDepartmentList();
}