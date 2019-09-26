package com.ys.hospital.dao;

import com.ys.hospital.pojo.Check;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Check)表数据库访问层
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
public interface CheckMapper {

    /**
     * 查询所有Check信息
     *
     * @return 对象Check列表
     */
    List<Check> queryAllCheck();


    /**
     * 根据实体类Check的相关属性查询实体类Check
     *
     * @param check 实例对象
     * @return 对象Check列表
     */
    List<Check> queryCheckByParam(Check check);

    /**
     * 新增Check数据
     *
     * @param check 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertCheck(Check check);

    /**
     * 修改Check数据
     *
     * @param check 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int updateCheck(Check check);

    /**
     * 通过主键删除数据
     *
     * @param checkId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteCheckById(Integer checkId);

}