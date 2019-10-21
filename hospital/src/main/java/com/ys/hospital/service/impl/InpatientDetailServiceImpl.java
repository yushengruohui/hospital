package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.InpatientDetail;
import com.ys.hospital.dao.InpatientDetailMapper;
import com.ys.hospital.service.InpatientDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (InpatientDetail)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Service("inpatientDetailService")
public class InpatientDetailServiceImpl implements InpatientDetailService {
    private static final Logger logger = LoggerFactory.getLogger(InpatientDetailServiceImpl.class);

    @Resource
    private InpatientDetailMapper inpatientDetailMapper;

    /**
     * 查询所有InpatientDetail信息
     *
     * @return 对象InpatientDetail列表
     */
    @Override
    public List<InpatientDetail> queryAllInpatientDetail() {
        return this.inpatientDetailMapper.queryAllInpatientDetail();
    }

    /**
     * 新增InpatientDetail数据
     *
     * @param inpatientDetail 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int insertInpatientDetail(InpatientDetail inpatientDetail) {
        return this.inpatientDetailMapper.insertInpatientDetail(inpatientDetail);
    }

    /**
     * 修改InpatientDetail数据
     *
     * @param inpatientDetail 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int updateInpatientDetail(InpatientDetail inpatientDetail) {
        return this.inpatientDetailMapper.updateInpatientDetail(inpatientDetail);
    }

    /**
     * 通过主键删除InpatientDetail数据
     *
     * @param inpatientDetailId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int deleteInpatientDetailById(Integer inpatientDetailId) {
        return this.inpatientDetailMapper.deleteInpatientDetailById(inpatientDetailId);
    }
}