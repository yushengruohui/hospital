package com.ys.hospital.service;

import com.ys.hospital.pojo.Title;
import java.util.List;

/**
 * (Title)表服务接口
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
public interface TitleService {

    /**
     * 查询所有Title信息
     *
     * @return 实例对象
     */
    List<Title> queryAllTitle();

    /**
     * 新增数据
     *
     * @param title 实例对象
     * @return 实例对象
     */
    int insertTitle(Title title);

    /**
     * 修改数据
     *
     * @param title 实例对象
     * @return 实例对象
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