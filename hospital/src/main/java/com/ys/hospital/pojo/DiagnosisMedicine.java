package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

/**
 * (DiagnosisMedicine)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class DiagnosisMedicine implements Serializable {
    private static final long serialVersionUID = 1L;
    //处方
    private Integer diagnosisMedicineId;
    //医药费
    private Double diagnosisMedicinePrice;
    //1:已处理；0：未处理
    private Integer diagnosisMedicineStatus;
    //支付时间
    private Date diagnosisMedicinePayTime;
    //1：已支付；0：未支付
    private Integer diagnosisMedicinePayStatus;
    //发药药师
    private Integer employeeId;
    //所属诊断单
    private Integer diagnosisId;
    private Diagnosis diagnosis;
    private Employee employee;

}