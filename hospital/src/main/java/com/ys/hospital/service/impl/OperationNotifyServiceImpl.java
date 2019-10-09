package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.OperationNotify;
import com.ys.hospital.dao.OperationNotifyMapper;
import com.ys.hospital.service.OperationNotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OperationNotify)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Service("operationNotifyService")
public class OperationNotifyServiceImpl implements OperationNotifyService {
    private static final Logger logger = LoggerFactory.getLogger(OperationNotifyServiceImpl.class);
    
    @Resource
    private OperationNotifyMapper operationNotifyMapper;

    /**
     * 查询所有OperationNotify信息
     *
     * @return 对象OperationNotify列表
     */
    @Override
    public List<OperationNotify> queryAllOperationNotify() {
        return this.operationNotifyMapper.queryAllOperationNotify();
    }

    /**
     * 新增OperationNotify数据
     *
     * @param operationNotify 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertOperationNotify(OperationNotify operationNotify) {
        return this.operationNotifyMapper.insertOperationNotify(operationNotify);
    }

    /**
     * 修改OperationNotify数据
     *
     * @param operationNotify 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateOperationNotify(OperationNotify operationNotify) {
        return this.operationNotifyMapper.updateOperationNotify(operationNotify);
    }

    /**
     * 通过主键删除OperationNotify数据
     *
     * @param operationNotifyId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteOperationNotifyById(Integer operationNotifyId) {
        return this.operationNotifyMapper.deleteOperationNotifyById(operationNotifyId);
    }
}