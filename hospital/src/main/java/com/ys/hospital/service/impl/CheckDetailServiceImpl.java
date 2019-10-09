package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.CheckDetail;
import com.ys.hospital.dao.CheckDetailMapper;
import com.ys.hospital.service.CheckDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CheckDetail)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Service("checkDetailService")
public class CheckDetailServiceImpl implements CheckDetailService {
    private static final Logger logger = LoggerFactory.getLogger(CheckDetailServiceImpl.class);
    
    @Resource
    private CheckDetailMapper checkDetailMapper;

    /**
     * 查询所有CheckDetail信息
     *
     * @return 对象CheckDetail列表
     */
    @Override
    public List<CheckDetail> queryAllCheckDetail() {
        return this.checkDetailMapper.queryAllCheckDetail();
    }

    /**
     * 新增CheckDetail数据
     *
     * @param checkDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertCheckDetail(CheckDetail checkDetail) {
        return this.checkDetailMapper.insertCheckDetail(checkDetail);
    }

    /**
     * 修改CheckDetail数据
     *
     * @param checkDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateCheckDetail(CheckDetail checkDetail) {
        return this.checkDetailMapper.updateCheckDetail(checkDetail);
    }

    /**
     * 通过主键删除CheckDetail数据
     *
     * @param checkDetailId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteCheckDetailById(Integer checkDetailId) {
        return this.checkDetailMapper.deleteCheckDetailById(checkDetailId);
    }
}