package com.ys.hospital.dao;

import com.ys.hospital.pojo.CheckItem;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (CheckItem)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
public interface CheckItemMapper {

    /**
     * 查询所有CheckItem信息
     *
     * @return 对象CheckItem列表
     */
    List<CheckItem> queryAllCheckItem();


    /**
     * 根据实体类CheckItem的相关属性查询实体类CheckItem
     *
     * @param checkItem 实例对象
     * @return 对象CheckItem列表
     */
    List<CheckItem> queryCheckItemByParam(CheckItem checkItem);

    /**
     * 新增CheckItem数据
     *
     * @param checkItem 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertCheckItem(CheckItem checkItem);

    /**
     * 修改CheckItem数据
     *
     * @param checkItem 实例对象
     * @return 是否成功(1：成功|0：失败)
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