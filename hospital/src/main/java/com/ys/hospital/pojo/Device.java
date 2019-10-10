package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Device)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class Device implements Serializable {
    private static final long serialVersionUID = 1L;
    //设备id
    private Integer deviceId;
    //设备名称
    private String deviceName;
    //生产日期
    private Date deviceProductionTime;
    //生产地
    private String deviceProductionAddress;
    //设备描述
    private String deviceDecription;
    //注意事件
    private String deviceAlert;
    
}