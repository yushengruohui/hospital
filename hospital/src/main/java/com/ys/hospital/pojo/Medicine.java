package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Medicine)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Data
public class Medicine implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer medicineId;
    //药名
    private String medicineName;
    //药品类型
    private String medicineType;
    //使用说明
    private String medicineUse;
    //该药的销售价格
    private Double medicinePrice;
    //库存
    private Integer medicineInventory;
    //功效
    private String medicineEfficacy;
    //有效期
    private String medicineValid;
    //组成成分
    private String medicineComponents;
    //生产日期
    private Date medicineProductionDate;
    //生产地址
    private String medicineProductionAddress;
    //规格
    private String medicineSpecifications;
    //性状
    private String medicineCharacter;
    //药品相冲
    private String medicineConfict;
    //储存方式
    private String medicineSave;
    //审批文号
    private String medicineApproval;
    
}