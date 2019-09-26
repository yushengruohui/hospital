package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Purchase;
import com.ys.hospital.dao.PurchaseMapper;
import com.ys.hospital.service.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Purchase)表服务实现类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:46
 */
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);
    
    @Resource
    private PurchaseMapper purchaseMapper;

    /**
     * 查询所有Purchase信息
     *
     * @return 对象Purchase列表
     */
    @Override
    public List<Purchase> queryAllPurchase() {
        return this.purchaseMapper.queryAllPurchase();
    }

    /**
     * 新增Purchase数据
     *
     * @param purchase 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertPurchase(Purchase purchase) {
        return this.purchaseMapper.insertPurchase(purchase);
    }

    /**
     * 修改Purchase数据
     *
     * @param purchase 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updatePurchase(Purchase purchase) {
        return this.purchaseMapper.updatePurchase(purchase);
    }

    /**
     * 通过主键删除Purchase数据
     *
     * @param purchaseId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deletePurchaseById(Integer purchaseId) {
        return this.purchaseMapper.deletePurchaseById(purchaseId);
    }
}