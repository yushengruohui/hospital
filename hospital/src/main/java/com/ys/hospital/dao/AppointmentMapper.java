package com.ys.hospital.dao;

import com.ys.hospital.pojo.Appointment;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Appointment)表数据库访问层
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
public interface AppointmentMapper {

    /**
     * 查询所有Appointment信息
     *
     * @return 对象Appointment列表
     */
    List<Appointment> queryAllAppointment();


    /**
     * 根据实体类Appointment的相关属性查询实体类Appointment
     *
     * @param appointment 实例对象
     * @return 对象Appointment列表
     */
    List<Appointment> queryAppointmentByParam(Appointment appointment);

    /**
     * 新增Appointment数据
     *
     * @param appointment 实例对象
     * @return 是否成功(1：成功|0：失败)
     */
    int insertAppointment(Appointment appointment);

    /**
     * 修改Appointment数据
     *
     * @param appointment 实例对象
     * @return 是否成功(1：成功|0：失败)
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