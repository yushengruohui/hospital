package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Position;
import com.ys.hospital.dao.PositionMapper;
import com.ys.hospital.service.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Position)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Service("positionService")
public class PositionServiceImpl implements PositionService {
    private static final Logger logger = LoggerFactory.getLogger(PositionServiceImpl.class);
    
    @Resource
    private PositionMapper positionMapper;

    /**
     * 查询所有Position信息
     *
     * @return 对象Position列表
     */
    @Override
    public List<Position> queryAllPosition() {
        return this.positionMapper.queryAllPosition();
    }

    /**
     * 新增Position数据
     *
     * @param position 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertPosition(Position position) {
        return this.positionMapper.insertPosition(position);
    }

    /**
     * 修改Position数据
     *
     * @param position 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updatePosition(Position position) {
        return this.positionMapper.updatePosition(position);
    }

    /**
     * 通过主键删除Position数据
     *
     * @param positionId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deletePositionById(Integer positionId) {
        return this.positionMapper.deletePositionById(positionId);
    }
}