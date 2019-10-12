package com.ys.hospital.dao;

import com.ys.hospital.pojo.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Department)表数据库访问层
 *
 * @author makejava
 * @since 2019-10-10 17:36:23
 */
public interface DepartmentMapper {
    /**
     * 查询医院所有的科室信息
     *
     * @return departmentList
     */
    public List<Department> getDepartmentList();
}