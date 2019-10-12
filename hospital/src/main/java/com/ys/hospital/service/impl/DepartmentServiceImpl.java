package com.ys.hospital.service.impl;

import com.ys.hospital.dao.DepartmentMapper;
import com.ys.hospital.pojo.Department;
import com.ys.hospital.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Department)表服务实现类
 *
 * @author makejava
 * @since 2019-10-10 17:36:23
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepartmentList() {

        return departmentMapper.getDepartmentList();

    }
}