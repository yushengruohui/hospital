package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Check;
import com.ys.hospital.dao.CheckMapper;
import com.ys.hospital.service.CheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Check)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Service("checkService")
public class CheckServiceImpl implements CheckService {
    private static final Logger logger = LoggerFactory.getLogger(CheckServiceImpl.class);

    @Resource
    private CheckMapper checkMapper;

    /**
     * 查询所有Check信息
     *
     * @return 对象Check列表
     */
    @Override
    public List<Check> queryAllCheck() {
        return this.checkMapper.queryAllCheck();
    }

    /**
     * 新增Check数据
     *
     * @param check 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int insertCheck(Check check) {
        return this.checkMapper.insertCheck(check);
    }

    /**
     * 修改Check数据
     *
     * @param check 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int updateCheck(Check check) {
        return this.checkMapper.updateCheck(check);
    }

    /**
     * 通过主键删除Check数据
     *
     * @param checkId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int deleteCheckById(Integer checkId) {
        return this.checkMapper.deleteCheckById(checkId);
    }
}