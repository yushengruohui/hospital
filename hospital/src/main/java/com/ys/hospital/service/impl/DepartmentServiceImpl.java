package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Department;
import com.ys.hospital.dao.DepartmentMapper;
import com.ys.hospital.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Department)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    
    @Resource
    private DepartmentMapper departmentMapper;

    /**
     * 查询所有Department信息
     *
     * @return 对象Department列表
     */
    @Override
    public List<Department> queryAllDepartment() {
        return this.departmentMapper.queryAllDepartment();
    }

    /**
     * 新增Department数据
     *
     * @param department 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertDepartment(Department department) {
        return this.departmentMapper.insertDepartment(department);
    }

    /**
     * 修改Department数据
     *
     * @param department 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateDepartment(Department department) {
        return this.departmentMapper.updateDepartment(department);
    }

    /**
     * 通过主键删除Department数据
     *
     * @param departmentId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteDepartmentById(Integer departmentId) {
        return this.departmentMapper.deleteDepartmentById(departmentId);
    }
}