package com.ys.hospital.dao;

import com.ys.hospital.pojo.RolePower;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (RolePower)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
public interface RolePowerMapper {

    /**
     * 查询所有RolePower信息
     *
     * @return 对象RolePower列表
     */
    List<RolePower> queryAllRolePower();


    /**
     * 根据实体类RolePower的相关属性查询实体类RolePower
     *
     * @param rolePower 实例对象
     * @return 对象RolePower列表
     */
    List<RolePower> queryRolePowerByParam(RolePower rolePower);

    /**
     * 新增RolePower数据
     *
     * @param rolePower 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertRolePower(RolePower rolePower);

    /**
     * 修改RolePower数据
     *
     * @param rolePower 实例对象
     * @return 是否成功(1：成功|0：失败)
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