package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Purchase)实体类
 *
 * @author yusheng
 * @since 2019-09-26 16:16:22
 */
@Data
public class Purchase implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer purchaseId;
    
    private Date purchaseEntryTime;
    
    private Double purchaseEntryPrice;
    
    private String purchaseProvider;
    
    private Integer medicineId;
    
}