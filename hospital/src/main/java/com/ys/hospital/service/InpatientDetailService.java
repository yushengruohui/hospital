package com.ys.hospital.service;

import com.ys.hospital.pojo.InpatientDetail;
import java.util.List;

/**
 * (InpatientDetail)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface InpatientDetailService {

    /**
     * 查询所有InpatientDetail信息
     *
     * @return 实例对象
     */
    List<InpatientDetail> queryAllInpatientDetail();

    /**
     * 新增数据
     *
     * @param inpatientDetail 实例对象
     * @return 实例对象
     */
    int insertInpatientDetail(InpatientDetail inpatientDetail);

    /**
     * 修改数据
     *
     * @param inpatientDetail 实例对象
     * @return 实例对象
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