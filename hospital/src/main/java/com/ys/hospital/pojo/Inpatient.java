package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Inpatient)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class Inpatient implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer inpatientId;
    
    private Date inpatientEntryTime;
    
    private Date inpatientLeaveTime;
    //1：已处理；0:未处理
    private Integer inpatientStatus;
    
    private Integer inpatientNotifyId;
    
    private Integer bedId;
    //住院总费用
    private Double inpatientPrice;
    //1：已支付；0：未支付
    private Integer inpatientPayStatus;
    //患者预交费用
    private Double inpatientPrepaidPrice;
    
}