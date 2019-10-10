package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.EmployeeDetail;
import com.ys.hospital.dao.EmployeeDetailMapper;
import com.ys.hospital.service.EmployeeDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EmployeeDetail)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Service("employeeDetailService")
public class EmployeeDetailServiceImpl implements EmployeeDetailService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDetailServiceImpl.class);
    
    @Resource
    private EmployeeDetailMapper employeeDetailMapper;

    /**
     * 查询所有EmployeeDetail信息
     *
     * @return 对象EmployeeDetail列表
     */
    @Override
    public List<EmployeeDetail> queryAllEmployeeDetail() {
        return this.employeeDetailMapper.queryAllEmployeeDetail();
    }

    /**
     * 新增EmployeeDetail数据
     *
     * @param employeeDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertEmployeeDetail(EmployeeDetail employeeDetail) {
        return this.employeeDetailMapper.insertEmployeeDetail(employeeDetail);
    }

    /**
     * 修改EmployeeDetail数据
     *
     * @param employeeDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateEmployeeDetail(EmployeeDetail employeeDetail) {
        return this.employeeDetailMapper.updateEmployeeDetail(employeeDetail);
    }

    /**
     * 通过主键删除EmployeeDetail数据
     *
     * @param employeeDetailId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteEmployeeDetailById(Integer employeeDetailId) {
        return this.employeeDetailMapper.deleteEmployeeDetailById(employeeDetailId);
    }
}