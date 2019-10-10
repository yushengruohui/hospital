package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Inpatient)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class Inpatient implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer inpatientId;
    //入院时间
    private Date inpatientEntryTime;
    //离院时间
    private Date inpatientLeaveTime;
    //1：已处理；0:未处理
    private Integer inpatientStatus;
    //所属住院通知
    private Integer inpatientNotifyId;
    //病床id
    private Integer bedId;
    //住院总费用
    private Double inpatientPrice;
    //1：已支付；0：未支付
    private Integer inpatientPayStatus;
    //患者预交费用
    private Double inpatientPrepaidPrice;
    
}