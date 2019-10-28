package com.ys.hospital.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * (RolePower)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Data
public class RolePower implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer rolePowerId;
    //外键：角色id
    private Integer roleId;
    //外键：权限id
    private Integer powerId;

    private Role role;

    private Power power;

}