package com.ys.hospital.service;

import com.ys.hospital.pojo.Power;

import java.util.List;

/**
 * (Power)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface PowerService {

    /**
     * 查询所有Power信息
     *
     * @return 实例对象
     */
    List<Power> queryAllPower();

    /**
     * 新增数据
     *
     * @param power 实例对象
     * @return 实例对象
     */
    int insertPower(Power power);

    /**
     * 修改数据
     *
     * @param power 实例对象
     * @return 实例对象
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