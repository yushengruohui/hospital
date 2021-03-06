package com.ys.hospital.service;

import com.ys.hospital.pojo.Branch;

import java.util.List;

/**
 * (Branch)表服务接口
 *
 * @author yusheng
 * @since 2019-10-12 17:58:02
 */
public interface BranchService {

    /**
     * 查询所有Branch信息
     *
     * @return 实例对象
     */
    List<Branch> queryAllBranch();

    /**
     * 新增数据
     *
     * @param branch 实例对象
     * @return 实例对象
     */
    int insertBranch(Branch branch);

    /**
     * 修改数据
     *
     * @param branch 实例对象
     * @return 实例对象
     */
    int updateBranch(Branch branch);

    /**
     * 通过主键删除数据
     *
     * @param branchId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteBranchById(Integer branchId);

    /**
     * 根据父科目id查询其所有子科目
     *
     * @param departmentId
     * @return branchList(子科目列表)
     */
    List<Branch> getBranchListByDepartmentId(int departmentId);

    List<Branch> queryBranchByParam(Branch branch);
}