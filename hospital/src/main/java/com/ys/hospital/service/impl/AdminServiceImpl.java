package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Admin;
import com.ys.hospital.dao.AdminMapper;
import com.ys.hospital.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
    
    @Resource
    private AdminMapper adminMapper;

    /**
     * 查询所有Admin信息
     *
     * @return 对象Admin列表
     */
    @Override
    public List<Admin> queryAllAdmin() {
        return this.adminMapper.queryAllAdmin();
    }

    /**
     * 新增Admin数据
     *
     * @param admin 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertAdmin(Admin admin) {
        return this.adminMapper.insertAdmin(admin);
    }

    /**
     * 修改Admin数据
     *
     * @param admin 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateAdmin(Admin admin) {
        return this.adminMapper.updateAdmin(admin);
    }

    /**
     * 通过主键删除Admin数据
     *
     * @param adminId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteAdminById(Integer adminId) {
        return this.adminMapper.deleteAdminById(adminId);
    }
}