package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.DiagnosisMedicine;
import com.ys.hospital.dao.DiagnosisMedicineMapper;
import com.ys.hospital.service.DiagnosisMedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DiagnosisMedicine)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Service("diagnosisMedicineService")
public class DiagnosisMedicineServiceImpl implements DiagnosisMedicineService {
    private static final Logger logger = LoggerFactory.getLogger(DiagnosisMedicineServiceImpl.class);

    @Resource
    private DiagnosisMedicineMapper diagnosisMedicineMapper;

    /**
     * 查询所有DiagnosisMedicine信息
     *
     * @return 对象DiagnosisMedicine列表
     */
    @Override
    public List<DiagnosisMedicine> queryAllDiagnosisMedicine() {
        return this.diagnosisMedicineMapper.queryAllDiagnosisMedicine();
    }

    /**
     * 新增DiagnosisMedicine数据
     *
     * @param diagnosisMedicine 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int insertDiagnosisMedicine(DiagnosisMedicine diagnosisMedicine) {
        return this.diagnosisMedicineMapper.insertDiagnosisMedicine(diagnosisMedicine);
    }

    /**
     * 修改DiagnosisMedicine数据
     *
     * @param diagnosisMedicine 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int updateDiagnosisMedicine(DiagnosisMedicine diagnosisMedicine) {
        return this.diagnosisMedicineMapper.updateDiagnosisMedicine(diagnosisMedicine);
    }

    /**
     * 通过主键删除DiagnosisMedicine数据
     *
     * @param diagnosisMedicineId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int deleteDiagnosisMedicineById(Integer diagnosisMedicineId) {
        return this.diagnosisMedicineMapper.deleteDiagnosisMedicineById(diagnosisMedicineId);
    }
}