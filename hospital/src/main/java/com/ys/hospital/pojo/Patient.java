package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (Patient)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer patientId;
    
    private String patientPhone;
    
    private String patientName;
    
    private String patientGender;
    
    private String patientIdentity;
    
    private String patientAddress;
    
    private Integer clientId;
    
}