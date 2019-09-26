package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (AiPrescription)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class AiPrescription implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer aiPrescriptionId;
    
    private String aiPrescriptionKey;
    
    private Date aiPrescriptionTime;
    
    private String aiPrescriptionCreator;
    
    private Date aiPrescriptionModifyTime;
    
    private String aiPrescriptionModifyEmployee;
    
    private Integer medicineNumber;
    
    private Integer medicineId;
    
}