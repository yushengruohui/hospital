package com.ys.hospital.service;

import com.ys.hospital.pojo.RolePower;
import java.util.List;

/**
 * (RolePower)表服务接口
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
public interface RolePowerService {

    /**
     * 查询所有RolePower信息
     *
     * @return 实例对象
     */
    List<RolePower> queryAllRolePower();

    /**
     * 新增数据
     *
     * @param rolePower 实例对象
     * @return 实例对象
     */
    int insertRolePower(RolePower rolePower);

    /**
     * 修改数据
     *
     * @param rolePower 实例对象
     * @return 实例对象
     */
    int updateRolePower(RolePower rolePower);

    /**
     * 通过主键删除数据
     *
     * @param rolePowerId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteRolePowerById(Integer rolePowerId);

}