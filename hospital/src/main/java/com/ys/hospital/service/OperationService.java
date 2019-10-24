package com.ys.hospital.service;

import com.ys.hospital.pojo.Operation;

import java.util.List;

/**
 * (Operation)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface OperationService {

    /**
     * 查询所有Operation信息
     *
     * @return 实例对象
     */
    List<Operation> queryAllOperation();

    /**
     * 新增数据
     *
     * @param operation 实例对象
     * @return 实例对象
     */
    int insertOperation(Operation operation);

    /**
     * 修改数据
     *
     * @param operation 实例对象
     * @return 实例对象
     */
    int updateOperation(Operation operation);

    /**
     * 通过主键删除数据
     *
     * @param operationId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteOperationById(Integer operationId);
	/**
     * 根据实体类Operation的相关属性查询实体类Operation
     *
     * @param operation 实例对象
     * @return 对象Operation列表
     */
    List<Operation> queryOperationByParam(Operation operation);
    /**
     * 根据实体类Operation的id查找Operation的详细信息
     *
     * @param operation 实例对象
     * @return Operation
     */
    Operation queryOperationById(Operation operation);
    /**
     * 根据实体类Operation的相关属性查询实体类Operation,多表
     *
     * @param operation 实例对象
     * @return 对象Operation列表
     */
    List<Operation> queryOperationsByParam(Operation operation);
    /**
     * 查询所有Operation信息,多表
     *
     * @return 对象Operation列表
     */
    List<Operation> queryAllOperations(Integer employeeId);
}