package com.ys.hospital.service;

import com.ys.hospital.pojo.Appointment;
import java.util.List;

/**
 * (Appointment)表服务接口
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
public interface AppointmentService {

    /**
     * 查询所有Appointment信息
     *
     * @return 实例对象
     */
    List<Appointment> queryAllAppointment();

    /**
     * 新增数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    int insertAppointment(Appointment appointment);

    /**
     * 修改数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    int updateAppointment(Appointment appointment);

    /**
     * 通过主键删除数据
     *
     * @param appointmentId 主键
     * @return 是否成功(1：成功|0：失败)
     */
    int deleteAppointmentById(Integer appointmentId);

}