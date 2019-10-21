package com.ys.hospital.dao;

import com.ys.hospital.pojo.Device;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Device)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface DeviceMapper {

    /**
     * 查询所有Device信息
     *
     * @return 对象Device列表
     */
    List<Device> queryAllDevice();


    /**
     * 根据实体类Device的相关属性查询实体类Device
     *
     * @param device 实例对象
     * @return 对象Device列表
     */
    List<Device> queryDeviceByParam(Device device);

    /**
     * 新增Device数据
     *
     * @param device 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertDevice(Device device);

    /**
     * 修改Device数据
     *
     * @param device 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int updateDevice(Device device);

    /**
     * 通过主键删除数据
     *
     * @param deviceId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteDeviceById(Integer deviceId);

}