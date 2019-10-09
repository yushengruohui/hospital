package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (MedicineDetail)实体类
 *
 * @author yusheng
 * @since 2019-09-26 16:16:21
 */
@Data
public class MedicineDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer medicineDetailId;
    
    private String medicineDetailValid;
    //组成成分
    private String medicineDetailComponents;
    
    private Date medicineDetailProductionDate;
    
    private String medicineDetailProductionAddress;
    
    private Integer medicineId;
    
}