package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Role;
import com.ys.hospital.dao.RoleMapper;
import com.ys.hospital.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Role)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    
    @Resource
    private RoleMapper roleMapper;

    /**
     * 查询所有Role信息
     *
     * @return 对象Role列表
     */
    @Override
    public List<Role> queryAllRole() {
        return this.roleMapper.queryAllRole();
    }

    /**
     * 新增Role数据
     *
     * @param role 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertRole(Role role) {
        return this.roleMapper.insertRole(role);
    }

    /**
     * 修改Role数据
     *
     * @param role 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateRole(Role role) {
        return this.roleMapper.updateRole(role);
    }

    /**
     * 通过主键删除Role数据
     *
     * @param roleId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteRoleById(Integer roleId) {
        return this.roleMapper.deleteRoleById(roleId);
    }
}