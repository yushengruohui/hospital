package com.ys.hospital.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * (Queue)实体类
 *
 * @author yusheng
 * @since 2019-10-13 23:31:11
 */
@Data
public class Queue implements Serializable {
    private static final long serialVersionUID = 1L;
    //摇号记录的主键
    private Integer queue_Id;
    //序列号
    private Integer queueNumber;
    //当前日期
    private String queueTime;
    //患者id
    private Integer patientId;
    //医师id
    private Integer employeeId;

}