package com.ys.hospital.service;

import com.ys.hospital.pojo.Check;
import com.ys.hospital.pojo.CheckDetail;

import java.util.List;

/**
 * (CheckDetail)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface CheckDetailService {

    /**
     * 查询所有CheckDetail信息
     *
     * @return 实例对象
     */
    List<CheckDetail> queryAllCheckDetail();

    /**
     * 新增数据
     *
     * @param checkDetail 实例对象
     * @return 实例对象
     */
    int insertCheckDetail(CheckDetail checkDetail);

    /**
     * 修改数据
     *
     * @param checkDetail 实例对象
     * @return 实例对象
     */
    int updateCheckDetail(CheckDetail checkDetail);

    /**
     * 通过主键删除数据
     *
     * @param checkDetailId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteCheckDetailById(Integer checkDetailId);

	List<CheckDetail> queryCheckDetailByParam(CheckDetail checkDetail);

    
}