package com.ys.hospital.dao;

import com.ys.hospital.pojo.Branch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Branch)表数据库访问层
 *
 * @author makejava
 * @since 2019-10-11 09:31:05
 */
public interface BranchMapper {
    /**
     * 根据父科目id查询其所有子科目
     *
     * @param departmentId
     * @return branchList
     */
    public List<Branch> getBranchListByDepartmentId(int departmentId);
}