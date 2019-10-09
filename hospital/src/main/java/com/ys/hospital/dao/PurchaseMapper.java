package com.ys.hospital.dao;

import com.ys.hospital.pojo.Purchase;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Purchase)表数据库访问层
 *
 * @author yusheng
 * @since 2019-09-26 16:16:22
 */
public interface PurchaseMapper {

    /**
     * 查询所有Purchase信息
     *
     * @return 对象Purchase列表
     */
    List<Purchase> queryAllPurchase();


    /**
     * 根据实体类Purchase的相关属性查询实体类Purchase
     *
     * @param purchase 实例对象
     * @return 对象Purchase列表
     */
    List<Purchase> queryPurchaseByParam(Purchase purchase);

    /**
     * 新增Purchase数据
     *
     * @param purchase 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertPurchase(Purchase purchase);

    /**
     * 修改Purchase数据
     *
     * @param purchase 实例对象
     * @return 是否成功(1：成功|0：失败)
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