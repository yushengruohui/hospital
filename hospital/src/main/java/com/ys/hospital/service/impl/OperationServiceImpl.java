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
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int insertOperation(Operation operation) {
        return this.operationMapper.insertOperation(operation);
    }

    /**
     * 修改Operation数据
     *
     * @param operation 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int updateOperation(Operation operation) {
        return this.operationMapper.updateOperation(operation);
    }

    /**
     * 通过主键删除Operation数据
     *
     * @param operationId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int deleteOperationById(Integer operationId) {
        return this.operationMapper.deleteOperationById(operationId);
    }
	/**
     * 根据实体类Operation的相关属性查询实体类Operation
     *
     * @param operation 实例对象
     * @return 对象Operation列表
     */
    @Override
    public List<Operation> queryOperationByParam(Operation operation) {
        return this.operationMapper.queryOperationByParam(operation);
    }
    /**
     * 根据实体类Operation的id查找Operation的详细信息
     *
     * @param operation 实例对象
     * @return Operation
     */
    @Override
    public Operation queryOperationById(Operation operation) {
        return this.operationMapper.queryOperationById(operation);
    }
    /**
     * 根据实体类Operation的相关属性查询实体类Operation,多表
     *
     * @param operation 实例对象
     * @return 对象Operation列表
     */
    @Override
    public List<Operation> queryOperationsByParam(Operation operation){
        return this.operationMapper.queryOperationsByParam(operation);
    }
    /**
     * 查询所有Operation信息,多表
     *
     * @return 对象Operation列表
     */
    public List<Operation> queryAllOperations(){
        return this.operationMapper.queryAllOperations();
    }
}