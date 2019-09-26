package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Diagnosis)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class Diagnosis implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer diagnosisId;
    
    private Date diagnosisTime;
    //初步诊断为某病
    private String diagnosisContent;
    //1:需要检查；0：不需要检查
    private Integer diagnosisIsCheck;
    //1:需要手术；0：不需要手术
    private Integer diagnosisIsOperation;
    
    private Integer appointmentId;
    
}