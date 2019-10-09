package com.ys.hospital.service;

import com.ys.hospital.pojo.OperationNotify;
import java.util.List;

/**
 * (OperationNotify)表服务接口
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
public interface OperationNotifyService {

    /**
     * 查询所有OperationNotify信息
     *
     * @return 实例对象
     */
    List<OperationNotify> queryAllOperationNotify();

    /**
     * 新增数据
     *
     * @param operationNotify 实例对象
     * @return 实例对象
     */
    int insertOperationNotify(OperationNotify operationNotify);

    /**
     * 修改数据
     *
     * @param operationNotify 实例对象
     * @return 实例对象
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