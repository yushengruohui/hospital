package com.ys.hospital.service;


import com.ys.hospital.pojo.Branch;

import java.util.List;

/**
 * (Branch)表服务接口
 *
 * @author makejava
 * @since 2019-10-11 09:31:05
 */
public interface BranchService {
    /**
     * 根据父科目id查询其所有子科目
     *
     * @param departmentId
     * @return branchList(子科目列表)
     */
    public List<Branch> getBranchListByDepartmentId(int departmentId);
}