package com.ys.hospital.service;

import com.ys.hospital.pojo.Appointment;

import java.util.List;

/**
 * (Appointment)表服务接口
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
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
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    int deleteAppointmentById(Integer appointmentId);

    List<Appointment> findUntreatedAppointment(Integer employeeId);

    List<Appointment> findTreatedAppointment(Integer employeeId);

    /**
     * 根据实体类Appointment的相关属性查询实体类Appointment
     *
     * @param appointment 实例对象
     * @return 对象Appointment列表
     */
    List<Appointment> queryAppointmentByParam(Appointment appointment);

    /**
     * 根据患者Id查询患者预约记录
     *
     * @param patientId
     * @return
     */
    List<Appointment> getAppointmentListByPatientId(Integer patientId);

    /**
     * 根据预约单id查询预约单信息（级联查询）
     *
     * @param appointmentId
     * @return 预约单信息
     */
    Appointment getAppointmentByAppointmentId(Integer appointmentId);

    int countAppointmentByStatus(Integer status);
}