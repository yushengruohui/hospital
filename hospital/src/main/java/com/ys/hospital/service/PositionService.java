package com.ys.hospital.service;

import com.ys.hospital.pojo.Position;
import java.util.List;

/**
 * (Position)表服务接口
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
public interface PositionService {

    /**
     * 查询所有Position信息
     *
     * @return 实例对象
     */
    List<Position> queryAllPosition();

    /**
     * 新增数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    int insertPosition(Position position);

    /**
     * 修改数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    int updatePosition(Position position);

    /**
     * 通过主键删除数据
     *
     * @param positionId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deletePositionById(Integer positionId);

}