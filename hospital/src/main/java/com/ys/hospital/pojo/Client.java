package com.ys.hospital.pojo;

import java.io.Serializable;

import lombok.Data;

/**
 * (Client)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    // 登录用户id
    private Integer clientId;
    //登录用户账号
    private String clientPhone;
    //登录密码
    private String clientPassword;

}