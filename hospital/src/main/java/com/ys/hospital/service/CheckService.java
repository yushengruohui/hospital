package com.ys.hospital.service;

import com.ys.hospital.pojo.Check;

import java.util.List;

/**
 * (Check)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface CheckService {

    /**
     * 查询所有Check信息
     *
     * @return 实例对象
     */
    List<Check> queryAllCheck();

    /**
     * 新增数据
     *
     * @param check 实例对象
     * @return 实例对象
     */
    int insertCheck(Check check);

    /**
     * 修改数据
     *
     * @param check 实例对象
     * @return 实例对象
     */
    int updateCheck(Check check);

    /**
     * 通过主键删除数据
     *
     * @param checkId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteCheckById(Integer checkId);

}