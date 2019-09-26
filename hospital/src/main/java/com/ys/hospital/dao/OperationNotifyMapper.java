package com.ys.hospital.dao;

import com.ys.hospital.pojo.OperationNotify;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (OperationNotify)表数据库访问层
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
public interface OperationNotifyMapper {

    /**
     * 查询所有OperationNotify信息
     *
     * @return 对象OperationNotify列表
     */
    List<OperationNotify> queryAllOperationNotify();


    /**
     * 根据实体类OperationNotify的相关属性查询实体类OperationNotify
     *
     * @param operationNotify 实例对象
     * @return 对象OperationNotify列表
     */
    List<OperationNotify> queryOperationNotifyByParam(OperationNotify operationNotify);

    /**
     * 新增OperationNotify数据
     *
     * @param operationNotify 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertOperationNotify(OperationNotify operationNotify);

    /**
     * 修改OperationNotify数据
     *
     * @param operationNotify 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int updateOperationNotify(OperationNotify operationNotify);

    /**
     * 通过主键删除数据
     *
     * @param operationNotifyId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteOperationNotifyById(Integer operationNotifyId);

}