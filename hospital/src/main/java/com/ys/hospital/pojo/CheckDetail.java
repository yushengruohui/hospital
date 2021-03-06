package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

/**
 * (CheckDetail)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class CheckDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    //一个检查详情
    private Integer checkDetailId;
    //所属检查总表
    private Integer checkId;
    //一个检查项
    private Integer checkItemId;
    //检查结果
    private String checkDetailResult;
    //1：已支付；0：未支付
    private Integer checkDetailPayStatus;
    //一个检查项的费用
    private Double checkDetailPayPrice;
    //支付时间
    private Date checkDetailPayTime;

    private Diagnosis diagnosis;
    
    private Appointment appointment;
    
    private Patient patient;
    
    private CheckItem checkItem;
    
    private Room room;
    
    private Employee employee;
}