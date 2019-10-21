package com.ys.hospital.pojo;

import java.io.Serializable;

import lombok.Data;

/**
 * (PowerDetail)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Data
public class PowerDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    //权限具体表的id
    private Integer powerDetailId;
    //具体权限的名称
    private String powerDetailName;
    //具体权限状态；1：有权限，0：没有权限
    private Integer powerDetailStatus;
    //外键：权限表的id
    private Integer powerId;

}