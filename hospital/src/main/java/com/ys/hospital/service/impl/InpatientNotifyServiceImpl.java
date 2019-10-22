package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.InpatientNotify;
import com.ys.hospital.dao.InpatientNotifyMapper;
import com.ys.hospital.service.InpatientNotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (InpatientNotify)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Service("inpatientNotifyService")
public class InpatientNotifyServiceImpl implements InpatientNotifyService {
    private static final Logger logger = LoggerFactory.getLogger(InpatientNotifyServiceImpl.class);

    @Resource
    private InpatientNotifyMapper inpatientNotifyMapper;

    /**
     * 查询所有InpatientNotify信息
     *
     * @return 对象InpatientNotify列表
     */
    @Override
    public List<InpatientNotify> queryAllInpatientNotify() {
        return this.inpatientNotifyMapper.queryAllInpatientNotify();
    }

    public List<InpatientNotify> queryInpatientNotifyByEmployeeId(Integer inpatientNotifyStatus){
        return this.inpatientNotifyMapper.queryInpatientNotifyByEmployeeId(inpatientNotifyStatus);
    }
    /**
     * 新增InpatientNotify数据
     *
     * @param inpatientNotify 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int insertInpatientNotify(InpatientNotify inpatientNotify) {
        return this.inpatientNotifyMapper.insertInpatientNotify(inpatientNotify);
    }

    /**
     * 修改InpatientNotify数据
     *
     * @param inpatientNotify 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int updateInpatientNotify(InpatientNotify inpatientNotify) {
        return this.inpatientNotifyMapper.updateInpatientNotify(inpatientNotify);
    }

    /**
     * 通过主键删除InpatientNotify数据
     *
     * @param inpatientNotifyId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int deleteInpatientNotifyById(Integer inpatientNotifyId) {
        return this.inpatientNotifyMapper.deleteInpatientNotifyById(inpatientNotifyId);
    }
}