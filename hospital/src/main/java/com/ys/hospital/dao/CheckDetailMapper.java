package com.ys.hospital.dao;

import com.ys.hospital.pojo.CheckDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (CheckDetail)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface CheckDetailMapper {

    /**
     * 查询所有CheckDetail信息
     *
     * @return 对象CheckDetail列表
     */
    List<CheckDetail> queryAllCheckDetail();


    /**
     * 根据实体类CheckDetail的相关属性查询实体类CheckDetail
     *
     * @param checkDetail 实例对象
     * @return 对象CheckDetail列表
     */
    List<CheckDetail> queryCheckDetailByParam(CheckDetail checkDetail);

    /**
     * 新增CheckDetail数据
     *
     * @param checkDetail 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertCheckDetail(CheckDetail checkDetail);

    /**
     * 修改CheckDetail数据
     *
     * @param checkDetail 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int updateCheckDetail(CheckDetail checkDetail);

    /**
     * 通过主键删除数据
     *
     * @param checkDetailId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteCheckDetailById(Integer checkDetailId);

}