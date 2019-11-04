package com.ys.hospital.pojo;

import java.io.Serializable;

import lombok.Data;

/**
 * (DiagnosisMedicineDetail)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class DiagnosisMedicineDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    //诊断药品详情id
    private Integer diagnosisMedicineDetailId;
    //药品Id
    private Integer medicineId;
    //药品数量
    private Integer medicineNumber;
    //所属诊断单药品
    private Integer diagnosisMedicineId;
    private Medicine medicine;

}