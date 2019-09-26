package com.ys.hospital.service;

import com.ys.hospital.pojo.Admin;
import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
public interface AdminService {

    /**
     * 查询所有Admin信息
     *
     * @return 实例对象
     */
    List<Admin> queryAllAdmin();

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    int insertAdmin(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    int updateAdmin(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteAdminById(Integer adminId);

}