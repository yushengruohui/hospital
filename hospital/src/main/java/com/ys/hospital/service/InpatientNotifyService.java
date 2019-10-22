package com.ys.hospital.service;

import com.ys.hospital.pojo.InpatientNotify;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (InpatientNotify)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
public interface InpatientNotifyService {

    /**
     * 查询所有InpatientNotify信息
     *
     * @return 实例对象
     */
    List<InpatientNotify> queryAllInpatientNotify();

    /**
     * 通过登陆人Id查询未处理住院通知
     * @param
     * @param inpatientNotifyStatus
     * @return
     */
    List<InpatientNotify> queryInpatientNotifyByEmployeeId(Integer inpatientNotifyStatus);

    /**
     * 新增数据
     *
     * @param inpatientNotify 实例对象
     * @return 实例对象
     */
    int insertInpatientNotify(InpatientNotify inpatientNotify);

    /**
     * 修改数据
     *
     * @param inpatientNotify 实例对象
     * @return 实例对象
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