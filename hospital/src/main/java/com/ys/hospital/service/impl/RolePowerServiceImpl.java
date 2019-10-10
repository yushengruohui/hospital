package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.RolePower;
import com.ys.hospital.dao.RolePowerMapper;
import com.ys.hospital.service.RolePowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RolePower)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Service("rolePowerService")
public class RolePowerServiceImpl implements RolePowerService {
    private static final Logger logger = LoggerFactory.getLogger(RolePowerServiceImpl.class);
    
    @Resource
    private RolePowerMapper rolePowerMapper;

    /**
     * 查询所有RolePower信息
     *
     * @return 对象RolePower列表
     */
    @Override
    public List<RolePower> queryAllRolePower() {
        return this.rolePowerMapper.queryAllRolePower();
    }

    /**
     * 新增RolePower数据
     *
     * @param rolePower 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertRolePower(RolePower rolePower) {
        return this.rolePowerMapper.insertRolePower(rolePower);
    }

    /**
     * 修改RolePower数据
     *
     * @param rolePower 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateRolePower(RolePower rolePower) {
        return this.rolePowerMapper.updateRolePower(rolePower);
    }

    /**
     * 通过主键删除RolePower数据
     *
     * @param rolePowerId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteRolePowerById(Integer rolePowerId) {
        return this.rolePowerMapper.deleteRolePowerById(rolePowerId);
    }
}