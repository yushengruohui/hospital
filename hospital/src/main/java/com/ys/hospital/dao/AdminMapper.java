package com.ys.hospital.dao;

import com.ys.hospital.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
public interface AdminMapper {

    /**
     * 查询所有Admin信息
     *
     * @return 对象Admin列表
     */
    List<Admin> queryAllAdmin();


    /**
     * 根据实体类Admin的相关属性查询实体类Admin
     *
     * @param admin 实例对象
     * @return 对象Admin列表
     */
    List<Admin> queryAdminByParam(Admin admin);

    /**
     * 新增Admin数据
     *
     * @param admin 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertAdmin(Admin admin);

    /**
     * 修改Admin数据
     *
     * @param admin 实例对象
     * @return 是否成功(1：成功|0：失败)
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