package com.ys.hospital.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Diagnosis)实体类
 *
 * @author yusheng
 * @since 2019-10-16 17:47:02
 */
@Data
public class Diagnosis implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer diagnosisId;
    //诊断时间
    private Date diagnosisTime;
    //初步诊断为某病
    private String diagnosisContent;
    //处方，包含药品名和数量
    private String diagnosisPrescription;
    //诊断单的状态：已处理|正在处理
    private String diagnosisStatus;
    //1:需要检查；0：不需要检查
    private Integer diagnosisIsCheck;
    //1:需要手术；0：不需要手术
    private Integer diagnosisIsOperation;
    //所属预约单
    private Integer appointmentId;

    private Appointment appointment;
}