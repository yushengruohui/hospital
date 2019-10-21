package com.ys.hospital.dao;

import com.ys.hospital.pojo.PowerDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PowerDetail)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface PowerDetailMapper {

    /**
     * 查询所有PowerDetail信息
     *
     * @return 对象PowerDetail列表
     */
    List<PowerDetail> queryAllPowerDetail();


    /**
     * 根据实体类PowerDetail的相关属性查询实体类PowerDetail
     *
     * @param powerDetail 实例对象
     * @return 对象PowerDetail列表
     */
    List<PowerDetail> queryPowerDetailByParam(PowerDetail powerDetail);

    /**
     * 新增PowerDetail数据
     *
     * @param powerDetail 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertPowerDetail(PowerDetail powerDetail);

    /**
     * 修改PowerDetail数据
     *
     * @param powerDetail 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
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