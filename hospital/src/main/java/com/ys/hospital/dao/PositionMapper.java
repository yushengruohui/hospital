package com.ys.hospital.dao;

import com.ys.hospital.pojo.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Position)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface PositionMapper {

    /**
     * 查询所有Position信息
     *
     * @return 对象Position列表
     */
    List<Position> queryAllPosition();


    /**
     * 根据实体类Position的相关属性查询实体类Position
     *
     * @param position 实例对象
     * @return 对象Position列表
     */
    List<Position> queryPositionByParam(Position position);

    /**
     * 新增Position数据
     *
     * @param position 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertPosition(Position position);

    /**
     * 修改Position数据
     *
     * @param position 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int updatePosition(Position position);

    /**
     * 通过主键删除数据
     *
     * @param positionId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deletePositionById(Integer positionId);

}