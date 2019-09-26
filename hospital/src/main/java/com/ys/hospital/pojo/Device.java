package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Device)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class Device implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer deviceId;
    
    private String deviceName;
    
    private Date deviceProductionTime;
    
    private String deviceProductionAddress;
    
    private String deviceDecription;
    //注意事件
    private String deviceAlert;
    
}