package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Operation)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer operationId;
    
    private String operationName;
    //协助者
    private String operationAssistant;
    //麻醉师
    private String operationAnesthetist;
    //所用药品
    private String operationMedicine;
    //所用设备
    private String operationDevice;
    
    private Date operationTime;
    //1:已处理；0：未处理
    private Integer operationStatus;
    
    private String operationDescription;
    
    private Integer operationNotifyId;
    
    private Integer roomId;
    //手术费用
    private Double operationPrice;
    //支付时间
    private Date operationPayTime;
    //1：已支付；0：未支付
    private Integer operationPayStatus;
    
}