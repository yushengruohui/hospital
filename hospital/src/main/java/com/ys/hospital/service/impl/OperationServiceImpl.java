package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Operation;
import com.ys.hospital.dao.OperationMapper;
import com.ys.hospital.service.OperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Operation)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Service("operationService")
public class OperationServiceImpl implements OperationService {
    private static final Logger logger = LoggerFactory.getLogger(OperationServiceImpl.class);
    
    @Resource
    private OperationMapper operationMapper;

    /**
     * 查询所有Operation信息
     *
     * @return 对象Operation列表
     */
    @Override
    public List<Operation> queryAllOperation() {
        return this.operationMapper.queryAllOperation();
    }

    /**
     * 新增Operation数据
     *
     * @param operation 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertOperation(Operation operation) {
        return this.operationMapper.insertOperation(operation);
    }

    /**
     * 修改Operation数据
     *
     * @param operation 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateOperation(Operation operation) {
        return this.operationMapper.updateOperation(operation);
    }

    /**
     * 通过主键删除Operation数据
     *
     * @param operationId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteOperationById(Integer operationId) {
        return this.operationMapper.deleteOperationById(operationId);
    }
}