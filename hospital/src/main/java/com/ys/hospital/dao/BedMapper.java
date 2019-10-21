package com.ys.hospital.dao;

import com.ys.hospital.pojo.Bed;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Bed)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface BedMapper {

    /**
     * 查询所有Bed信息
     *
     * @return 对象Bed列表
     */
    List<Bed> queryAllBed();


    /**
     * 根据实体类Bed的相关属性查询实体类Bed
     *
     * @param bed 实例对象
     * @return 对象Bed列表
     */
    List<Bed> queryBedByParam(Bed bed);

    /**
     * 新增Bed数据
     *
     * @param bed 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertBed(Bed bed);

    /**
     * 修改Bed数据
     *
     * @param bed 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int updateBed(Bed bed);

    /**
     * 通过主键删除数据
     *
     * @param bedId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteBedById(Integer bedId);

}