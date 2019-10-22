package com.ys.hospital.pojo;

import java.io.Serializable;

import lombok.Data;

/**
 * (Power)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Data
public class Power implements Serializable {
    private static final long serialVersionUID = 1L;
    //权限相关操作都是1：有权限；0：无权限
    private Integer powerId;
    //权限类型：对应某功能模块
    private String powerType;
    //是否拥有某功能模块的权限：1：有权限，0：无权限
    private Integer powerStatus;

}