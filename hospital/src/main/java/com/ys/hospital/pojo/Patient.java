package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (Patient)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Data
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    //就诊人id
    private Integer patientId;
    //就诊人联系方式
    private String patientPhone;
    //就诊人姓名
    private String patientName;
    //性别
    private String patientGender;
    //身份证
    private String patientIdentity;
    //地址
    private String patientAddress;
    //所属用户id
    private Integer clientId;
    
}