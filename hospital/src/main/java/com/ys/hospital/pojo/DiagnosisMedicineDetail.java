package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (DiagnosisMedicineDetail)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class DiagnosisMedicineDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer diagnosisMedicineDetailId;
    
    private Integer medicineId;
    
    private Integer medicineNumber;
    
    private Integer diagnosisMedicineId;
    
}