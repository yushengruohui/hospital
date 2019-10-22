package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Title;
import com.ys.hospital.dao.TitleMapper;
import com.ys.hospital.service.TitleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Title)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Service("titleService")
public class TitleServiceImpl implements TitleService {
    private static final Logger logger = LoggerFactory.getLogger(TitleServiceImpl.class);

    @Resource
    private TitleMapper titleMapper;

    /**
     * 查询所有Title信息
     *
     * @return 对象Title列表
     */
    @Override
    public List<Title> queryAllTitle() {
        return this.titleMapper.queryAllTitle();
    }

    /**
     * 新增Title数据
     *
     * @param title 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int insertTitle(Title title) {
        return this.titleMapper.insertTitle(title);
    }

    /**
     * 修改Title数据
     *
     * @param title 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int updateTitle(Title title) {
        return this.titleMapper.updateTitle(title);
    }

    /**
     * 通过主键删除Title数据
     *
     * @param titleId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int deleteTitleById(Integer titleId) {
        return this.titleMapper.deleteTitleById(titleId);
    }

    /**
     * 根据主键查询title对象
     *
     * @param titleId
     * @return title
     */
    @Override
    public Title getTitleByTitleId(Integer titleId) {
        return this.titleMapper.getTitleByTitleId(titleId);
    }
}