package com.ys.hospital.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * (PowerDetail)实体类
 *
 * @author yusheng
 * @create-time 2019-10-27 17:58:50
 */
@Data
public class PowerDetail implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 权限具体表的id
     */
    private Integer powerDetailId;

    /**
     * 具体权限的名称
     */
    private String powerDetailName;

    /**
     * 具体权限状态；1：有权限，0：没有权限
     */
    private Integer powerDetailStatus;

    /**
     * 访问url的方式[POST||DELETE||GET||PUT||ALL]
     */
    private String powerDetailMethod;

    /**
     * 拥有权限，放行的url
     */
    private String powerDetailUrl;

    /**
     * 描述该权限
     */
    private String powerDetailDescription;

    /**
     * 外键：权限表的id
     */
    private Integer powerId;


}