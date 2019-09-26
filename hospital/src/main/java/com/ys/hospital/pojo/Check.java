package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Check)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class Check implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer checkId;
    //1:已处理；0：未处理
    private Integer checkStatus;
    
    private Date checkTime;
    //检查总费用
    private Double checkPrice;
    //带领检查的护士
    private Integer employeeId;
    
    private Integer diagnosisId;
    
}