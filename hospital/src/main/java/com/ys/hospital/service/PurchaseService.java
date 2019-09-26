package com.ys.hospital.service;

import com.ys.hospital.pojo.Purchase;
import java.util.List;

/**
 * (Purchase)表服务接口
 *
 * @author yusheng
 * @since 2019-09-26 10:43:46
 */
public interface PurchaseService {

    /**
     * 查询所有Purchase信息
     *
     * @return 实例对象
     */
    List<Purchase> queryAllPurchase();

    /**
     * 新增数据
     *
     * @param purchase 实例对象
     * @return 实例对象
     */
    int insertPurchase(Purchase purchase);

    /**
     * 修改数据
     *
     * @param purchase 实例对象
     * @return 实例对象
     */
    int updatePurchase(Purchase purchase);

    /**
     * 通过主键删除数据
     *
     * @param purchaseId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deletePurchaseById(Integer purchaseId);

}