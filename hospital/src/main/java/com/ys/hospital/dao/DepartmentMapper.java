package com.ys.hospital.dao;

import com.ys.hospital.pojo.Department;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Department)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-12 17:58:01
 */
public interface DepartmentMapper {

    /**
     * 查询所有Department信息
     *
     * @return 对象Department列表
     */
    List<Department> queryAllDepartment();


    /**
     * 根据实体类Department的相关属性查询实体类Department
     *
     * @param department 实例对象
     * @return 对象Department列表
     */
    List<Department> queryDepartmentByParam(Department department);

    /**
     * 新增Department数据
     *
     * @param department 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertDepartment(Department department);

    /**
     * 修改Department数据
     *
     * @param department 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int updateDepartment(Department department);

    /**
     * 通过主键删除数据
     *
     * @param departmentId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteDepartmentById(Integer departmentId);

}