package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.MedicineDetail;
import com.ys.hospital.dao.MedicineDetailMapper;
import com.ys.hospital.service.MedicineDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MedicineDetail)表服务实现类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Service("medicineDetailService")
public class MedicineDetailServiceImpl implements MedicineDetailService {
    private static final Logger logger = LoggerFactory.getLogger(MedicineDetailServiceImpl.class);
    
    @Resource
    private MedicineDetailMapper medicineDetailMapper;

    /**
     * 查询所有MedicineDetail信息
     *
     * @return 对象MedicineDetail列表
     */
    @Override
    public List<MedicineDetail> queryAllMedicineDetail() {
        return this.medicineDetailMapper.queryAllMedicineDetail();
    }

    /**
     * 新增MedicineDetail数据
     *
     * @param medicineDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertMedicineDetail(MedicineDetail medicineDetail) {
        return this.medicineDetailMapper.insertMedicineDetail(medicineDetail);
    }

    /**
     * 修改MedicineDetail数据
     *
     * @param medicineDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateMedicineDetail(MedicineDetail medicineDetail) {
        return this.medicineDetailMapper.updateMedicineDetail(medicineDetail);
    }

    /**
     * 通过主键删除MedicineDetail数据
     *
     * @param medicineDetailId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteMedicineDetailById(Integer medicineDetailId) {
        return this.medicineDetailMapper.deleteMedicineDetailById(medicineDetailId);
    }
}