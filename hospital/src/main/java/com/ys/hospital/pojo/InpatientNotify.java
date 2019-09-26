package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (InpatientNotify)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class InpatientNotify implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer inpatientNotifyId;
    //1：已处理；0：未处理
    private Integer inpatientNotifyStatus;
    //处理住院时间
    private Date inpatientDealTime;
    
    private Integer diagnosisId;
    //处理住院的护士
    private Integer employeeId;
    
}