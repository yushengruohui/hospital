package com.ys.hospital.dao;

import com.ys.hospital.pojo.PowerDetail;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (PowerDetail)表数据库访问层
 *
 * @author yusheng
 * @create-time 2019-10-27 17:58:50
 */
public interface PowerDetailMapper {

    /**
     * 查询PowerDetail表的所有记录
     *
     * @return PowerDetail的实例对象集合List（封装了PowerDetail表的所有记录）
     */
    List<PowerDetail> queryAllPowerDetail();

    /**
     * 查询PowerDetail表中的一条记录
     *
     * @param  powerDetail（封装了相关查询条件）
     * @return PowerDetail的实例对象（封装了PowerDetail表的一条记录）
     */
    PowerDetail queryPowerDetailByParam(PowerDetail powerDetail);
    
    /**
     * 查询PowerDetail表中的多条记录
     *
     * @param  powerDetail（封装了相关查询条件）
     * @return PowerDetail的实例对象集合List（封装了PowerDetail表的多条记录）
     */
    List<PowerDetail> queryPowerDetailListByParam(PowerDetail powerDetail);
    
    /**
     * 在PowerDetail表中的添加一条记录
     *
     * @param  powerDetail（封装了想要添加的记录信息）
     * @return 添加记录的反馈结果(1:添加记录成功；0：添加记录失败)
     */
    int insertPowerDetail(PowerDetail powerDetail);

    /**
     * 修改PowerDetail表中的一条记录
     *
     * @param  powerDetail（封装了准备修改的记录信息）
     * @return 修改记录的反馈结果(1:修改记录成功；0：修改记录失败)
     */
    int updatePowerDetail(PowerDetail powerDetail);

    /**
     * 删除PowerDetail表中的一条记录
     *
     * @param  powerDetailId ： PowerDetail表的主键
     * @return 删除记录反馈结果(1：删除记录成功|0：删除记录失败)
     */
    int deletePowerDetailById(Integer powerDetailId);

}