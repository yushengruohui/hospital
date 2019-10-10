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
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteOperationById(Integer operationId);

}