package com.ys.hospital.service;

import com.ys.hospital.pojo.Role;
import java.util.List;

/**
 * (Role)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface RoleService {

    /**
     * 查询所有Role信息
     *
     * @return 实例对象
     */
    List<Role> queryAllRole();

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    int insertRole(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    int updateRole(Role role);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteRoleById(Integer roleId);

}