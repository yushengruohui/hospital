package com.ys.hospital.dao;

import com.ys.hospital.pojo.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Room)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface RoomMapper {

    /**
     * 查询所有Room信息
     *
     * @return 对象Room列表
     */
    List<Room> queryAllRoom();


    /**
     * 根据实体类Room的相关属性查询实体类Room
     *
     * @param room 实例对象
     * @return 对象Room列表
     */
    List<Room> queryRoomByParam(Room room);

    /**
     * 新增Room数据
     *
     * @param room 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int insertRoom(Room room);

    /**
     * 修改Room数据
     *
     * @param room 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int updateRoom(Room room);

    /**
     * 通过主键删除数据
     *
     * @param roomId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteRoomById(Integer roomId);


}