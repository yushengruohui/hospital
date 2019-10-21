package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Medicine;
import com.ys.hospital.dao.MedicineMapper;
import com.ys.hospital.service.MedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Medicine)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Service("medicineService")
public class MedicineServiceImpl implements MedicineService {
    private static final Logger logger = LoggerFactory.getLogger(MedicineServiceImpl.class);

    @Resource
    private MedicineMapper medicineMapper;

    /**
     * 查询所有Medicine信息
     *
     * @return 对象Medicine列表
     */
    @Override
    public List<Medicine> queryAllMedicine() {
        return this.medicineMapper.queryAllMedicine();
    }

    /**
     * 新增Medicine数据
     *
     * @param medicine 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int insertMedicine(Medicine medicine) {
        return this.medicineMapper.insertMedicine(medicine);
    }

    /**
     * 修改Medicine数据
     *
     * @param medicine 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int updateMedicine(Medicine medicine) {
        return this.medicineMapper.updateMedicine(medicine);
    }

    /**
     * 通过主键删除Medicine数据
     *
     * @param medicineId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int deleteMedicineById(Integer medicineId) {
        return this.medicineMapper.deleteMedicineById(medicineId);
    }
}