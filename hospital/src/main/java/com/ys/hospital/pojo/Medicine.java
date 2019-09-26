package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (Medicine)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class Medicine implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer medicineId;
    
    private String medicineName;
    
    private String medicineType;
    //该药的销售价格
    private Double medicinePrice;
    
    private Integer medicineInventory;
    
    private String medicine_ efficacy;
    
}