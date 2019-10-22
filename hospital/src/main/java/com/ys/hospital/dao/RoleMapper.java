package com.ys.hospital.dao;

import com.ys.hospital.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Role)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface RoleMapper {

    /**
     * 查询所有Role信息
     *
     * @return 对象Role列表
     */
    List<Role> queryAllRole();


    /**
     * 根据实体类Role的相关属性查询实体类Role
     *
     * @param role 实例对象
     * @return 对象Role列表
     */
    List<Role> queryRoleByParam(Role role);

    /**
     * 新增Role数据
     *
     * @param role 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertRole(Role role);

    /**
     * 修改Role数据
     *
     * @param role 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int updateRole(Role role);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteRoleById(Integer roleId);

}