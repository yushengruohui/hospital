package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.PowerDetail;
import com.ys.hospital.dao.PowerDetailMapper;
import com.ys.hospital.service.PowerDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PowerDetail)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Service("powerDetailService")
public class PowerDetailServiceImpl implements PowerDetailService {
    private static final Logger logger = LoggerFactory.getLogger(PowerDetailServiceImpl.class);
    
    @Resource
    private PowerDetailMapper powerDetailMapper;

    /**
     * 查询所有PowerDetail信息
     *
     * @return 对象PowerDetail列表
     */
    @Override
    public List<PowerDetail> queryAllPowerDetail() {
        return this.powerDetailMapper.queryAllPowerDetail();
    }

    /**
     * 新增PowerDetail数据
     *
     * @param powerDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertPowerDetail(PowerDetail powerDetail) {
        return this.powerDetailMapper.insertPowerDetail(powerDetail);
    }

    /**
     * 修改PowerDetail数据
     *
     * @param powerDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updatePowerDetail(PowerDetail powerDetail) {
        return this.powerDetailMapper.updatePowerDetail(powerDetail);
    }

    /**
     * 通过主键删除PowerDetail数据
     *
     * @param powerDetailId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deletePowerDetailById(Integer powerDetailId) {
        return this.powerDetailMapper.deletePowerDetailById(powerDetailId);
    }
}