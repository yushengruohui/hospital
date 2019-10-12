package com.ys.hospital.service.impl;

import com.ys.hospital.pojo.Branch;
import com.ys.hospital.dao.BranchMapper;
import com.ys.hospital.service.BranchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Branch)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-12 17:58:02
 */
@Service("branchService")
public class BranchServiceImpl implements BranchService {
    private static final Logger logger = LoggerFactory.getLogger(BranchServiceImpl.class);
    
    @Resource
    private BranchMapper branchMapper;

    /**
     * 查询所有Branch信息
     *
     * @return 对象Branch列表
     */
    @Override
    public List<Branch> queryAllBranch() {
        return this.branchMapper.queryAllBranch();
    }

    /**
     * 新增Branch数据
     *
     * @param branch 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int insertBranch(Branch branch) {
        return this.branchMapper.insertBranch(branch);
    }

    /**
     * 修改Branch数据
     *
     * @param branch 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int updateBranch(Branch branch) {
        return this.branchMapper.updateBranch(branch);
    }

    /**
     * 通过主键删除Branch数据
     *
     * @param branchId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    @Override
    public int deleteBranchById(Integer branchId) {
        return this.branchMapper.deleteBranchById(branchId);
    }
}