package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (AiPrescription)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class AiPrescription implements Serializable {
    private static final long serialVersionUID = 1L;
    //智能处方id
    private Integer aiPrescriptionId;
    //智能处方关键字
    private String aiPrescriptionKey;
    //处方创建时间
    private Date aiPrescriptionTime;
    //处方创建者
    private String aiPrescriptionCreator;
    //处方修改时间
    private Date aiPrescriptionModifyTime;
    //处方修改人员
    private String aiPrescriptionModifyEmployee;
    //智能处方内容
    private String aiPrescriptionContent;
    
}