package com.ys.hospital.dao;

import com.ys.hospital.pojo.Title;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Title)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
public interface TitleMapper {

    /**
     * 查询所有Title信息
     *
     * @return 对象Title列表
     */
    List<Title> queryAllTitle();


    /**
     * 根据实体类Title的相关属性查询实体类Title
     *
     * @param title 实例对象
     * @return 对象Title列表
     */
    List<Title> queryTitleByParam(Title title);

    /**
     * 新增Title数据
     *
     * @param title 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertTitle(Title title);

    /**
     * 修改Title数据
     *
     * @param title 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int updateTitle(Title title);

    /**
     * 通过主键删除数据
     *
     * @param titleId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteTitleById(Integer titleId);

}