package com.ys.hospital.dao;

import com.ys.hospital.pojo.Branch;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Branch)表数据库访问层
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
public interface BranchMapper {

    /**
     * 查询所有Branch信息
     *
     * @return 对象Branch列表
     */
    List<Branch> queryAllBranch();


    /**
     * 根据实体类Branch的相关属性查询实体类Branch
     *
     * @param branch 实例对象
     * @return 对象Branch列表
     */
    List<Branch> queryBranchByParam(Branch branch);

    /**
     * 新增Branch数据
     *
     * @param branch 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertBranch(Branch branch);

    /**
     * 修改Branch数据
     *
     * @param branch 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int updateBranch(Branch branch);

    /**
     * 通过主键删除数据
     *
     * @param branchId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteBranchById(Integer branchId);

}