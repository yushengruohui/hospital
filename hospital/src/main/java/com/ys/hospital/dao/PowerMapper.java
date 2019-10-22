package com.ys.hospital.dao;

import com.ys.hospital.pojo.Power;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Power)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface PowerMapper {

    /**
     * 查询所有Power信息
     *
     * @return 对象Power列表
     */
    List<Power> queryAllPower();


    /**
     * 根据实体类Power的相关属性查询实体类Power
     *
     * @param power 实例对象
     * @return 对象Power列表
     */
    List<Power> queryPowerByParam(Power power);

    /**
     * 新增Power数据
     *
     * @param power 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertPower(Power power);

    /**
     * 修改Power数据
     *
     * @param power 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int updatePower(Power power);

    /**
     * 通过主键删除数据
     *
     * @param powerId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deletePowerById(Integer powerId);

}