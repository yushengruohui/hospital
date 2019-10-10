package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Device;
import com.ys.hospital.dao.DeviceMapper;
import com.ys.hospital.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Device)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {
    private static final Logger logger = LoggerFactory.getLogger(DeviceServiceImpl.class);
    
    @Resource
    private DeviceMapper deviceMapper;

    /**
     * 查询所有Device信息
     *
     * @return 对象Device列表
     */
    @Override
    public List<Device> queryAllDevice() {
        return this.deviceMapper.queryAllDevice();
    }

    /**
     * 新增Device数据
     *
     * @param device 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertDevice(Device device) {
        return this.deviceMapper.insertDevice(device);
    }

    /**
     * 修改Device数据
     *
     * @param device 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateDevice(Device device) {
        return this.deviceMapper.updateDevice(device);
    }

    /**
     * 通过主键删除Device数据
     *
     * @param deviceId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteDeviceById(Integer deviceId) {
        return this.deviceMapper.deleteDeviceById(deviceId);
    }
}