package com.ys.hospital.service;

import com.ys.hospital.pojo.PowerDetail;

import java.util.List;

/**
 * (PowerDetail)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface PowerDetailService {

    /**
     * 查询所有PowerDetail信息
     *
     * @return 实例对象
     */
    List<PowerDetail> queryAllPowerDetail();

    /**
     * 新增数据
     *
     * @param powerDetail 实例对象
     * @return 实例对象
     */
    int insertPowerDetail(PowerDetail powerDetail);

    /**
     * 修改数据
     *
     * @param powerDetail 实例对象
     * @return 实例对象
     */
    int updatePowerDetail(PowerDetail powerDetail);

    /**
     * 通过主键删除数据
     *
     * @param powerDetailId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deletePowerDetailById(Integer powerDetailId);

}