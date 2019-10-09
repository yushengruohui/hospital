package com.ys.hospital.dao;

import com.ys.hospital.pojo.Operation;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Operation)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
public interface OperationMapper {

    /**
     * 查询所有Operation信息
     *
     * @return 对象Operation列表
     */
    List<Operation> queryAllOperation();


    /**
     * 根据实体类Operation的相关属性查询实体类Operation
     *
     * @param operation 实例对象
     * @return 对象Operation列表
     */
    List<Operation> queryOperationByParam(Operation operation);

    /**
     * 新增Operation数据
     *
     * @param operation 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertOperation(Operation operation);

    /**
     * 修改Operation数据
     *
     * @param operation 实例对象
     * @return 是否成功(1：成功|0：失败)
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