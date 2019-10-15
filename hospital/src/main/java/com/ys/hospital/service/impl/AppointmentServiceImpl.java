package com.ys.hospital.service.impl;

import com.ys.hospital.dao.AppointmentMapper;
import com.ys.hospital.pojo.Appointment;
import com.ys.hospital.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Appointment)表服务实现类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {
    private static final Logger logger = LoggerFactory.getLogger(AppointmentServiceImpl.class);

    @Resource
    private AppointmentMapper appointmentMapper;

    /**
     * 查询所有Appointment信息
     *
     * @return 对象Appointment列表
     */
    @Override
    public List<Appointment> queryAllAppointment() {
        return this.appointmentMapper.queryAllAppointment();
    }

    /**
     * 新增Appointment数据
     *
     * @param appointment 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int insertAppointment(Appointment appointment) {
        return this.appointmentMapper.insertAppointment(appointment);
    }

    /**
     * 修改Appointment数据
     *
     * @param appointment 实例对象
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int updateAppointment(Appointment appointment) {
        return this.appointmentMapper.updateAppointment(appointment);
    }

    /**
     * 通过主键删除Appointment数据
     *
     * @param appointmentId 主键
     * @return 是否成功(1 ： 成功 | 0 ： 失败)
     */
    @Override
    public int deleteAppointmentById(Integer appointmentId) {
        return this.appointmentMapper.deleteAppointmentById(appointmentId);
    }

    @Override
    public List<Appointment> findUntreatedAppointment(Integer employeeId) {
        if (employeeId == null) {
            return null;
        }
        Appointment appointment = new Appointment();
        appointment.setEmployeeId(employeeId);
        appointment.setAppointmentStatus(0);
        return appointmentMapper.queryAppointmentByParam(appointment);
    }

    @Override
    public List<Appointment> findTreatedAppointment(Integer employeeId) {
        if (employeeId == null) {
            return null;
        }
        Appointment appointment = new Appointment();
        appointment.setEmployeeId(employeeId);
        appointment.setAppointmentStatus(1);
        return appointmentMapper.queryAppointmentByParam(appointment);
    }
}