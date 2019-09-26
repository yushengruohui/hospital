package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (OperationNotify)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class OperationNotify implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer operationNotifyId;
    //1:已处理；0：未处理
    private Integer operationNotifyStatus;
    
    private Integer diagnosisId;
    
    private Integer employeeId;
    
}