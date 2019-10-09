package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Room;
import com.ys.hospital.dao.RoomMapper;
import com.ys.hospital.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Room)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Service("roomService")
public class RoomServiceImpl implements RoomService {
    private static final Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);
    
    @Resource
    private RoomMapper roomMapper;

    /**
     * 查询所有Room信息
     *
     * @return 对象Room列表
     */
    @Override
    public List<Room> queryAllRoom() {
        return this.roomMapper.queryAllRoom();
    }

    /**
     * 新增Room数据
     *
     * @param room 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertRoom(Room room) {
        return this.roomMapper.insertRoom(room);
    }

    /**
     * 修改Room数据
     *
     * @param room 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateRoom(Room room) {
        return this.roomMapper.updateRoom(room);
    }

    /**
     * 通过主键删除Room数据
     *
     * @param roomId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteRoomById(Integer roomId) {
        return this.roomMapper.deleteRoomById(roomId);
    }
}