package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.CheckItem;
import com.ys.hospital.dao.CheckItemMapper;
import com.ys.hospital.service.CheckItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CheckItem)表服务实现类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Service("checkItemService")
public class CheckItemServiceImpl implements CheckItemService {
    private static final Logger logger = LoggerFactory.getLogger(CheckItemServiceImpl.class);
    
    @Resource
    private CheckItemMapper checkItemMapper;

    /**
     * 查询所有CheckItem信息
     *
     * @return 对象CheckItem列表
     */
    @Override
    public List<CheckItem> queryAllCheckItem() {
        return this.checkItemMapper.queryAllCheckItem();
    }

    /**
     * 新增CheckItem数据
     *
     * @param checkItem 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertCheckItem(CheckItem checkItem) {
        return this.checkItemMapper.insertCheckItem(checkItem);
    }

    /**
     * 修改CheckItem数据
     *
     * @param checkItem 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateCheckItem(CheckItem checkItem) {
        return this.checkItemMapper.updateCheckItem(checkItem);
    }

    /**
     * 通过主键删除CheckItem数据
     *
     * @param checkItemId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteCheckItemById(Integer checkItemId) {
        return this.checkItemMapper.deleteCheckItemById(checkItemId);
    }
}