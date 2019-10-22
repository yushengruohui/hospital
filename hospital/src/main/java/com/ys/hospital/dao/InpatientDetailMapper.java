package com.ys.hospital.dao;

import com.ys.hospital.pojo.InpatientDetail;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (InpatientDetail)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface InpatientDetailMapper {

    /**
     * 查询所有InpatientDetail信息
     *
     * @return 对象InpatientDetail列表
     */
    List<InpatientDetail> queryAllInpatientDetail();


    /**
     * 根据实体类InpatientDetail的相关属性查询实体类InpatientDetail
     *
     * @param inpatientDetail 实例对象
     * @return 对象InpatientDetail列表
     */
    List<InpatientDetail> queryInpatientDetailByParam(InpatientDetail inpatientDetail);

    /**
     * 新增InpatientDetail数据
     *
     * @param inpatientDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertInpatientDetail(InpatientDetail inpatientDetail);

    /**
     * 修改InpatientDetail数据
     *
     * @param inpatientDetail 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int updateInpatientDetail(InpatientDetail inpatientDetail);

    /**
     * 通过主键删除数据
     *
     * @param inpatientDetailId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteInpatientDetailById(Integer inpatientDetailId);

    /**
     * 通过住院表ID查询住院明细
     * @param inpatientId
     * @return
     */
    List<InpatientDetail> queryInpatientDetailByInpatientId(Integer inpatientId);
}