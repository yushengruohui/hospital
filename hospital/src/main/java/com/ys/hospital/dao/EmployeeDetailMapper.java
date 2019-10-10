package com.ys.hospital.dao;

import com.ys.hospital.pojo.EmployeeDetail;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (EmployeeDetail)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface EmployeeDetailMapper {

    /**
     * 查询所有EmployeeDetail信息
     *
     * @return 对象EmployeeDetail列表
     */
    List<EmployeeDetail> queryAllEmployeeDetail();


    /**
     * 根据实体类EmployeeDetail的相关属性查询实体类EmployeeDetail
     *
     * @param employeeDetail 实例对象
     * @return 对象EmployeeDetail列表
     */
    List<EmployeeDetail> queryEmployeeDetailByParam(EmployeeDetail employeeDetail);

    /**
     * 新增EmployeeDetail数据
     *
     * @param employeeDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertEmployeeDetail(EmployeeDetail employeeDetail);

    /**
     * 修改EmployeeDetail数据
     *
     * @param employeeDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int updateEmployeeDetail(EmployeeDetail employeeDetail);

    /**
     * 通过主键删除数据
     *
     * @param employeeDetailId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteEmployeeDetailById(Integer employeeDetailId);

}