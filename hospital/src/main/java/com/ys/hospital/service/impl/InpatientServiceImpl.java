package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Inpatient;
import com.ys.hospital.dao.InpatientMapper;
import com.ys.hospital.service.InpatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Inpatient)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Service("inpatientService")
public class InpatientServiceImpl implements InpatientService {
    private static final Logger logger = LoggerFactory.getLogger(InpatientServiceImpl.class);
    
    @Resource
    private InpatientMapper inpatientMapper;

    /**
     * 查询所有Inpatient信息
     *
     * @return 对象Inpatient列表
     */
    @Override
    public List<Inpatient> queryAllInpatient() {
        return this.inpatientMapper.queryAllInpatient();
    }

    /**
     * 新增Inpatient数据
     *
     * @param inpatient 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertInpatient(Inpatient inpatient) {
        return this.inpatientMapper.insertInpatient(inpatient);
    }

    /**
     * 通过住院表ID查询住院信息
     * @param inpatientId
     * @return
     */
    @Override
    public List<Inpatient> queryInpatientByInpatientId(Integer inpatientId) {
        return this.inpatientMapper.queryInpatientByInpatientId(inpatientId);
    }

    /**
     * 修改Inpatient数据
     *
     * @param inpatient 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateInpatient(Inpatient inpatient) {
        return this.inpatientMapper.updateInpatient(inpatient);
    }

    /**
     * 通过主键删除Inpatient数据
     *
     * @param inpatientId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteInpatientById(Integer inpatientId) {
        return this.inpatientMapper.deleteInpatientById(inpatientId);
    }

    @Override
    public List<Inpatient> queryInpatientByParam(Inpatient inpatient) {
        return this.inpatientMapper.queryInpatientByParam(inpatient);
    }

}