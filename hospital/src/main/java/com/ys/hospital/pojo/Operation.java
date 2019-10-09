package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Operation)实体类
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Data
public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer operationId;
    //手术名称
    private String operationName;
    //协助者
    private String operationAssistant;
    //麻醉师
    private String operationAnesthetist;
    //所用药品
    private String operationMedicine;
    //所用设备
    private String operationDevice;
    //手术时间
    private Date operationTime;
    //1:已处理；0：未处理
    private Integer operationStatus;
    //手术描述
    private String operationDescription;
    //所属手术通知
    private Integer operationNotifyId;
    //所在的手术室
    private Integer roomId;
    //手术费用
    private Double operationPrice;
    //支付时间
    private Date operationPayTime;
    //1：已支付；0：未支付
    private Integer operationPayStatus;
    
}