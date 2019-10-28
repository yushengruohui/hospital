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
 * PowerDetail表的服务实现类
 *
 * @author yusheng
 * @create-time 2019-10-27 17:58:50
 */
@Service("powerDetailService")
public class PowerDetailServiceImpl implements PowerDetailService {
    //private static final Logger logger = LoggerFactory.getLogger(PowerDetailServiceImpl.class);
    
    @Resource
    private PowerDetailMapper powerDetailMapper;
    
    /**
     * 查询PowerDetail表的所有记录
     *
     * @return PowerDetail的实例对象集合List（封装了PowerDetail表的所有记录）
     */
    @Override
    public List<PowerDetail> queryAllPowerDetail() {
        return this.powerDetailMapper.queryAllPowerDetail();
    }
    
    /**
     * 查询PowerDetail表中的一条记录
     *
     * @param  powerDetail（封装了相关查询条件）
     * @return PowerDetail的实例对象（封装了PowerDetail表的一条记录）
     */
     @Override
    public PowerDetail queryPowerDetailByParam(PowerDetail powerDetail){
        if(powerDetail==null){
            return null;
        }
        return this.powerDetailMapper.queryPowerDetailByParam(powerDetail);
    }
    
    /**
     * 查询PowerDetail表中的多条记录
     *
     * @param  powerDetail（封装了相关查询条件）
     * @return PowerDetail的实例对象集合List（封装了PowerDetail表的多条记录）
     */
    public List<PowerDetail> queryPowerDetailListByParam(PowerDetail powerDetail){
        if(powerDetail==null){
            return null;
        }
        return this.powerDetailMapper.queryPowerDetailListByParam(powerDetail);
    }
    
    /**
     * 在PowerDetail表中的添加一条记录
     *
     * @param  powerDetail（封装了想要添加的记录信息）
     * @return 添加记录的反馈结果(1:添加记录成功；0：添加记录失败)
     */
    @Override
    public int insertPowerDetail(PowerDetail powerDetail) {
        if(powerDetail==null){
            return 0;
        }
        return this.powerDetailMapper.insertPowerDetail(powerDetail);
    }

    /**
     * 修改PowerDetail表中的一条记录
     *
     * @param  powerDetail（封装了准备修改的记录信息）
     * @return 修改记录的反馈结果(1:修改记录成功；0：修改记录失败)
     */
    @Override
    public int updatePowerDetail(PowerDetail powerDetail) {
        if(powerDetail==null){
            return 0;
        }
        return this.powerDetailMapper.updatePowerDetail(powerDetail);
    }

    /**
     * 删除PowerDetail表中的一条记录
     *
     * @param  powerDetailId ： PowerDetail表的主键
     * @return 删除记录反馈结果(1：删除记录成功|0：删除记录失败)
     */
    @Override
    public int deletePowerDetailById(Integer powerDetailId) {
        if(powerDetailId==null){
            return 0;
        }
        return this.powerDetailMapper.deletePowerDetailById(powerDetailId);
    }
}