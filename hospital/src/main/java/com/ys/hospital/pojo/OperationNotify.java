package com.ys.hospital.pojo;

import java.io.Serializable;

import lombok.Data;

/**
 * (OperationNotify)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Data
public class OperationNotify implements Serializable {
    private static final long serialVersionUID = 1L;
    //手术通知id
    private Integer operationNotifyId;
    //1:已处理；0：未处理
    private Integer operationNotifyStatus;
    //所属诊断id
    private Integer diagnosisId;
    //主刀医师id
    private Integer employeeId;

}