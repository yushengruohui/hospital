package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.DiagnosisMedicineDetail;
import com.ys.hospital.dao.DiagnosisMedicineDetailMapper;
import com.ys.hospital.service.DiagnosisMedicineDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DiagnosisMedicineDetail)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Service("diagnosisMedicineDetailService")
public class DiagnosisMedicineDetailServiceImpl implements DiagnosisMedicineDetailService {
    private static final Logger logger = LoggerFactory.getLogger(DiagnosisMedicineDetailServiceImpl.class);

    @Resource
    private DiagnosisMedicineDetailMapper diagnosisMedicineDetailMapper;

    /**
     * 查询所有DiagnosisMedicineDetail信息
     *
     * @return 对象DiagnosisMedicineDetail列表
     */
    @Override
    public List<DiagnosisMedicineDetail> queryAllDiagnosisMedicineDetail() {
        return this.diagnosisMedicineDetailMapper.queryAllDiagnosisMedicineDetail();
    }

    /**
     * 新增DiagnosisMedicineDetail数据
     *
     * @param diagnosisMedicineDetail 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int insertDiagnosisMedicineDetail(DiagnosisMedicineDetail diagnosisMedicineDetail) {
        return this.diagnosisMedicineDetailMapper.insertDiagnosisMedicineDetail(diagnosisMedicineDetail);
    }

    /**
     * 修改DiagnosisMedicineDetail数据
     *
     * @param diagnosisMedicineDetail 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int updateDiagnosisMedicineDetail(DiagnosisMedicineDetail diagnosisMedicineDetail) {
        return this.diagnosisMedicineDetailMapper.updateDiagnosisMedicineDetail(diagnosisMedicineDetail);
    }

    /**
     * 通过主键删除DiagnosisMedicineDetail数据
     *
     * @param diagnosisMedicineDetailId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int deleteDiagnosisMedicineDetailById(Integer diagnosisMedicineDetailId) {
        return this.diagnosisMedicineDetailMapper.deleteDiagnosisMedicineDetailById(diagnosisMedicineDetailId);
    }
}