package com.ys.hospital.service;

import com.ys.hospital.pojo.CheckItem;
import java.util.List;

/**
 * (CheckItem)表服务接口
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
public interface CheckItemService {

    /**
     * 查询所有CheckItem信息
     *
     * @return 实例对象
     */
    List<CheckItem> queryAllCheckItem();

    /**
     * 新增数据
     *
     * @param checkItem 实例对象
     * @return 实例对象
     */
    int insertCheckItem(CheckItem checkItem);

    /**
     * 修改数据
     *
     * @param checkItem 实例对象
     * @return 实例对象
     */
    int updateCheckItem(CheckItem checkItem);

    /**
     * 通过主键删除数据
     *
     * @param checkItemId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteCheckItemById(Integer checkItemId);

}