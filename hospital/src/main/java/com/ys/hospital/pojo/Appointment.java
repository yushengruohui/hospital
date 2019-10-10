package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Appointment)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer appointmentId;
    //预约时间段
    private Date appointmentTime;
    //1:已处理；0：未处理
    private Integer appointmentStatus;
    //患者
    private Integer patientId;
    //主治医师
    private Integer employeeId;
    //科室
    private Integer branchId;
    //预约费用
    private Double appointmentPrice;
    //支付时间
    private Date appointmentPayTime;
    
}