package com.ys.hospital.service;

import com.ys.hospital.pojo.Bed;

import java.util.List;

/**
 * (Bed)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface BedService {

    /**
     * 查询所有Bed信息
     *
     * @return 实例对象
     */
    List<Bed> queryAllBed();

    /**
     * 根据实体类Bed的相关属性查询实体类Bed
     * @param bed 属性
     * @return 实例对象
     */
    List<Bed> queryBedByParam(Bed bed);
    /**
     * 新增数据
     *
     * @param bed 实例对象
     * @return 实例对象
     */
    int insertBed(Bed bed);

    /**
     * 通过病床ID查找信息
     * @param bedId
     * @return
     */
    List<Bed> findBedById(int bedId);
    /**
     * 修改数据
     *
     * @param bed 实例对象
     * @return 实例对象
     */
    int updateBed(Bed bed);

    /**
     * 通过主键删除数据
     *
     * @param bedId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteBedById(Integer bedId);

    /**
     * 通过病床状态获取病床信息
     * @param bedStatus
     * @return
     */
    List<Bed> queryBedByStatus(Integer bedStatus);
}