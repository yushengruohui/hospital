package com.ys.hospital.service;

import com.ys.hospital.pojo.Device;
import java.util.List;

/**
 * (Device)表服务接口
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
public interface DeviceService {

    /**
     * 查询所有Device信息
     *
     * @return 实例对象
     */
    List<Device> queryAllDevice();

    /**
     * 新增数据
     *
     * @param device 实例对象
     * @return 实例对象
     */
    int insertDevice(Device device);

    /**
     * 修改数据
     *
     * @param device 实例对象
     * @return 实例对象
     */
    int updateDevice(Device device);

    /**
     * 通过主键删除数据
     *
     * @param deviceId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteDeviceById(Integer deviceId);

}