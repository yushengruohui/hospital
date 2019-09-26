package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (Power)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:46
 */
@Data
public class Power implements Serializable {
    private static final long serialVersionUID = 1L;
    //权限相关操作都是1：有权限；0：无权限
    private Integer powerId;
    
    private Integer powerLogin;
    
    private Integer powerUpdate;
    
    private Integer powerDetele;
    
    private Integer positionId;
    
    private Integer employeeDetailStatus;
    
}