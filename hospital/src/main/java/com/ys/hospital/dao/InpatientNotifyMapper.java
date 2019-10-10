package com.ys.hospital.dao;

import com.ys.hospital.pojo.InpatientNotify;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (InpatientNotify)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface InpatientNotifyMapper {

    /**
     * 查询所有InpatientNotify信息
     *
     * @return 对象InpatientNotify列表
     */
    List<InpatientNotify> queryAllInpatientNotify();


    /**
     * 根据实体类InpatientNotify的相关属性查询实体类InpatientNotify
     *
     * @param inpatientNotify 实例对象
     * @return 对象InpatientNotify列表
     */
    List<InpatientNotify> queryInpatientNotifyByParam(InpatientNotify inpatientNotify);

    /**
     * 新增InpatientNotify数据
     *
     * @param inpatientNotify 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertInpatientNotify(InpatientNotify inpatientNotify);

    /**
     * 修改InpatientNotify数据
     *
     * @param inpatientNotify 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int updateInpatientNotify(InpatientNotify inpatientNotify);

    /**
     * 通过主键删除数据
     *
     * @param inpatientNotifyId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteInpatientNotifyById(Integer inpatientNotifyId);

}