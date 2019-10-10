package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Power;
import com.ys.hospital.dao.PowerMapper;
import com.ys.hospital.service.PowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Power)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Service("powerService")
public class PowerServiceImpl implements PowerService {
    private static final Logger logger = LoggerFactory.getLogger(PowerServiceImpl.class);
    
    @Resource
    private PowerMapper powerMapper;

    /**
     * 查询所有Power信息
     *
     * @return 对象Power列表
     */
    @Override
    public List<Power> queryAllPower() {
        return this.powerMapper.queryAllPower();
    }

    /**
     * 新增Power数据
     *
     * @param power 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertPower(Power power) {
        return this.powerMapper.insertPower(power);
    }

    /**
     * 修改Power数据
     *
     * @param power 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updatePower(Power power) {
        return this.powerMapper.updatePower(power);
    }

    /**
     * 通过主键删除Power数据
     *
     * @param powerId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deletePowerById(Integer powerId) {
        return this.powerMapper.deletePowerById(powerId);
    }
}