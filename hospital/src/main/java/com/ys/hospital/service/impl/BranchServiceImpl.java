package com.ys.hospital.service.impl;

import com.ys.hospital.dao.BranchMapper;
import com.ys.hospital.pojo.Branch;
import com.ys.hospital.service.BranchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Branch)表服务实现类
 *
 * @author makejava
 * @since 2019-10-11 09:31:05
 */
@Service("branchService")
public class BranchServiceImpl implements BranchService {
    private static final Logger logger = LoggerFactory.getLogger(BranchServiceImpl.class);

    @Autowired
    private BranchMapper branchMapper;

    @Override
    public List<Branch> getBranchListByDepartmentId(int departmentId) {
        return branchMapper.getBranchListByDepartmentId(departmentId);
    }
}