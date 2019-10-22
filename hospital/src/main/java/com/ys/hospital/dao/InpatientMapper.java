package com.ys.hospital.dao;

import com.ys.hospital.pojo.Inpatient;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Inpatient)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface InpatientMapper {

    /**
     * 查询所有Inpatient信息
     *
     * @return 对象Inpatient列表
     */
    List<Inpatient> queryAllInpatient();


    /**
     * 根据实体类Inpatient的相关属性查询实体类Inpatient
     *
     * @param inpatient 实例对象
     * @return 对象Inpatient列表
     */
    List<Inpatient> queryInpatientByParam(Inpatient inpatient);

    /**
     * 新增Inpatient数据
     *
     * @param inpatient 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertInpatient(Inpatient inpatient);

    /**
     * 通过住院表ID查询住院信息
     * @param inpatientId
     * @return
     */
    List<Inpatient> queryInpatientByInpatientId(Integer inpatientId);

    /**
     * 修改Inpatient数据
     *
     * @param inpatient 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int updateInpatient(Inpatient inpatient);

    /**
     * 通过主键删除数据
     *
     * @param inpatientId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteInpatientById(Integer inpatientId);

}